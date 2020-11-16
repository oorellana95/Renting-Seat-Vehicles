import React from "react";
import { Container, Row, Col } from "reactstrap";
import { Link } from 'react-router-dom';

function PikachuEmail() {
  return (
    <>
        <Container className="PikachuEmail">
          <Row>
              <Col xs={12} className="text-center mb-4">
                <img
                  alt="..."
                  className="pikachu"
                  src={require("assets/img/email-pikachu.jpg")}
                ></img>
              </Col>
            <Col xs={12} className="text-center">
                  <p>You will receive an answer by email! Thanks and keep in touch!</p>
            </Col>
            <Col xs={12} className="text-center mt-5">
              <Link to={"/"}>
                <span type="button" className="pikachu_btn" onClick={()=> new Audio(require("assets/mp3/pikachu_sound.mp3")).play()}>Pikachu!</span>
              </Link>
            </Col>
          </Row>
        </Container>
    </>
  );
}

export default PikachuEmail;