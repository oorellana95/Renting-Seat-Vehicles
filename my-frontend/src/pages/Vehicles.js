import React from 'react';
import { connect } from 'react-redux'
import { fetchVehicles } from '../actions/vehiclesActions'
import { fetchMobilityTypes } from '../actions/mobilityTypesActions'
// core components
import MyNavbar from "components/MyNavbar.js";
import Header from "components/Header.js";
import Footer from "components/Footer.js";
import VehicleCard from 'components/VehicleCard';
import CategoryList from 'components/CategoryList';
import { Container, Row, Col } from "reactstrap";
import NumSelector from 'components/NumSelector';


//Diferentes formas de crear componentes
class Vehicles extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      filter: {
        passengers: 1, 
        mobilityType: 0
      },
      mobilityTypes: this.props.mobilityTypes.mobilityTypes}
  }

  componentDidMount() {
    this.props.getVehicles();
    this.props.getMobilityTypes();

    document.body.classList.add("index-page");
    document.body.classList.add("sidebar-collapse");
    document.documentElement.classList.remove("nav-open");
    window.scrollTo(0, 0);
    document.body.scrollTop = 0;
    return function cleanup() {
      document.body.classList.remove("index-page");
      document.body.classList.remove("sidebar-collapse");
    }
  }

  renderVehicles() {
    if (this.props.vehicles.isLoading) return <p>Loading vehicles...</p>
    if (this.props.vehicles.hasErrors) return <p>Unable to display vehicles. Error: {this.props.error}</p>

    return this.getVehiclesFiltered().map(item => <VehicleCard vehicle={item} key={item.id} />);
  }

  getVehiclesFiltered(){
    return this.props.vehicles.vehicles.filter(item => 
      (+item.passengers >= this.state.filter.passengers) && 
      (this.state.filter.mobilityType!=0 ? item.mobilityType.id == this.state.filter.mobilityType : true)
      );
  }

  filterVehiclesByMobilityTypes(value) {
    this.setState({ filter: {passengers : this.state.filter.passengers, mobilityType : value}});
  };

  filterVehiclesByPassengers(value) {
    this.setState({ filter: {passengers : value, mobilityType : this.state.filter.mobilityType}});
  };

  renderMobilityTypes() {
    if (this.props.isLoading) return <p>Loading types...</p>
    if (this.props.hasErrors) return <p>Unable to display types. Error: {this.props.error}</p>

    return <CategoryList items={this.state.mobilityTypes} itemAll={true} filterFunction ={this.filterVehiclesByMobilityTypes.bind(this)}  />
  }

  render() {
    return (
      <>
        <MyNavbar navbarSolidColor="grey" />
        <div className="wrapper">
          <Header routeImage={require("assets/img/vehicles-header.jpg")} title="Our vehicles" description="Choose the one that fits you" filterColor="blue" />
          <div className="site-section first">
            <Container>
              <Row>
                <Col lg={8}>
                  {this.renderVehicles()}
                </Col>
                <Col lg={3} >
                  {this.renderMobilityTypes()}
                  <NumSelector nums={[1,2,4,5,7]} filterFunction={this.filterVehiclesByPassengers.bind(this)} />
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
  vehicles: state.vehicles,
  mobilityTypes: state.mobilityTypes
})

const mapDispatchToProps = dispatch => ({
  getVehicles: () => dispatch(fetchVehicles()),
  getMobilityTypes: () => dispatch(fetchMobilityTypes()),
})

export default connect(mapStateToProps, mapDispatchToProps)(Vehicles)