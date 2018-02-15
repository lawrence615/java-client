package com.mobidev.pdsl.model;

public class Customer {

    private String meter;

    public Customer() {
    }

    public Customer(String meter) {
        this.meter = meter;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }
}
