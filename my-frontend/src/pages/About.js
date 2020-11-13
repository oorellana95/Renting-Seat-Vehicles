import React from 'react';
// core components
import MyNavbar from "components/MyNavbar.js";
import Header from "components/Header.js";
import BrandsSection from './sections/BrandsSection';
import VideoModalSection from './sections/VideoModalSection';
import Footer from "components/Footer.js";
import AboutStaffSection from './sections/AboutStaffSection';
import AboutBettingSection from './sections/AboutBettingSection';
import MoSection from './sections/MoSection';

function About () {
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
      <MyNavbar navbarSolidColor="black"/>
      <div className="wrapper">
        <Header routeImage = {require("assets/img/about-header.jpg")} title="Seat Team" description ="Motivation, dedication and passion" filterColor="purple"/>
        <BrandsSection/>
        <AboutBettingSection/>
        <MoSection/>
        <AboutStaffSection/>
        <VideoModalSection title="Discovering technologies" miniTitle="Oscar Orellana" videoId="bab4ncfp3IA" videoImage={require("assets/img/monkey-desk.jpg")}/>
        <Footer />
      </div>
    </>
  );
}

export default About;