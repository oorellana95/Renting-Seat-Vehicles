import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

function ItemContact(props) {
    return (
        <>
            <div className="media contact-info">
                <span className="contact-info__icon">
                    <FontAwesomeIcon icon={props.icon} size='2x'></FontAwesomeIcon>
                </span>
                <div className="media-body">
                    <h3>{props.name}</h3>
                    <p>{props.description}</p>
                </div>
            </div>
        </>
    );
}

export default ItemContact;