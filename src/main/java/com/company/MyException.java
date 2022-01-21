package com.company;

public class MyException extends Throwable {

    private final int lower;

    public MyException(int lower) {
        this.lower = lower;
    }

    public int getLower() {
        return lower;
    }
}
