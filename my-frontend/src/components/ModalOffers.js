import React, { useState } from "react";
import { Modal, ModalBody, Button, Row, Col } from "reactstrap";

function ModalOffers(props) {
    return (
        <>
            <Modal isOpen={props.modal} toggle={() => props.functionVisibility(false)}>
                <div className="modal-header justify-content-center">
                    <h4 className="title title-up">Total discount: &nbsp;&nbsp; {props.data.finalTotalDiscount}€</h4>
                </div>
                <ModalBody>
                    <Row>
                        <Col sm={12}>
                            <ul className="list-group">
                                {(props.data.offers) && props.data.offers.map(item => {
                                    return (
                                        <>
                                            <li className="list-group-item d-flex justify-content-between align-items-center ">
                                                <div>
                                                    <span className="bold">{item.name}</span> <br />
                                                    <span className="small">From {item.startDate} to {item.endDate}</span>
                                                </div>
                                                <span class="badge">{item.discountAppliedInRevenues}€</span>
                                            </li>
                                        </>
                                    )
                                })}
                            </ul>
                        </Col>
                    </Row>
                </ModalBody>
                <div className="modal-footer mt-2">
                    <span className="ml-3 font-italic ">
                        Discounts applied on {props.data.defaultTotalPrice}€
                    </span>
                    <a className="cancel_now" type="button" onClick={() => props.functionVisibility(false)}>Close</a>
                </div>
            </Modal>
        </>
    )
}

export default ModalOffers;
