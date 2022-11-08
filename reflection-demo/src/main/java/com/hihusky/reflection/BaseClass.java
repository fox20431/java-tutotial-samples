package com.hihusky.reflection;


public class BaseClass {
    private int value;

    public BaseClass() {
    }

    public BaseClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Base{" +
                "value=" + value +
                '}';
    }
}
