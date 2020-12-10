package com.wei.activemq.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Department implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
