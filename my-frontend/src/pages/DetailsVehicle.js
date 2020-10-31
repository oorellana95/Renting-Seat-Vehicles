import React from 'react';
// core components
import MyNavbar from "components/MyNavbar.js";
import Footer from "components/Footer.js";
import Header from "components/Header.js";
import DetailsFormSection from './sections/DetailsFormSection';
import VehicleCard from 'components/VehicleCard';
import { Container, Row, Col } from "reactstrap";

//Diferentes formas de crear componentes
function DetailsVehicle(props) {
    let vehicle = props.history.location.state.vehicle;

    React.useEffect(() => {
        document.body.classList.add("index-page");
        document.body.classList.add("sidebar-collapse");
        document.documentElement.classList.remove("nav-open");
        window.scrollTo(0, 0);
        document.body.scrollTop = 0;
        return function cleanup() {
            document.body.classList.remove("index-page");
            document.body.classList.remove("sidebar-collapse");
        };
    });

    return (
        <>
            <MyNavbar navbarSolidColor="grey" solid={true} />
            <div className="wrapper">
                <div className="main">
                    <div className="site-section first">
                        <Container>
                            <Row>
                                <Col md={6} className="mx-auto text-center mb-3 section-heading">
                                    <h2 class="mb-5">Your vehicle</h2>
                                </Col>
                            </Row>
                            <Row>
                                <VehicleCard vehicle={vehicle} detail={true} />
                            </Row>
                        </Container>
                    </div>
                    <DetailsFormSection vehicle={vehicle} />
                </div>
                <Footer />
            </div>
        </>
    );
}

export default DetailsVehicle;