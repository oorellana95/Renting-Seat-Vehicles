import React from 'react';
// core components
import MyNavbar from "components/MyNavbar.js";
import Header from "components/Header.js";
import Footer from "components/Footer.js";
import BrandsSection from './sections/BrandsSection';
import HomeOngoingSection from './sections/HomeOngoingSection';
import VideoSection from './sections/VideoSection';
import HomeMapSection from './sections/HomeMapSection';

function Home () {
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
        
        <Header routeImage = {require("assets/img/home-header.jpg")} title="Seat & Code" description = "Live unique experiences" filterColor="red"/>
        
        <div className="main">
          <HomeOngoingSection />
          <VideoSection backgroundColor="black" urlVideo="https://player.vimeo.com/video/440582383?background=1"/>
          <BrandsSection/>
          <HomeMapSection/>
        </div>

        <Footer />

      </div>
    </>
  );
}

export default Home;