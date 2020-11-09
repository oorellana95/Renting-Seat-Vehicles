import React, { useState } from "react";
import DatePicker, { registerLocale } from "react-datepicker";
import { Container, Row, Col, FormGroup, Button } from "reactstrap";
import es from 'date-fns/locale/es';
import "react-datepicker/dist/react-datepicker.css";
import ModalOffers from 'components/ModalOffers';
import ModalForm from 'components/ModalForm';
import SummaryPricesList from 'components/SummaryPricesList';

import { connect } from 'react-redux'

import { fetchResetFinalPriceAndOffers, fetchFinalPriceAndOffers } from '../../actions/pricesActions';
import { fetchPostBooking } from '../../actions/bookingsActions';
import { dtoBooking } from '../../dto/dtoBooking';
import { dtoToGetPrices } from '../../dto/dtoOffersPrices';


registerLocale('es', es);

function DetailsFormSection(props) {
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [modalOffers, setModalOffers] = useState(false);
    const [modalForm, setModalForm] = useState(false);

    React.useEffect(() => {
        props.resetPricesAndDiscounts();
    }, []);


    const onChange = dates => {
        const [start, end] = dates;
        setStartDate(start);
        setEndDate(end);

        if (start !== startDate) {
            props.resetPricesAndDiscounts();
        }
        else if (end) {
            let dto = new dtoToGetPrices(props.vehicle.id, startDate, end)
            props.getPricesAndDiscounts(dto);
        }
    };

    const bookNow = (client, email) => {
        let dto = new dtoBooking(props.vehicle.id, client, email, startDate, endDate)
        props.postBooking(dto);
    }

    function renderTablePrices() {
        if (props.prices.isLoading) return <p>Loading details...</p>
        if (props.prices.hasErrors) return <p>Unable to display prices. Error: {props.prices.error}</p>
        return <>
            <Row>
                <SummaryPricesList totalDays={props.prices.object.totalDays} defaultTotalPrice={props.prices.object.defaultTotalPrice} offers={props.prices.object.offers} finalTotalDiscount={props.prices.object.finalTotalDiscount} finalTotalPrice={props.prices.object.finalTotalPrice} setModalOffers={setModalOffers} />
            </Row>
            <Row>
                <Col className="d-flex justify-content-center align-self-center form-group mt-5 mb-4">
                    <Button type="submit" disabled={!props.prices.object.finalTotalPrice} onClick={() => setModalForm(true)} className="boxed-btn">Book Now</Button>
                </Col>
            </Row>
        </>
    }

    return (
        <>
            <ModalOffers modal={modalOffers} functionVisibility={setModalOffers} data={props.prices.object} />
            <ModalForm modal={modalForm} functionVisibility={setModalForm} action={bookNow} data={props.prices.object} />

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
                    {renderTablePrices()}

                </Container>
            </div>
        </>
    )
}


function mapStateToProps(state) {
    return (
        {
            vehicle: state.vehicle.object,
            prices: state.prices,
            booking: state.booking
        }
    );
}

function mapDispatchToProps(dispatch) {
    return (
        {
            resetPricesAndDiscounts: () => fetchResetFinalPriceAndOffers()(dispatch),
            getPricesAndDiscounts: (dto) => (fetchFinalPriceAndOffers(dto))(dispatch),
            postBooking: (dto) => (fetchPostBooking(dto))(dispatch)
        }
    )
};

export default connect(mapStateToProps, mapDispatchToProps)(DetailsFormSection)