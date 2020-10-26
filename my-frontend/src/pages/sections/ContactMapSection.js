
import React from 'react'
import Map from 'components/Map';
import { Container, Row, Col } from "reactstrap";

function ContactMapSection() {
    const markers = [
        {
            name: 'Location 1',
            location: {
                lat: 41.495657,
                lng: 1.907097
            }
        },
        {
            name: 'Location 2',
            location: {
                lat: 41.385090,
                lng: 2.170705
            }
        }]

    const defaultCenter = {
        lat: 41.445214, lng: 2.039129
    }

    return (
        <>
            <div className="site-section">
                <Container>
                    <Map markers={markers} defaultCenter={defaultCenter} zoom={10} /> {/* include it here */}
                </Container>
            </div>
        </>
    );
}

export default ContactMapSection;

