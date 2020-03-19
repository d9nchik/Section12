package com.d9nich.exercise20;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter path: ");
        String[] output = {input.next()};
        DelPackage.main(output);
    }
}
