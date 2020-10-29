import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import {store, persistor} from './store/store'


// styles for this kit
import "assets/css/bootstrap.min.css";
import "assets/css/template.css";
import "assets/css/style.css";
import 'assets/css/sass.scss';

// pages for this kit
import Home from "pages/Home.js";
import Vehicles from "pages/Vehicles.js";
import About from "pages/About.js";
import Contact from "pages/Contact.js";
import DetailsVehicle from "pages/DetailsVehicle.js";

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
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
            <Route
              path="/detail"
              render={(props) => <DetailsVehicle {...props} />}
            />
            <Redirect to="/home" />
            <Redirect from="/" to="/home" />
          </Switch>
        </BrowserRouter>
      </PersistGate>
    </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);

