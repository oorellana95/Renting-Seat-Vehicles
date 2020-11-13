import React from 'react';
import { Container, Row, Col } from "reactstrap";
import StaffCard from 'components/StaffCard';

function AboutStaffSection() {

    const staff = [
        {
            name: 'Adrian Hitos',
            description: 'He is the fastest typing code and looking for things on the internet.',
            hrefGit: 'https://github.com/orgs/Z-devs/people/hiitoos',
            hrefLinkdIn: 'https://www.linkedin.com/in/adrian-hitos-jimenez-870231118/',
            img: require("assets/img/ahitos.jpg"),
            flipped: require("assets/mp4/flipped_hitos.mp4")
        },
        {
            name: 'Oscar Lara',
            description: 'An exceptional designer with awesome ideas and very good logic.',
            hrefGit: 'https://github.com/orgs/Z-devs/people/roskou',
            hrefLinkdIn: 'https://www.linkedin.com/in/oscar-lara-de-liz-94a01319a/',
            img: require("assets/img/olara.jpg"),
            flipped: require("assets/mp4/flipped_lara.mp4")
        },
        {
            name: 'Oscar Orellana',
            description: 'If you need to face a challenge in an organized way, call him!',
            hrefGit: 'https://github.com/oorellana95',
            hrefLinkdIn: 'https://www.linkedin.com/in/oscar-orellana-gonzalez-15535b16a/',
            img: require("assets/img/oorellana.jpg"),
            flipped: require("assets/mp4/flipped_orellana.mp4")
        },
        {
            name: 'Miguel Pablos',
            description: 'If you have any doubt you can ask him! The best coder by far.',
            hrefGit: 'https://github.com/orgs/Z-devs/people/leguim-repo',
            hrefLinkdIn: 'https://www.linkedin.com/in/miguel-angel-pablos-moreno-38203a153/',
            img: require("assets/img/mpablos.jpg"),
            flipped: require("assets/mp4/flipped_pablos.mp4")
        },
        {
            name: 'Pablo Pardo',
            description: 'The best one making a team, the most constant and hard-working.',
            hrefGit: 'https://github.com/orgs/Z-devs/people/Pablopgcode',
            img: require("assets/img/ppardo.jpg"),
            flipped: require("assets/mp4/flipped_pardo.mp4")
        }]

    return (
        <>
            <div className="site-section bg-light">
                <Container>
                    <Row>
                        <Col md={6} className="mx-auto text-center mb-3 section-heading">
                            <h2 className="mb-5">Fantastic 5</h2>
                        </Col>
                    </Row>
                    <Row className="justify-content-center">
                        {staff.map(item => {
                            return (
                                <StaffCard name={item.name} description={item.description} hrefGit={item.hrefGit} hrefLinkdIn={item.hrefLinkdIn}  img={item.img} flipped={item.flipped}  />
                            )
                        })}
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default AboutStaffSection;