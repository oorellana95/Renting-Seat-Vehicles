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
              src={require("assets/img/now-logo.png")}
            ></img>
            <h1 className="h1-seo">{props.title}</h1>
            <h3>{props.description}</h3>
          </div>
          <h6 className="category category-absolute">
            Designed by{" "}
            <a href="http://invisionapp.com/?ref=creativetim" rel="noopener noreferrer" target="_blank">
              <img
                alt="..."
                className="invision-logo"
                src={require("assets/img/invision-white-slim.png")}
              ></img>
            </a>
            . Coded by{" "}
            <a
              href="https://www.creative-tim.com?ref=nukr-index-header"
              target="_blank"
              rel="noopener noreferrer"
            >
              <img
                alt="..."
                className="creative-tim-logo"
                src={require("assets/img/creative-tim-white-slim2.png")}
              ></img>
            </a>
            .
          </h6>
        </Container>
      </div>
    </>
  );
}

export default Header;