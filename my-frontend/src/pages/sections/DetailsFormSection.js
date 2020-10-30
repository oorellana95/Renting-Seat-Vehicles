import React, { useState } from "react";
import DatePicker, { registerLocale } from "react-datepicker";
import { Container, Row, Col, FormGroup, Form, Input, Button } from "reactstrap";
import es from 'date-fns/locale/es';
import "react-datepicker/dist/react-datepicker.css";

import { fetchCalculateFinalPrice } from '../../actions/pricesActions';
import dtoBooking from '../../dto/dtoBooking';
registerLocale('es', es);

function DetailsFormSection(props) {
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [finalPrice, setFinalPrice] = useState(0);

    const onChange = dates => {
        const [start, end] = dates;
        setStartDate(start);
        setEndDate(end);

        if (start != startDate) {
            setFinalPrice(0);
        }
        else if (end) {
            let dto = new dtoBooking(props.vehicle.id, "oscar", startDate, end)
            fetchCalculateFinalPrice(dto).then(res => setFinalPrice(res.payload.price));
        }
    };

    return (
        <>
            <div className="site-section bg-light">
                <Container>
                    <Form className="form-contact contact_form" action="" method="post" id="contactForm" novalidate="novalidate">
                        <Row>
                            <Col xs={6}>
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
                            <Col xs={6}>
                            <span className="button button-contactForm boxed-btn">Hola: {finalPrice}</span>
                            </Col>
                            <Col sm={12}>
                                <FormGroup className="form-group">
                                    <Input className="form-control valid" name="name" id="name" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your full name'" placeholder="Enter your full name"></Input>
                                </FormGroup>
                            </Col>
                            <Col sm={6}>
                                <FormGroup className="form-group">
                                    <Input className="form-control valid" name="email" id="email" type="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Enter your email address"></Input>
                                </FormGroup>
                            </Col>
                            <Col sm={6}>
                                <FormGroup className="form-group">
                                    <Input className="form-control valid" name="email" id="email" type="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Confirm your email address'" placeholder="Confirm your email address"></Input>
                                </FormGroup>
                            </Col>
                        </Row>
                        <FormGroup className="form-group mt-3">
                            <Button type="submit" onClick={() => { }} className="button button-contactForm boxed-btn">Send</Button>
                        </FormGroup>
                    </Form>
                </Container>
            </div>
        </>
    )
}
export default DetailsFormSection;