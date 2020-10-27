import React from 'react'
import { Row, Col, Button } from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser } from '@fortawesome/free-solid-svg-icons'

function VehicleCard(props) {
    return (
        <>
            <article className="vehicle_item">
                <div className="vehicle_item_img">
                    <img className="card-img rounded-0" src= {require("assets/img/vehicles-for-rent/seat-ibiza.jpg")} alt=""></img>
                    <a href="#" className="vehicle_item_date">
                        <FontAwesomeIcon icon={faUser} color="white" size="2x" />
                    </a>
                </div>

                <div className="vehicle_details">
                    <h2>Google inks pact for new 35-storey office</h2>
                    <p>That dominion stars lights dominion divide years for fourth have don't stars is that
                                    he earth it first without heaven in place seed it second morning saying.</p>
                    <Row>
                        <Col sm={8} xs={12}>
                        <ul className="vehicle-info-link">
                            <li><FontAwesomeIcon icon={faUser} color="#2977c9" size="1x" className="mr-2" /><a href="#">Travel, Lifestyle</a></li>
                            <li><FontAwesomeIcon icon={faUser} color="#2977c9" size="1x" className="mr-2" /><a href="#">03 Comments</a></li>
                        </ul>
                        </Col>
                        <Col sm={4} xs={12} className="pr-4">
                            <a href="#" className="book_now float-right">Book now</a>
                        </Col>
                    </Row>
                </div>
                
                
            </article>
        </>
    );
}

export default VehicleCard;