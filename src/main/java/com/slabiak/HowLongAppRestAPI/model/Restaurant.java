package com.slabiak.HowLongAppRestAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant extends BaseEntity implements Comparable {

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="google_id")
    private String googleId;

    @Column(name="photo_reference")
    private String photo_reference;

    @OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
    private List<Report> reports;

    @Transient
    private int mean;

    public Restaurant(){

    }

    public Restaurant(String name, String address, String googleId, String photo_reference){
        this.name = name;
        this.address = address;
        this.googleId = googleId;
        this.photo_reference = photo_reference;
        this.reports = new ArrayList<Report>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Integer getMean() {
        int mean = 0;
        if(reports.size()!=0){
            for (Report report : reports) {
                mean += report.getWaitingTime();
            }
            mean = mean / reports.size();
        }
        return mean;
    }

    public void setMean(Integer mean) {
        this.mean = mean;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        Restaurant restaurant = (Restaurant) o;
        int cmp = Double.compare(((Restaurant) o).getMean(), this.mean);
        return cmp;
    }

    public String getPhotoReference() {
        return photo_reference;
    }

    public void setPhotoReference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public void addReport(Report report){
        reports.add(report);
    }
}
