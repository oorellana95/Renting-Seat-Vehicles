import React from 'react';
import { Container, Row, Col } from "reactstrap";

function BrandsSection() {
    return (
        <>
            <div className="Brands-section site-section first">
                <Container>
                    <Row>
                        <Col lg={5} xl={5}>
                            <div className="info">
                                <div className="section-title mb-20px">
                                    <span>About the brands</span>
                                    <h3>A Luxuries Hotel with Nature</h3>
                                </div>
                                <p>Suscipit libero pretium nullam potenti. Interdum, blandit phasellus consectetuer dolor ornare
                                dapibus enim ut tincidunt rhoncus tellus sollicitudin pede nam maecenas, dolor sem. Neque
                            sollicitudin enim. Dapibus lorem feugiat facilisi faucibus et. Rhoncus.</p>
                                <a href="https://www.seat.es/" rel="noopener noreferrer" target="_blank" className="line-button">Learn More</a>
                            </div>
                        </Col>
                        <Col lg={7} xl={7}>
                            <div className="about-thumb d-flex">
                                <div className="img_1">
                                    <img
                                        alt="..."
                                        className="n-logo img-raised"
                                        src={require("assets/img/seat-logo.png")}
                                    ></img>
                                </div>
                                <div className="img_2">
                                    <img
                                        alt="..."
                                        className="n-logo img-raised"
                                        src={require("assets/img/cupra-logo.png")}
                                    ></img>
                                </div>
                            </div>
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default BrandsSection;
