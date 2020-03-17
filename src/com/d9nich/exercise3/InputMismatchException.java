package com.d9nich.exercise3;

import java.util.Scanner;

public class InputMismatchException {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean flag = true;
        while (flag) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter the number between 1 and 12: ");
                int choice = input.nextInt();
                System.out.println(months[choice - 1] + " - " + dom[choice - 1]);
                flag = false;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("wrong number");
            } catch (java.util.InputMismatchException ex) {
                System.out.println("number should be integer format");
            }
        }
    }
}
