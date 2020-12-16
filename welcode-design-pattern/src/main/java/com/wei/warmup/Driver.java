package com.wei.warmup;

public class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drive(Moveable vehichle, Address address) {
        vehichle.go(address);
    }
}
