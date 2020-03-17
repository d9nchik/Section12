package com.d9nich.exercise8;

public class HexFormatException extends Exception {
    public HexFormatException() {
        super("Hex consist not hex symbols!");
    }

    public HexFormatException(String message) {
        super("Hex consist not hex symbols:" + message);
    }
}
