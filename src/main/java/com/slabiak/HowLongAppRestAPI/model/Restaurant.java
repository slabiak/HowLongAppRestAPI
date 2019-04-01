package com.slabiak.HowLongAppRestAPI.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="google_id")
    private String googleId;

    @Column(name="photoReference")
    private String photoReference;

    @OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
    private List<Report> reports;


    public Restaurant(){
    }

    public Restaurant(String name, String address, String googleId, String photoReference){
        this.name = name;
        this.address = address;
        this.googleId = googleId;
        this.photoReference = photoReference;
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

    @Override
    public String toString() {
        return this.name;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photo_reference) {
        this.photoReference = photo_reference;
    }

    public void addReport(Report report){
        reports.add(report);
    }

    public int getMeanWaitingTime(){
        int mean = 0;
        if(reports!=null){
            if(reports.size()>0){
                for(Report report : reports){
                    mean += report.getWaitingTime();
                }
                mean = mean/reports.size();
                return mean;
            }
        }
        return mean;
    }
}
