package com.mybackend.seat.application.models;
import java.sql.Date;

public class OffersModel {
    //--- Attributes -----------------------------------------------
    public long id;
    public String name;
    public String description;
    public Date startDate;
    public Date endDate;
    public boolean cumulative;
    public String type;
    public double quantity;
    public double discountAppliedInRevenues;

    //--- Constructor ----------------------------------------------
    public OffersModel() {
    }

    //Used for testing
    public OffersModel(long id, Date startDate, Date endDate, String type, double quantity) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.quantity = quantity;
    }

    //--- Getters & Setters ----------------------------------------
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCumulative() {
        return cumulative;
    }
    public void setCumulative(boolean cumulative) {
        this.cumulative = cumulative;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscountAppliedInRevenues() {
        return discountAppliedInRevenues;
    }
    public void setDiscountAppliedInRevenues(double discountAppliedInRevenues) {
        this.discountAppliedInRevenues = discountAppliedInRevenues;
    }
}
