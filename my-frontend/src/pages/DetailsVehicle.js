import React, { useState } from "react";
// core components
import MyNavbar from "components/MyNavbar.js";
import Footer from "components/Footer.js";
import DetailsFormSection from './sections/DetailsFormSection';
import VehicleCard from 'components/VehicleCard';
import { Container, Row, Col } from "reactstrap";
import { fetchVehicleById } from '../actions/vehiclesActions';
import { connect } from 'react-redux'

//Diferentes formas de crear componentes
function DetailsVehicle(props) {
    const vehicle = props.vehicle;

    React.useEffect(() => {
        props.getVehicleById(props.match.params.id);
        
        document.body.classList.add("index-page");
        document.body.classList.add("sidebar-collapse");
        document.documentElement.classList.remove("nav-open");
        window.scrollTo(0, 0);
        document.body.scrollTop = 0;
        return function cleanup() {
            document.body.classList.remove("index-page");
            document.body.classList.remove("sidebar-collapse");
        };
    }, [props.match.params.id]);

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
                                {vehicle && <VehicleCard vehicle={vehicle} detail={true} />}
                            </Row>
                        </Container>
                    </div>
                    {vehicle && <DetailsFormSection vehicle={vehicle} />}
                </div>
                <Footer />
            </div>
        </>
    );
}

const mapStateToProps = state => ({
    vehicle: state.vehicle.object
  })
  
  const mapDispatchToProps = dispatch => ({
    getVehicleById: (id) => (fetchVehicleById(id)) (dispatch)
  })
  
export default connect(mapStateToProps, mapDispatchToProps)(DetailsVehicle)