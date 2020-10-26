package com.mybackend.seat.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "clients", schema = "seat_renting")
public class ClientsEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;

    @Basic
    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Basic
    @Column(name = "email", nullable = true)
    private String email;

    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    private List<BookingsEntity> bookings;

    //--- Getters & Setters ---------------------------------------
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookingsEntity> getBookings() {
        return bookings;
    }
    public void setBookings(List<BookingsEntity> bookingsById) {
        this.bookings = bookingsById;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsEntity that = (ClientsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(bookings, that.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, email, bookings);
    }
}
