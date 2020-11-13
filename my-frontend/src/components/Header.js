import React from 'react';
import { Container } from "reactstrap";

//Diferentes formas de crear componentes
function Header(props) {
  let pageHeader = React.createRef();

  return (
    <>
      <div className="page-header clear-filter" filter-color={props.filterColor}>
        <div
          className="page-header-image"
          style={{
            backgroundImage: "url(" + props.routeImage + ")",
          }}
          ref={pageHeader}
        ></div>
        <Container>
          <div className="content-center brand">
            <img
              alt="..."
              className="n-logo"
              src={require("assets/img/move-logo.png")}
            ></img>
            <h1 className="h1-seo">{props.title}</h1>
            <h3>{props.description}</h3>
          </div>
          <h6 className="category category-absolute">
            Designed by{" "}
            <span>
              <img
                alt="..."
                className="interreto-logo"
                src={require("assets/img/interreto.png")}
              ></img>
            </span>
            . Coded by{" "}
            <span>
              <img
                alt="..."
                className="devs-team-logo"
                src={require("assets/img/devs-team.png")}
              ></img>
            </span>
          </h6>
        </Container>
      </div>
    </>
  );
}

export default Header;