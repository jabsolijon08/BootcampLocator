package com.example.james.bootcamplocator;

/**
 * Created by James on 8/14/2017.
 */

public class LocationModel {
    private double lati, longi;
    private String locTitle, locAddress;

    public LocationModel() {
    }

    public LocationModel(double lati, double longi, String locTitle, String locAddress) {
        this.lati = lati;
        this.longi = longi;
        this.locTitle = locTitle;
        this.locAddress = locAddress;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public String getLocTitle() {
        return locTitle;
    }

    public void setLocTitle(String locTitle) {
        this.locTitle = locTitle;
    }

    public String getLocAddress() {
        return locAddress;
    }

    public void setLocAddress(String locAddress) {
        this.locAddress = locAddress;
    }
}