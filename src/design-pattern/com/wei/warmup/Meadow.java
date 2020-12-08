package com.wei.warmup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Meadow {
    private Queue<Cow> cows = new ConcurrentLinkedQueue<Cow>();

    private Meadow() {
        cows.add(new Cow("mother", 5, this));
    }
    public void addNewCow(Cow cow) {
        cows.add(cow);
    }
    public static Meadow getInstance() {
        return innerClass.meadow;
    }

    public void change() {
        Iterator<Cow> iterator = cows.iterator();
        while (iterator.hasNext()) {
            Cow cow = iterator.next();
            cow.change();
        }
    }

    private static class innerClass {
        private static final Meadow meadow = new Meadow();
    }

    public int getCowsCount() {
        return cows.size();
    }
}
