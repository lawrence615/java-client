package com.mobidev.pdsl.model;

public class Token {

    private String meter;

    private int amount;

    private int quantity;

    public Token() {
    }

    public Token(String meter, int amount, int quantity) {
        this.meter = meter;
        this.amount = amount;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
