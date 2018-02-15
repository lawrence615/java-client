package com.mobidev.pdsl.model;

public class TokenResponse {

    private int amount;

    private int quantity;

    private String data;

    public TokenResponse() {
    }

    public TokenResponse(int amount, int quantity, String data) {
        this.amount = amount;
        this.quantity = quantity;
        this.data = data;
    }
}
