package com.mybackend.seat.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "bookings", schema = "seat_renting")
public class BookingsEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "checkIn", nullable = true)
    private Date checkIn;

    @Basic
    @Column(name = "checkOut", nullable = true)
    private Date checkOut;

    @Basic
    @Column(name = "totalPrice", nullable = true, precision = 0)
    private Double totalPrice;

    @Basic
    @Column(name = "client", nullable = true, precision = 0)
    private String client;

    @Basic
    @Column(name = "email", nullable = true, precision = 0)
    private String email;

    /*
    @ManyToOne
    @JoinColumn(name = "fk_client_id", referencedColumnName = "id", table = "bookings")
    private ClientsEntity client;
    */

    @OneToOne
    @JoinColumn(name = "fk_vehicle_id", referencedColumnName = "id", table = "bookings")
    private VehiclesEntity vehicle;

    //--- Getters & Setters ---------------------------------------
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

    public VehiclesEntity getVehicle() {
        return vehicle;
    }
    public void setVehicle(VehiclesEntity vehiclesByFkRoomId) {
        this.vehicle = vehiclesByFkRoomId;
    }

    /*
    public ClientsEntity getClient() {
        return client;
    }
    public void setClient(ClientsEntity client) {
        this.client = client;
    }
     */

    //--- Some general functions -----------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingsEntity that = (BookingsEntity) o;
        return id == that.id &&
                Objects.equals(checkIn, that.checkIn) &&
                Objects.equals(checkOut, that.checkOut) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(client, that.client) &&
                Objects.equals(email, that.email) &&
                Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkIn, checkOut, totalPrice, client, email, vehicle);
    }
}
