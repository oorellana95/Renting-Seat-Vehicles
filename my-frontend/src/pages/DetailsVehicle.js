import React from 'react';
// core components
import MyNavbar from "components/MyNavbar.js";
import Footer from "components/Footer.js";
import Header from "components/Header.js";
import DetailsFormSection from './sections/DetailsFormSection';

//Diferentes formas de crear componentes
function DetailsVehicle(props) {
    let vehicle = props.history.location.state.vehicle;

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
            <MyNavbar navbarSolidColor="black" />
            <div className="wrapper">
            <Header routeImage={require("assets/img/vehicles-header.jpg")} title="Our vehicles" description="Choose the one that fits you" filterColor="blue" />
                <div className="main">
                    <DetailsFormSection vehicle = {vehicle}/>
                </div>
                <Footer />
            </div>
        </>
    );
}

export default DetailsVehicle;