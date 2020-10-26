import React from 'react';
import { Container, Row, Col } from "reactstrap";
import OffersCard from 'components/OffersCard';

function HomeOngoingSection() {
    return (
        <>
            <div class="HomeOngoing-section site-section bg-light">
                <Container>
                    <Row>
                        <Col md={6} className="mx-auto text-center mb-3 section-heading">
                            <h2 class="mb-5">Ongoing Offers</h2>
                        </Col>
                    </Row>
                    <Row>
                        <OffersCard img={require("assets/img/offer1.jpg")}/>
                        <OffersCard img={require("assets/img/offer2.jpg")}/>
                        <OffersCard img={require("assets/img/offer3.jpg")}/>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default HomeOngoingSection;
