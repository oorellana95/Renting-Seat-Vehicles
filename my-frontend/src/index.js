import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

// styles for this kit
import "assets/css/bootstrap.min.css";
import "assets/scss/now-ui-kit.scss?v=1.4.0";
import "assets/css/now-ui-kit.css";
import "assets/demo/demo.css?v=1.4.0";
import "assets/demo/nucleo-icons-page-styles.css?v=1.4.0";
import "assets/css/style.css";
// pages for this kit
import Home from "pages/Home.js";
import Vehicles from "pages/Vehicles.js";
import About from "pages/About.js";
import Contact from "pages/Contact.js";

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Switch>
        <Route 
          path="/home" 
          render={(props) => <Home {...props} />} />
        <Route
          path="/vehicles"
          render={(props) => <Vehicles {...props} />}
        />
        <Route
          path="/about"
          render={(props) => <About {...props} />}
        />
        <Route
          path="/contact"
          render={(props) => <Contact {...props} />}
        />
        <Redirect to="/home" />
        <Redirect from="/" to="/home" />
      </Switch>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

