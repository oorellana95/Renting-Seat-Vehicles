import React from 'react'
import { Col } from "reactstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLinkedin } from '@fortawesome/free-brands-svg-icons'
import { faGithub } from '@fortawesome/free-brands-svg-icons'

function StaffCard(props) {
    return (
        <>
            <Col lg={4} md={6} className="mb-5">
                <div className="staff-frame text-center">
                    <span className="d-block mb-4 thumbnail">
                        <img src={props.img} alt={"image " + props.name} className="img-fluid"></img>
                    </span>
                    <div className="p-4">
                        <h3 className="heading mb-3">{props.name}</h3>
                        <p>{props.description}</p>
                        <div>
                            <a style={{ display: props.hrefGit ? "" : "none", margin: props.hrefGit && props.hrefLinkdIn  ? "0  1.5rem 0 0" : "" }} href={props.hrefGit}>
                                <FontAwesomeIcon icon={faGithub} color="#2b3137" size="2x" />
                            </a> 
                            <a style={{ display: props.hrefLinkdIn ? "" : "none" }} href={props.hrefLinkdIn}>
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