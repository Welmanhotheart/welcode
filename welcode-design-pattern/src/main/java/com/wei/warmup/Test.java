package com.wei.warmup;

public class Test {
    public static void main(String[] args) {
//        Driver d = new Driver("老张");
//        d.drive(new Car(), new Address("东北"));
        Meadow meadow = Meadow.getInstance();

        for(int i = 0; i < 20; i++) {
            meadow.change();
        }
        System.out.println(meadow.getCowsCount());
    }
}
