
import React from 'react'
import ItemContact from 'components/ItemContact';
import { Container, Row, Col, FormGroup, Form, Input, Button} from "reactstrap";
import { faBuilding, faPhone, faEnvelope } from '@fortawesome/free-solid-svg-icons'

function GetInTouchSection() {

    const itemsContact = [
        {
            name: 'SEAT S.A, Martorell.',
            description: 'Carretera Nacional II KM 585, BCN 08760',
            icon: faBuilding
        },
        {
            name: 'SEAT CODE, Barcelona.',
            description: 'Carrer En Bot 22, BCN 08002',
            icon: faBuilding
        },
        {
            name: '+34937085554',
            description: 'Mon to Fri 9am to 6pm',
            icon: faPhone
        },
        {
            name: 'seatemail@seat.es',
            description: 'Send us your query anytime!',
            icon: faEnvelope
        }
    ]

    return (
        <>
            <div className="site-section bg-light">
                <Container>
                    <Row>
                        <Col md={6} className="section-heading">
                            <h3 className="mb-5 font-weight-bold">Get In Touch</h3>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={8}>
                            <Form className="form-design" action="" method="post" id="contactForm" novalidate="novalidate">
                                <Row>
                                    <Col xs={12}>
                                        <FormGroup className="form-group">
                                            <textarea className="form-control w-100" name="message" id="message" cols="30" rows="9" placeholder="Enter Message" ></textarea>
                                        </FormGroup>
                                    </Col>
                                    <Col sm={6}>
                                        <FormGroup className="form-group">
                                            <Input className="form-control valid" name="name" id="name" type="text" placeholder="Enter your name"></Input>
                                        </FormGroup>
                                    </Col>
                                    <Col sm={6}>
                                        <FormGroup className="form-group">
                                            <Input className="form-control valid" name="email" id="email" type="email" placeholder="Enter email address"></Input>
                                        </FormGroup>
                                    </Col>
                                    <Col xs={12}>
                                        <FormGroup className="form-group">
                                            <Input className="form-control" name="subject" id="subject" type="text" placeholder="Enter Subject"></Input>
                                        </FormGroup>
                                    </Col>
                                </Row>
                                <FormGroup className="form-group mt-3">
                                    <Button type="submit" className="button button-contactForm boxed-btn">Send</Button>
                                </FormGroup>
                            </Form>
                        </Col>
                        <Col lg={4} className="mt-3" >
                            {itemsContact.map(item => {
                                return (
                                    <ItemContact name={item.name} description={item.description} icon={item.icon} />
                                )
                            })}
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default GetInTouchSection;