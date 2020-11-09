import React from 'react';
import { Container, Row, Col } from "reactstrap";
import Carousel from "components/Carousel.js";

function AboutBettingSection() {
    const items = [
        {
            src: require("assets/img/carousel1.jpg"),
            altText: "New Cupra Leon",
            caption: "New Cupra Leon",
        },
        {
            src: require("assets/img/carousel2.jpg"),
            altText: "Seat el Born",
            caption: "Seat el Born",
        },
        {
            src: require("assets/img/carousel3.jpg"),
            altText: "Seat MiniMo",
            caption: "Seat MiniMo",
        },
    ];

    return (
        <>
            <div className="site-section bg-light">
                <Container className="p-5">
                    <Row>
                        <Col md={6} className="mx-auto text-center mb-3 section-heading">
                            <h2 className="mb-5">Betting on electricity</h2>
                        </Col>
                    </Row>
                    <Carousel items={items} />
                </Container>
            </div>
        </>
    );
}

export default AboutBettingSection;