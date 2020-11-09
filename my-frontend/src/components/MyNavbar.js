import React from "react";
import { Link } from "react-router-dom";
// reactstrap components
import {
  Collapse,
  NavbarBrand,
  Navbar,
  NavItem,
  NavLink,
  Nav,
  Container,
  UncontrolledTooltip,
} from "reactstrap";

function MyNavbar(props) {
  const [navbarColor, setNavbarColor] = React.useState((props.solid) ? "" : "navbar-transparent");
  const [collapseOpen, setCollapseOpen] = React.useState(false);
  
  React.useEffect(() => {
    if (!props.solid){
    const updateNavbarColor = () => {
      if (
        document.documentElement.scrollTop > 399 ||
        document.body.scrollTop > 399
      ) {
        setNavbarColor("");
      } else if (
        document.documentElement.scrollTop < 400 ||
        document.body.scrollTop < 400
      ) {
        setNavbarColor("navbar-transparent");
      }
    };
    window.addEventListener("scroll", updateNavbarColor);
    return function cleanup() {
      window.removeEventListener("scroll", updateNavbarColor);
    };
  }
  });

  return (
    <>
      {collapseOpen ? (
        <div
          id="bodyClick"
          onClick={() => {
            document.documentElement.classList.toggle("nav-open");
            setCollapseOpen(false);
          }}
        />
      ) : null}
      <Navbar className={"fixed-top " + navbarColor} color={props.navbarSolidColor} expand="lg">
        <Container>
          <div className="navbar-translate">
        
            <NavbarBrand
              href="https://youtu.be/mL7Gb6rcAAo"
              target="_blank"
              id="navbar-brand"
            >
              RENTING S.C
            </NavbarBrand>

            <UncontrolledTooltip target="#navbar-brand">
              By Deejay @Miguel
            </UncontrolledTooltip>

            <button
              className="navbar-toggler navbar-toggler"
              onClick={() => {
                document.documentElement.classList.toggle("nav-open");
                setCollapseOpen(!collapseOpen);
              }}
              aria-expanded={collapseOpen}
              type="button"
            >
              <span className="navbar-toggler-bar top-bar"></span>
              <span className="navbar-toggler-bar middle-bar"></span>
              <span className="navbar-toggler-bar bottom-bar"></span>
            </button>

          </div>

          <Collapse
            className="justify-content-end"
            isOpen={collapseOpen}
            navbar
          >
            <Nav navbar>
              <NavItem>
                <NavLink to="/" tag={Link}>
                  Home
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/vehicles" tag={Link}>
                  Vehicles
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/about" tag={Link}>
                  About
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink to="/contact" tag={Link}>
                  Contact
                </NavLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Container>
      </Navbar>
    </>
  );
}

export default MyNavbar;