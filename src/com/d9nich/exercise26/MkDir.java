package com.d9nich.exercise26;

import java.io.File;
import java.util.Scanner;

public class MkDir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of folder: ");
        File directory = new File(input.nextLine());
        if (directory.exists()) {
            System.out.println("Directory already exists");
            System.exit(1);
        }
        if (directory.mkdir())
            System.out.println("Directory created successfully");
    }
}
