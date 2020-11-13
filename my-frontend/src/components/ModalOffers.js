import React from "react";
import { Modal, ModalBody, Row, Col } from "reactstrap";

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
                                            <li key={item.id} className="list-group-item d-flex justify-content-between align-items-center ">
                                                <div>
                                                    <span className="bold">{item.name}</span> <br />
                                                    <span className="small">From {item.startDate} to {item.endDate}</span>
                                                </div>
                                                <span className="badge">{item.discountAppliedInRevenues}€</span>
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
                        Discounts applied on daily prices
                    </span>
                    <span className="cancel_now" type="button" onClick={() => props.functionVisibility(false)}>Close</span>
                </div>
            </Modal>
        </>
    )
}

export default ModalOffers;
