package com.mybackend.seat.ui.dto;

import com.mybackend.seat.application.models.ClientsModel;
import com.mybackend.seat.application.models.VehiclesModel;

import java.sql.Date;

//--- Model --------------------------------------------------------
public class BookingsDTO {

    //--- Attributes -----------------------------------------------
    public long id_vehicle;
    public Date checkIn;
    public Date checkOut;
    public String email;

    //--- Constructor ----------------------------------------------
    public BookingsDTO() {
    }

    //--- Getters & Setters ----------------------------------------
    public long getId_vehicle() {
        return id_vehicle;
    }
    public void setId_vehicle(long id_vehicle) {
        this.id_vehicle = id_vehicle;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BookingsDTO{" +
                "id_vehicle=" + id_vehicle +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", email='" + email + '\'' +
                '}';
    }
}
