import React from 'react'
import { Row, Col} from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUser, faGripHorizontal } from '@fortawesome/free-solid-svg-icons'
import { useHistory } from 'react-router-dom';

function VehicleCard(props) {
    const vehicle = props.vehicle;
    const history = useHistory();
    const handleClick = () => history.push('/detail', {
        vehicle: vehicle
      })

    return (
        <>
            <article className="vehicle_item">
                <div className="vehicle_item_img">
                    <img className="card-img rounded-0" src= {require(`assets/img/vehicles-for-rent/${vehicle.image}`)} alt=""></img>
                    <a href="#" className="vehicle_item_date">
                        <FontAwesomeIcon icon={faUser} color="white" size="2x" />
                    </a>
                </div>

                <div className="vehicle_details">
                    <h2>{vehicle.name}</h2>
                    <p>{vehicle.description.slice(1,145) + "..."}</p>
                    <Row>
                        <Col sm={6} xs={12}>
                        <ul className="vehicle-info-link">
                            <li><FontAwesomeIcon icon={faGripHorizontal} color="#2977c9" size="1x" className="mr-2" /><a href="#">{vehicle.gearbox}</a></li>
                            <li><FontAwesomeIcon icon={faUser} color="#2977c9" size="1x" className="mr-2" /><a href="#">{vehicle.passengers} passengers</a></li>
                        </ul>
                        </Col>
                        <Col sm={3} xs={6} className="pr-4">
                            <span href="#" className="price float-right">{vehicle.pricePerDay} € / day</span>
                        </Col>
                        <Col sm={3} xs={6} className="pr-4">
                            <a onClick={handleClick} className="book_now float-right">Book now</a>
                        </Col>
                    </Row>
                </div>
            </article>
        </>
    );
}

export default VehicleCard;