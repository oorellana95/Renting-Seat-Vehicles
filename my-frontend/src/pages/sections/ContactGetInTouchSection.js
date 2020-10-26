
import React from 'react'
import Map from 'components/Map';
import ItemContact from 'components/ItemContact';
import { Container, Row, Col } from "reactstrap";
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
                        <Col md={6} className="mb-3 section-heading">
                            <h3 className="mb-5 font-weight-bold">Get In Touch</h3>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={8}>
                        <form class="form-contact contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control w-100" name="message" id="message" cols="30" rows="9" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Message'" placeholder="Enter Message" ></textarea>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input class="form-control valid" name="name" id="name" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your name'" placeholder="Enter your name"></input>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input class="form-control valid" name="email" id="email" type="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Enter email address"></input>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="subject" id="subject" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Subject'" placeholder="Enter Subject"></input>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <button type="submit" class="button button-contactForm boxed-btn">Send</button>
                            </div>
                        </form>
                        </Col>
                        <Col md={4} className="mt-3" >
                            {itemsContact.map(item => {
                                return (
                                    <ItemContact name={item.name} description={item.description} icon={item.icon}/>
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