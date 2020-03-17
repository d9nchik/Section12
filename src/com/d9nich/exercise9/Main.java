package com.d9nich.exercise9;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(bin2Dec("111rgt"));
        } catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        int number = 0;
        number += parseInt(binaryString.charAt(binaryString.length() - 1));
        binaryString = binaryString.substring(0, binaryString.length() - 1);
        if (binaryString.length() != 0)
            number += bin2Dec(binaryString) * 2;
        return number;
    }

    private static int parseInt(char symbol) throws BinaryFormatException {
        if (symbol == '1' || symbol == '0')
            return symbol - '0';
        else
            throw new BinaryFormatException(symbol);
    }
}
