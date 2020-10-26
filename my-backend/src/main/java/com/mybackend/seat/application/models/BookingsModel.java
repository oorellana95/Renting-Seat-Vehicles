package com.mybackend.seat.application.models;

import java.sql.Date;

//--- Model --------------------------------------------------------
public class BookingsModel {

    //--- Attributes -----------------------------------------------
    public long id;
    public Date checkIn;
    public Date checkOut;
    public Double totalPrice;
    public ClientsModel client;
    public VehiclesModel vehicle;

    //--- Constructor ----------------------------------------------
    public BookingsModel() {
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

    public ClientsModel getClient() {
        return client;
    }
    public void setClient(ClientsModel client) {
        this.client = client;
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
                ", client=" + client +
                ", vehicle=" + vehicle +
                '}';
    }
}
