import React from 'react'
import { Col } from "reactstrap";

function OffersCard(props) {
    return (
        <>
            <Col xl={4} md={4}>
                <div className="single_offers">
                    <div className="about_thumb">
                        <img src={props.img} alt=""></img>
                    </div>
                    <h3>{props.title}</h3>
                    <ul>
                        <li>{props.point1}</li>
                        <li>{props.point2}</li>
                        <li>{props.point3}</li>
                    </ul>
                </div>
            </Col>
        </>
    );
}

export default OffersCard;