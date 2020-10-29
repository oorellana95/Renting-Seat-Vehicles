import React from 'react';
// core components
import MyNavbar from "components/MyNavbar.js";
import Footer from "components/Footer.js";
import "react-datepicker/dist/react-datepicker.css";
import ReactDatePicker from 'react-datepicker';

//Diferentes formas de crear componentes
function Contact(props) {
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
                <div className="main">
                    <p>{vehicle.name}</p>
                </div>
                <Footer />
            </div>
        </>
    );
}

export default Contact;

/*
postBookNow(room) {
    console.log(‘postBookNow: ’,room);
    //var axios = require(‘axios’);
    var data = JSON.stringify({"roomId":"1","room":{"id":"1","code":"SU2","description":"descripcion de la room","pricePerNight":"1000","image":"imagen.jpg","guests":"2","roomtypesByFkRoomtypeId":null},"checkIn":"11-10-2020","checkOut":"15-10-2021","guests":"2","totalPrice":"1000"});
    var config = {
      method: 'post',
      url: 'http://pom-hotel.code:8080/api/findroom',
      headers: { 
        'Access-Control-Allow-Origin':'*',
        'Content-Type': 'application/json', 
      },
      data : data
    };
    axios.withCredentials = true;
    axios(config)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      console.log(response.data);
      console.log(response.status);
      console.log(response.statusText);
      console.log(response.headers);
      console.log(response.config);
    })
    .catch(function (error) {
      console.log(error);
    });
  }*/