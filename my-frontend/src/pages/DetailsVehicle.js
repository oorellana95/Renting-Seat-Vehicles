import React from "react";
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

    React.useEffect(() => {
        props.getVehicleById(props.match.params.id);
        window.scrollTo(0, 0);
    }, [props.match.params.id]);

    function renderDetails() {
        if (props.vehicle.isLoading) return <p>Loading details...</p>
        if (props.vehicle.hasErrors) return <p>Unable to display details. Error: {props.vehicle.error}</p>
        if (props.vehicle.object.id) return <Row>
            <Col md={8}>
                <VehicleCard vehicle={props.vehicle.object} detail={true} />
            </Col>
            <Col md={4}>
                <DetailsFormSection vehicle={props.vehicle.object} />
            </Col>
        </Row>
        else return <p>There is no vehicle for that reference</p>
    }

    return (
        <>
            <MyNavbar navbarSolidColor="grey" solid={true} />
            <div className="wrapper">
                <div className="main">
                    <div className="site-section first">
                        <Container>
                            <Row>
                                <Col md={6} className="mx-auto text-center mb-3 section-heading">
                                    <h2 className="mb-5">Your vehicle</h2>
                                </Col>
                            </Row>
                            {renderDetails()}
                        </Container>
                    </div>
                </div>
                <Footer />
            </div>
        </>
    );
}

function mapStateToProps(state) {
    return (
        {
            vehicle: state.vehicle
        }
    );
}

function mapDispatchToProps(dispatch) {
    return (
        {
            getVehicleById: (id) => (fetchVehicleById(id))(dispatch)
        }
    )
};
export default connect(mapStateToProps, mapDispatchToProps)(DetailsVehicle)