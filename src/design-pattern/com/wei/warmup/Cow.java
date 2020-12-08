package com.wei.warmup;


import java.util.ArrayList;
import java.util.List;

public class Cow {
    private static int count = 0;
    private int id = count++;
    private String name;
    private int age;
    private Meadow meadow;

    public Cow() {

    }

    public Cow(String name, int age, Meadow meadow) {
        this.name = name;
        this.age = age;
        this.meadow = meadow;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void giveBirth() {
        if (age >= 5) {
            this.meadow.addNewCow(new Cow("new cow",0, meadow));
        }
    }

    public void growUp() {
        age++;
    }

    public void change() {
        growUp();
        giveBirth();
    }
}
