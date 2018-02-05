package com.mobidev.pdsl.model;

public class Token {

    private String meter;

    private int amount;

    public Token() {
    }

    public Token(String meter, int amount) {
        this.meter = meter;
        this.amount = amount;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
