import React, { useState } from "react";
import DatePicker, { registerLocale } from "react-datepicker";
import { Container, Row, Col, FormGroup, Button} from "reactstrap";
import es from 'date-fns/locale/es';
import "react-datepicker/dist/react-datepicker.css";
import ModalOffers from 'components/ModalOffers';
import ModalForm from 'components/ModalForm';
import SummaryPricesList from 'components/SummaryPricesList';
import { fetchFinalPriceAndOffers } from '../../actions/pricesActions';
import { fetchPostBooking } from '../../actions/bookingsActions';
import { dtoBookingPrices, dtoBooking } from '../../dto/dtoBooking';
import { dtoOffersPrices } from '../../dto/dtoOffersPrices';


registerLocale('es', es);

function DetailsFormSection(props) {
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [detailPrices, setDetailPrices] = useState(new dtoOffersPrices());
    const [modalOffers, setModalOffers] = React.useState(false);
    const [modalForm, setModalForm] = React.useState(false);

    const onChange = dates => {
        const [start, end] = dates;
        setStartDate(start);
        setEndDate(end);

        if (start != startDate) {
            setDetailPrices(new dtoOffersPrices());
        }
        else if (end) {
            let dto = new dtoBookingPrices(props.vehicle.id, startDate, end)
            fetchFinalPriceAndOffers(dto).then(res => setDetailPrices(res.payload.object));
        }
    };

    const bookNow = (client, email) => {
        let dto = new dtoBooking(props.vehicle.id, client, email, startDate, endDate)
        fetchPostBooking(dto).then(res => alert(res));
    }
    return (
        <>             
            <ModalOffers modal={modalOffers} functionVisibility={setModalOffers} data={detailPrices}/>
            <ModalForm modal={modalForm} functionVisibility={setModalForm} action={bookNow} data={detailPrices}/>

            <div className="bg-light p-2 pt-4">
                <Container>
                    <div className="section-title">
                        <h3>Enter your details</h3>
                    </div>
                    <Row className="d-flex justify-content-center align-self-center">
                            <FormGroup className="form-group">
                                <DatePicker
                                    className="form-control valid"
                                    placeholderText="Check-in - Check-out"
                                    startDate={startDate}
                                    endDate={endDate}
                                    onChange={onChange}
                                    minDate={new Date()}
                                    selectsRange
                                    locale="es"
                                    inline
                                />
                            </FormGroup>
                    </Row>
                    <div className="section-title mt-2 mb-4">
                        <h4>Summary Prices</h4>
                    </div>
                    <Row>     
                        <SummaryPricesList totalDays={detailPrices.totalDays} defaultTotalPrice={detailPrices.defaultTotalPrice} offers={detailPrices.offers} finalTotalDiscount={detailPrices.finalTotalDiscount} finalTotalPrice={detailPrices.finalTotalPrice} setModalOffers={setModalOffers}/>
                    </Row>
                    <Row>
                        <Col className="d-flex justify-content-center align-self-center form-group mt-5 mb-4">
                            <Button type="submit" disabled={!detailPrices.finalTotalPrice} onClick={() => setModalForm(true)} className="boxed-btn">Book Now</Button>
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    )
}
export default DetailsFormSection;