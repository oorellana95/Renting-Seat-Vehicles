package com.mybackend.seat.application.models;

import java.sql.Date;

//--- Model --------------------------------------------------------
public class BookingsModel {

    //--- Attributes -----------------------------------------------
    public long id;
    public Date checkIn;
    public Date checkOut;
    public Double totalPrice;
    public String client;
    public String email;
    public VehiclesModel vehicle;

    //--- Constructor ----------------------------------------------
    public BookingsModel() {
    }

    public BookingsModel(Date checkIn, Date checkOut, Double totalPrice, String client, String email, VehiclesModel vehicle) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.client = client;
        this.email = email;
        this.vehicle = vehicle;
    }

    //--- Getters & Setters ----------------------------------------
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public VehiclesModel getVehicle() {
        return vehicle;
    }
    public void setVehicle(VehiclesModel vehicle) {
        this.vehicle = vehicle;
    }

    //--- toString -------------------------------------------------

    @Override
    public String toString() {
        return "BookingsModel{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                ", client='" + client + '\'' +
                ", email='" + email + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
