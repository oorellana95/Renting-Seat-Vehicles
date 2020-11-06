import React, { useState } from "react";
import DatePicker, { registerLocale } from "react-datepicker";
import { Container, Row, Col, FormGroup, Form, Input, Button } from "reactstrap";
import es from 'date-fns/locale/es';
import "react-datepicker/dist/react-datepicker.css";

import { fetchFinalPriceAndOffers } from '../../actions/pricesActions';
import { fetchPostBooking } from '../../actions/bookingsActions';
import { dtoBooking, dtoBookingPrices } from '../../dto/dtoBooking';
registerLocale('es', es);

function DetailsFormSection(props) {
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [finalPrice, setFinalPrice] = useState(0);
    const [client, setClient] = useState("");
    const [email, setEmail] = useState("");

    const onChange = dates => {
        const [start, end] = dates;
        setStartDate(start);
        setEndDate(end);

        if (start != startDate) {
            setFinalPrice(0);
        }
        else if (end) {
            let dto = new dtoBookingPrices(props.vehicle.id, startDate, end)
            fetchFinalPriceAndOffers(dto).then(res => setFinalPrice(res.payload.object.finalTotalPrice));
        }
    };

    const bookNow = () => {
        let dto = new dtoBooking(props.vehicle.id, client, email, startDate, endDate)
        fetchPostBooking(dto).then(res => console.log(res));
    }

    return (
        <>
            <div className="site-section bg-light">
                <Container>
                    <div className="section-title mb-5">
                        <h3>Enter your details</h3>
                    </div>
                    <Form className="form-contact contact_form" action="" method="post" id="contactForm" novalidate="novalidate">
                        <Row>
                            <Col className="d-flex justify-content-center align-self-center" sm={6}>
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
                            </Col>
                            <Col className="pt-3" sm={6}>
                                <FormGroup className="form-group">
                                    <Input className="form-control valid" name="name" id="name" type="text" placeholder="Enter your full name" onChange={(e) => setClient(e.target.value)}></Input>
                                </FormGroup>
                                <FormGroup className="form-group">
                                    <Input className="form-control valid" name="email" id="email" type="email" placeholder="Enter your email address"></Input>
                                </FormGroup>
                                <FormGroup className="form-group">
                                    <Input className="form-control valid" name="email" id="email" type="email" placeholder="Confirm your email address" onChange={(e) => setEmail(e.target.value)}></Input>
                                </FormGroup>
                            </Col>
                        </Row>
                    </Form>
                </Container>
            </div>
            <div className="site-section">
                <Container>
                    <Row>
                        <Col sm={8}>
                            <span className="boxed-btn">Final Price: {finalPrice}</span>
                        </Col>
                        <Col className="d-flex justify-content-center align-self-center form-group" sm={4}>
                            <Button type="submit" onClick={() => { bookNow() }} className="boxed-btn">Book Now</Button>
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    )
}
export default DetailsFormSection;