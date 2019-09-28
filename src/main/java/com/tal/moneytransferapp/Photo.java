package com.tal.moneytransferapp;

public class Photo {

    private long id;
    private String name;

    public Photo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
