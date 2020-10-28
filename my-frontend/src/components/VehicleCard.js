import React from 'react'
import { Row, Col, Button } from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser, faGripHorizontal } from '@fortawesome/free-solid-svg-icons'

function VehicleCard(props) {
    const v = props.vehicle;
    return (
        <>
            <article className="vehicle_item">
                <div className="vehicle_item_img">
                    <img className="card-img rounded-0" src= {require(`assets/img/vehicles-for-rent/${v.image}`)} alt=""></img>
                    <a href="#" className="vehicle_item_date">
                        <FontAwesomeIcon icon={faUser} color="white" size="2x" />
                    </a>
                </div>

                <div className="vehicle_details">
                    <h2>{v.name}</h2>
                    <p>{v.description}</p>
                    <Row>
                        <Col sm={6} xs={12}>
                        <ul className="vehicle-info-link">
                            <li><FontAwesomeIcon icon={faGripHorizontal} color="#2977c9" size="1x" className="mr-2" /><a href="#">{v.gearbox}</a></li>
                            <li><FontAwesomeIcon icon={faUser} color="#2977c9" size="1x" className="mr-2" /><a href="#">{v.passengers} passengers</a></li>
                        </ul>
                        </Col>
                        <Col sm={3} xs={6} className="pr-4">
                            <span href="#" className="price float-right">{v.pricePerDay} € / day</span>
                        </Col>
                        <Col sm={3} xs={6} className="pr-4">
                            <a href="#" className="book_now float-right">Book now</a>
                        </Col>
                    </Row>
                </div>
            </article>
        </>
    );
}

export default VehicleCard;