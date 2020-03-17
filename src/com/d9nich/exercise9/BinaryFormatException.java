package com.d9nich.exercise9;

public class BinaryFormatException extends Exception {
    public BinaryFormatException(char symbol) {
        super("the string consist not a binary symbol: " + symbol);
    }
}
