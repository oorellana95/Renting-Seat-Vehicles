import React from 'react';
// core components
import MyNavbar from "components/MyNavbar.js";
import Header from "components/Header.js";
import Footer from "components/Footer.js";
import ContactMapSection from './sections/ContactMapSection';
import GetInTouchSection from './sections/ContactGetInTouchSection';

//Diferentes formas de crear componentes
function Contact () {
  React.useEffect(() => {
    document.body.classList.add("index-page");
    document.body.classList.add("sidebar-collapse");
    document.documentElement.classList.remove("nav-open");
    window.scrollTo(0, 0);
    document.body.scrollTop = 0;
    return function cleanup() {
      document.body.classList.remove("index-page");
      document.body.classList.remove("sidebar-collapse");
    };
  });
  return (
    <>
      <MyNavbar navbarSolidColor="purple"/>
      <div className="wrapper">
        <Header routeImage = {require("assets/img/vehicles-header.jpg")} title="Get In Touch" description = "We are here for you" filterColor="purple"/>
        <div className="main">
          <ContactMapSection/>
          <GetInTouchSection/>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default Contact;