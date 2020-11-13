import React from 'react';
import { connect } from 'react-redux'
import { fetchVehicles } from '../actions/vehiclesActions'
import { fetchMobilityTypes } from '../actions/mobilityTypesActions'
// core components
import MyNavbar from "components/MyNavbar.js";
import Header from "components/Header.js";
import Footer from "components/Footer.js";
import VehicleCard from 'components/VehicleCard';
import CategorySelector from 'components/CategorySelector';
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
      }}
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
    if (this.props.vehicles.hasErrors) return <p>Unable to display vehicles. Error: {this.props.vehicles.error}</p>

    let vehicles = this.getVehiclesFiltered();
    if (vehicles.length === 0) return <p>No vehicles for search filters applied.</p>
    return vehicles.map(item => <VehicleCard vehicle={item} key={item.id} />);
  }

  getVehiclesFiltered(){
    return this.props.vehicles.objects.filter(item => 
      (+item.passengers >= this.state.filter.passengers) && 
      (this.state.filter.mobilityType!==0 ? item.mobilityType.id === this.state.filter.mobilityType : true)
      );
  }

  filterVehiclesByMobilityTypes(value) {
    this.setState({ filter: {...this.state.filter, mobilityType : value}});
  };

  filterVehiclesByPassengers(value) {
    this.setState({ filter: {...this.state.filter, passengers : value}});
  };

  renderMobilityTypes() {
    if (this.props.mobilityTypes.isLoading) return <p>Loading types...</p>
    if (this.props.mobilityTypes.hasErrors) return <><CategorySelector itemAll={true} filterFunction ={this.filterVehiclesByMobilityTypes.bind(this)} error={`Unable to display more types. Error: ${this.props.mobilityTypes.error}`}/></>

    return <CategorySelector items={this.props.mobilityTypes.objects} itemAll={true} filterFunction ={this.filterVehiclesByMobilityTypes.bind(this)}  />
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
  getVehicles: () => (fetchVehicles())(dispatch),
  getMobilityTypes: () => (fetchMobilityTypes())(dispatch),
})

export default connect(mapStateToProps, mapDispatchToProps)(Vehicles)