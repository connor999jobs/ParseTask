package com.example.parsings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Currency {
    private String LastPrice;
    private float curr1;
    private float curr2;

    public String getLastPrice() {
        return LastPrice;
    }

    public void setLastPrice(String lastPrice) {
        LastPrice = lastPrice;
    }

    public float getCurr1() {
        return curr1;
    }

    public void setCurr1(float curr1) {
        this.curr1 = curr1;
    }

    public float getCurr2() {
        return curr2;
    }

    public void setCurr2(float curr2) {
        this.curr2 = curr2;
    }
}
