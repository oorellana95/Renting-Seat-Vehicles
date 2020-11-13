import React from 'react'
import { Row, Col } from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser, faGripHorizontal } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom';

function VehicleCard(props) {
    const vehicle = props.vehicle;
    console.log(props.vehicle);

    return (
        <>
            <article className="vehicle_item">
                <div className="vehicle_item_img">
                    {vehicle.image && <img className="card-img rounded-0" src={require(`assets/img/vehicles-for-rent/${vehicle.image}`)} alt=""></img>}
                    <span className="vehicle_item_date">
                        {vehicle.mobilityType.name}
                    </span>
                </div>

                <div className="vehicle_details">
                    <h2>{vehicle.name}</h2>
                    {props.detail ? (<><p>{vehicle.description}</p> <p>{vehicle.specificDescription}</p></>) : (<p>{vehicle.description.slice(1, 145) + "..."}</p>)}
                    <Row>
                        <Col sm={6} xs={12}>
                            <ul className="vehicle-info-link">
                                <li><FontAwesomeIcon icon={faGripHorizontal} color="#000" size="1x" className="mr-2" /><span>{vehicle.gearbox}</span></li>
                                <li><FontAwesomeIcon icon={faUser} color="#000" size="1x" className="mr-2" /><span>{vehicle.passengers} passengers</span></li>
                            </ul>
                        </Col>
                        {props.detail ? (
                            <>
                                <Col sm={6} xs={12}>
                                    <span className="price float-right mr-5">Average price: {vehicle.pricePerDay} € / day</span>
                                </Col>
                            </>
                        ) : (
                                <>
                                    <Col sm={3} xs={6} className="pr-4">
                                        <span href="#" className="price float-right">{vehicle.pricePerDay} € / day</span>
                                    </Col>
                                    <Col sm={3} xs={6} className="pr-4">
                                        <Link to={"vehicle/" + vehicle.id}>
                                            <span type="button" className="book_now float-right">Book now!</span>
                                        </Link>
                                    </Col>
                                </>
                            )}
                    </Row>
                </div>
            </article>
        </>
    );
}

export default VehicleCard;