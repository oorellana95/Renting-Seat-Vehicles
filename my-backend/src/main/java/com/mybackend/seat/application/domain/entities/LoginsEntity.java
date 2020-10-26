package com.mybackend.seat.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "logins", schema = "seat_renting")
public class LoginsEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "username", nullable = true, unique = true)
    private String username;

    @Basic
    @Column(name = "password", nullable = true)
    private String password;

    @Basic
    @Column(name = "role")
    private String role;

    @Basic
    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(fetch=FetchType.EAGER)
    //@PrimaryKeyJoinColumn
    @JoinColumn(name = "fk_client_id", referencedColumnName = "id", table = "logins")
    private ClientsEntity client;

    //--- Getters & Setters ---------------------------------------
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ClientsEntity getClient() {
        return client;
    }
    public void setClient(ClientsEntity clientsByFkClientId) {
        this.client = clientsByFkClientId;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginsEntity that = (LoginsEntity) o;
        return id == that.id &&
                enabled == that.enabled &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, enabled, client);
    }
}
