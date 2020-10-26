import React from 'react';
import { Container, Row, Col } from "reactstrap";

function VehiclesSection() {
    return (
        <>
            <div className="site-section bg-light">
                <Container>
                    <Row>
                    <Col lg={8} md={6} className="mb-5">
                        
                    </Col>
                    <Col lg={4}>
                        <h2 class="mb-5">Fantastic 5</h2>
                    </Col>
                    </Row>
                    <Row className="justify-content-center">
                        <StaffCard name="Adrian Hitos" description="He is the fastest typing code and looking for things on the internet." hrefGit="https://github.com/orgs/Z-devs/people/hiitoos" hrefLinkdIn="https://www.linkedin.com/in/adrian-hitos-jimenez-870231118/" img={staff1_img}/>
                        <StaffCard name="Oscar Lara" description="An exceptional designer with awesome ideas and very good logic." hrefGit="https://github.com/orgs/Z-devs/people/roskou" hrefLinkdIn="https://www.linkedin.com/in/oscar-lara-de-liz-94a01319a/" img={staff1_img}/>
                        <StaffCard name="Oscar Orellana" description="A monkey, the best one removing code and destroying repositories." hrefGit="https://github.com/oorellana95" hrefLinkdIn="https://www.linkedin.com/in/oscar-orellana-gonzalez-15535b16a/" img={staff1_img}/>
                        <StaffCard name="Miguel Pablos" description="If you have any doubt you can ask him! The best coder by far." hrefGit="https://github.com/orgs/Z-devs/people/leguim-repo" hrefLinkdIn="https://www.linkedin.com/in/miguel-angel-pablos-moreno-38203a153/" img={staff1_img}/>
                        <StaffCard name="Pablo Pardo" description="The best one making a team, the most constant and hard-working." hrefGit="https://github.com/orgs/Z-devs/people/Pablopgcode"  img={staff1_img}/>
                    </Row>
                </Container>
            </div>
        </>
    );
}

export default VehiclesSection;