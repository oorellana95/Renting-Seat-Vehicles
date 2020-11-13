import React, { useState } from "react";
import { Col } from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLinkedin } from '@fortawesome/free-brands-svg-icons'
import { faGithub } from '@fortawesome/free-brands-svg-icons'
import Iframe from 'react-iframe'

function StaffCard(props) {
    const [flipped, setFlipped] = useState(false);
    return (
        <>
            <Col lg={4} md={6} className="mb-5">
                <div className="staff-frame text-center">
                    <span className="d-block mb-4 thumbnail">
                        {(!flipped || !props.flipped) && <img onClick={() => setFlipped(true)} src={props.img} alt={"image " + props.name} className="img-fluid"></img>}
                        {flipped && props.flipped && <Iframe width="100%" height="304.56" src={props.flipped} frameborder="1" marginHeight="0" marginWidth="0"></Iframe>}
                    </span>
                <div className="p-4">
                    <h3 className="heading mb-3">{props.name}</h3>
                    <p>{props.description}</p>
                    <div>
                        <a style={{ display: props.hrefGit ? "" : "none", margin: props.hrefGit && props.hrefLinkdIn ? "0  1.5rem 0 0" : "" }} href={props.hrefGit} rel="noopener noreferrer" target="_blank">
                            <FontAwesomeIcon icon={faGithub} color="#2b3137" size="2x" />
                        </a>
                        <a style={{ display: props.hrefLinkdIn ? "" : "none" }} href={props.hrefLinkdIn} rel="noopener noreferrer" target="_blank">
                            <FontAwesomeIcon icon={faLinkedin} color="#2977c9" size="2x" />
                        </a>
                    </div>
                </div>
                </div>
        </Col>
        </>
    );
}


export default StaffCard;