
import React from 'react'
import Map from 'components/Map';
import ItemContact from 'components/ItemContact';
import { Container, Row, Col } from "reactstrap";
import { faBuilding } from '@fortawesome/free-solid-svg-icons'

function MapSection() {

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

    const itemsContact = [
        {
            name: 'SEAT S.A, Martorell.',
            description: 'Carretera Nacional II KM 585, BCN 08760',
            icon: faBuilding
        },
        {
            name: 'SEAT CODE, Barcelona.',
            description: 'Carrer En Bot 22, BCN 08002',
            icon: faBuilding
        }]

    return (
        <>
            <div className="site-section bg-light">
                <Container>
                    <Row>
                        <Col md={6} className="mx-auto text-center mb-3 section-heading">
                            <h2 className="mb-5">Pick up your vehicle</h2>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={8}>
                            <Map markers={markers} defaultCenter={defaultCenter} zoom={10} mini={true}/> {/* include it here */}
                        </Col>
                        <Col lg={3} className="mt-3" >
                            {itemsContact.map(item => {
                                return (
                                    <ItemContact name={item.name} description={item.description} icon={item.icon}/>
                                )
                            })}
                        </Col>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default MapSection;

