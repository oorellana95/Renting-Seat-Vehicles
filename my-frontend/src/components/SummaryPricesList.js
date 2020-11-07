import React from 'react'

import { Col } from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faExclamationCircle} from '@fortawesome/free-solid-svg-icons';
function SummaryPricesList(props) {
    return (
        <>
            <Col sm={12}>
                <ul className="list-group">
                    <li className="list-group-item d-flex justify-content-between align-items-center ">
                        Total Price ({props.totalDays} days)<span class="badge">{props.defaultTotalPrice}€</span>
                    </li>
                    <li className="list-group-item d-flex justify-content-between align-items-center">
                        <span>Discounts Applied &nbsp;
                                {props.offers.length > 0 && props.setModalOffers && <a type="button" onClick={() => props.setModalOffers(true)}><FontAwesomeIcon icon={faExclamationCircle} color="purple" /></a>}
                        </span>
                        <span class="badge">-{props.finalTotalDiscount}€</span>
                    </li>
                    <li className="list-group-item d-flex justify-content-between align-items-center bold">
                        Final Price <span class="badge">{props.finalTotalPrice}€</span>
                    </li>
                </ul>
            </Col>
        </>
    );
}

export default SummaryPricesList;