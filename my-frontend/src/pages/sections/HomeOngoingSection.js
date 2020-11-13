import React from 'react';
import { Container, Row, Col } from "reactstrap";
import OffersCard from 'components/OffersCard';
import { Link } from 'react-router-dom';

function HomeOngoingSection() {

    const offers = [
        {
            title: 'Up to 20% savings on all Seat Cars!',
            point1: 'Designed for you',
            point2: 'Cumulative to other offers*',
            point3: 'Applied on daily price',
            img: require("assets/img/offer1.jpg")
        },
        {
            title: 'Get from 5 to 30 euros off per day!',
            point1: 'Cumulative to other offers*',
            point2: 'Applied on final daily price',
            point3: 'Almost for all vehicles',
            img: require("assets/img/offer2.jpg")
        },
        {
            title: 'Up to 10% savings on Luxury Cars!',
            point1: 'Luxaries condition',
            point2: 'Applied on daily price',
            point3: 'Cumulative to other offers*',
            img: require("assets/img/offer3.jpg")
        }]

    return (
        <>
            <div className="HomeOngoing-section site-section bg-light">
                <Container>
                    <Row>
                        <Col md={6} className="mx-auto text-center mb-3 section-heading">
                            <h2 className="mb-5">Ongoing Offers</h2>
                        </Col>
                    </Row>
                    <Row>
                        {offers.map(item => {
                            return (
                                <OffersCard title={item.title} point1={item.point1} point2={item.point2} point3={item.point3} img={item.img} />
                            )
                        })}
                    </Row>
                    <Row>
                        <Col  className="mx-auto text-center mt-4">
                            <Link to={"/vehicles"}>
                                <span type="button" className="btn-vehicles">Find your vehicle</span>
                            </Link>
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default HomeOngoingSection;
