package com.slabiak.HowLongAppRestAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    public Report(){

    }

    public Report(int waitingTime, String createdBy) {
        this.waitingTime = waitingTime;
        this.createdBy = createdBy;
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
}
