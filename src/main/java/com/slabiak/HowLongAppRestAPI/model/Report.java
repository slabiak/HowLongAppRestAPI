package com.slabiak.HowLongAppRestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reports")
public class Report extends BaseEntity{

    @Column(name="waiting_time")
    private int waitingTime;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="created_by")
    private String createdBy;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Report(){

    }

    public Report(int waitingTime, String createdBy, Date createdAt,Restaurant restaurant) {
        this.waitingTime = waitingTime;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.restaurant = restaurant;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
