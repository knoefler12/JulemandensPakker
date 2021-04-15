package com.example.demo;

public class Wishlist {
    private String nameOfThePresent;
    private float price;
    private String linkOfThePresent;
    private byte reseveret=0;
    private String username;

    public Wishlist(){}

    public byte getReseveret() {
        return reseveret;
    }

    public void setReseveret(byte reseveret) {
        this.reseveret = reseveret;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameOfThePresent() {
        return nameOfThePresent;
    }

    public void setNameOfThePresent(String nameOfThePresent) {
        this.nameOfThePresent = nameOfThePresent;
    }

    public String getLinkOfThePresent() {
        return linkOfThePresent;
    }

    public void setLinkOfThePresent(String linkOfThePresent) {
        this.linkOfThePresent = linkOfThePresent;
    }

    public Wishlist(String nameOfThePresent, float price, String linkOfThePresent, byte reseveret, String username) {
        this.nameOfThePresent = nameOfThePresent;
        this.price = price;
        this.linkOfThePresent = linkOfThePresent;
        this.reseveret = reseveret;
        this.username = username;
    }
    @Override public String toString() {
        return "Name of the present: " + nameOfThePresent + "; Price of the present: " + price
                + "; Link of for the present: " + linkOfThePresent + "; Is it reserved? " + reseveret
                + "; Username for the creator of the wish: " + username;
    }
}

