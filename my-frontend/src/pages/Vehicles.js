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

    return this.props.vehicles.vehicles.map(item => <VehicleCard vehicle={item} key={item.id} />)
  }

  renderMobilityTypes() {
    if (this.props.isLoading) return <p>Loading types...</p>
    if (this.props.hasErrors) return <p>Unable to display types. Error: {this.props.error}</p>

    return <CategoryList items={this.props.mobilityTypes.mobilityTypes} />
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
                  <NumSelector nums={[1,2,4,5,7]}/>
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
/*
 Mapeamos los disparadores de las acciones del ActionCreators que queremos usar en este componente y las metemos
// en las props
// recibimo el disparador de nuestro almacen
const mapDispatchToProps = (dispatch) => ({
  postComment: (dishId, rating, author, comment) => dispatch(postComment(dishId, rating, author, comment)),
  fetchDishes: () => { dispatch(fetchDishes())},
  resetFeedbackForm: () => { dispatch(actions.reset(‘feedback’))}, //reset del form feedback
  fetchComments: () => dispatch(fetchComments()), //disparadores para obtener datos del servidor
  fetchPromos: () => dispatch(fetchPromos()),
  fetchLeaders: () => dispatch(fetchLeaders()),
  postFeedback: (firstname, lastname, telnum, email, agree, contactType, message, postId) => dispatch(postFeedback(firstname, lastname, telnum, email, agree, contactType, message, postId))
});
*/

export default connect(mapStateToProps, mapDispatchToProps)(Vehicles)