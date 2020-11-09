import React from 'react';
import { Container, Row, Col } from "reactstrap";

function MoSection() {
    return (
        <>
            <div className="Brands-section site-section first">
                <Container>
                    <Row>
                    <Col lg={7} xl={7}>
                            <div className="about-thumb d-flex">
                                <div className="img_1">
                                    <img
                                        alt="..."
                                        className="n-logo img-raised"
                                        src={require("assets/img/mo2.jpg")}
                                    ></img>
                                </div>
                                <div className="img_2">
                                    <img
                                        alt="..."
                                        className="n-logo img-raised"
                                        src={require("assets/img/mo1.jpg")}
                                    ></img>
                                </div>
                            </div>
                        </Col>
                        <Col lg={5} xl={5}>
                            <div className="info">
                                <div className="section-title mb-20px">
                                    <span>SEAT:MO</span>
                                    <h3>Free your moves</h3>
                                </div>
                                <p> Seat MÓ, the company's new urban mobility brand of Seat and Cupra. This brand is driving an 
                                strategy focused on the mobility segment, having lanched new micromobility products and services, 
                                including the Seat MÓ eScooter 125 and the Seat MÓ eKickscooter 65.</p>
                                <a href="https://www.seatmo.com/" rel="noopener noreferrer" target="_blank" className="line-button">Learn More</a>
                            </div>
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default MoSection;
