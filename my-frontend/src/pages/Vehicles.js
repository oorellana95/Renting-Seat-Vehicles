import React from 'react';
import { connect } from 'react-redux'
import { fetchVehicles } from '../actions/vehiclesActions'
// core components
import MyNavbar from "components/MyNavbar.js";
import Header from "components/Header.js";
import Footer from "components/Footer.js";
import VehicleCard from 'components/VehicleCard';
import { Container, Row, Col } from "reactstrap";

//Diferentes formas de crear componentes
class Vehicles extends React.Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.props.getVehicles();
    
    document.body.classList.add("index-page");
    document.body.classList.add("sidebar-collapse");
    document.documentElement.classList.remove("nav-open");
    window.scrollTo(0, 0);
    document.body.scrollTop = 0;
    return function cleanup() {
      document.body.classList.remove("index-page");
      document.body.classList.remove("sidebar-collapse");
    };

  }

  renderVehicles() {
    if (this.props.isLoading) return <p>Loading posts...</p>
    if (this.props.hasErrors) return <p>Unable to display posts. Error: {this.props.error}</p>

    return this.props.vehicles.map(vehicle => <VehicleCard />)
  }

  render() {
    return (
      <>
        <MyNavbar navbarSolidColor="grey" />
        <div className="wrapper">
          <Header routeImage={require("assets/img/vehicles-header.jpg")} title="Our vehicles" description="Choose the one that fits you" filterColor="blue" />
          <div className="site-section">
            <Container>
              <Row>
                <Col lg={8}>
                  {this.renderVehicles()}
                </Col>
                <Col lg={3} className="mt-3" >

                </Col>
              </Row>
            </Container>
          </div>
          <Footer />
        </div>
      </>
    );
  }
}

const mapStateToProps = state => ({
  loading: state.vehicles.loading,
  vehicles: state.vehicles.vehicles,
  hasErrors: state.vehicles.hasErrors,
  error: state.vehicles.error
})

const mapDispatchToProps = dispatch => ({
    getVehicles: () => dispatch(fetchVehicles()),
})

export default connect(mapStateToProps, mapDispatchToProps)(Vehicles)