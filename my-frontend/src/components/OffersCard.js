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
                    <h3>Up to 35% savings on Club rooms and Suites</h3>
                    <ul>
                        <li>Luxaries condition</li>
                        <li>3 Adults & 2 Children size</li>
                        <li>Sea view side</li>
                    </ul>
                </div>
            </Col>
        </>
    );
}

export default OffersCard;