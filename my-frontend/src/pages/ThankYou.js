import React from "react";
import { Container, Row, Col } from "reactstrap";
import { connect } from 'react-redux'
import { Link } from 'react-router-dom';

function DetailsVehicle(props) {
  return (
    <>
      {props.booking.object.vehicle && <div className="page-header clear-filter" filter-color="black">
        <div
          className="page-header-image"
          style={{
            backgroundImage: "url(" + require(`assets/img/vehicles-for-rent/${props.booking.object.vehicle.image}`) + ")",
          }}
        ></div>
        <Container className="ThankYou">
          <Row>
            <Col xs={12}>
              {props.booking.isLoading && <h1>Loading...</h1>}
              {props.booking.hasErrors && <h1>Error!</h1>}
              {props.booking.object.id && <h1>Thank You!</h1>}
            </Col>
            {props.booking.object.id &&
              <Col xs={12} className="text-center mb-4">
                <img
                  alt="..."
                  className="play-music"
                  src={require("assets/img/check.png")}
                ></img>
              </Col>}
            <Col xs={12}>
              {props.booking.hasErrors && <p>Unable to book the vehicle. Error: {props.booking.error}</p>}
              {props.booking.object.id &&
                <>
                  <p>Your {props.booking.object.vehicle.name} is waiting for you from {props.booking.object.checkIn} to {props.booking.object.checkOut}. To see more details look at your email.</p>
                 
                </>}
            </Col>
            <Col xs={12} className="mt-5">
              <Link to={"/"}>
                <span type="button" className="thanks_btn">Go HomePage!</span>
              </Link>
            </Col>
          </Row>
        </Container>
      </div>}
    </>
  );
}

function mapStateToProps(state) {
  return (
    {
      booking: state.booking
    }
  );
}
export default connect(mapStateToProps)(DetailsVehicle)