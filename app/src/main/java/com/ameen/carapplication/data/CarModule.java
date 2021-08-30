package com.ameen.carapplication.data;

/**
 * Created by (Ameen Essa) on 8/30/2021
 * Copyright (c) 2021 . All rights reserved.
 *
 * @Ameen.MobileDev@gmail.com
 */

public class CarModule {

    private int id;
    private String brand;
    private String constractionYear;
    private boolean isUsed;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConstractionYear() {
        return constractionYear;
    }

    public void setConstractionYear(String constractionYear) {
        this.constractionYear = constractionYear;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
