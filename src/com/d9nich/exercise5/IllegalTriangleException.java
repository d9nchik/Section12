package com.d9nich.exercise5;

public class IllegalTriangleException extends Exception {
    private double a, b, c;

    public IllegalTriangleException(double a, double b, double c) {
        super("Tha illegal triangle with sides: " + a + " " + b + " " + c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
