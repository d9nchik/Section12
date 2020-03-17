package com.d9nich.exercise2;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number between 1 and 12: ");
            int choice = input.nextInt();
            System.out.println(months[choice - 1] + " - " + dom[choice - 1]);
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            System.out.println("wrong number");
        }
    }
}
