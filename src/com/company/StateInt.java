package com.company;

public class StateInt {
    private int value;

    public StateInt(int value) {
        this.value = value;
    }

    public synchronized int get() {
        return value;
    }

    public synchronized int increment() {
        return value++;
    }
}