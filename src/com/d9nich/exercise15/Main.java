package com.d9nich.exercise15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name. To finish enter 0: ");
        String name = input.nextLine();
        while (!name.equals("0")) {
            System.out.println("Line of insertion: " +
                    writeInFile(name, new File("src/com/d9nich/exercise15/peopleNames.txt")));
            System.out.print("Enter a name. To finish enter 0: ");
            name = input.nextLine();
        }
    }

    public static int writeInFile(String name, File file) {
        int positionOfExist = com.d9nich.exercise14.Main.readInFile(name, file);
        if (positionOfExist != -1)
            return positionOfExist;
        else {
            File outFile = new File("temp.txt");
            try (Scanner input = new Scanner(file);
                 PrintWriter output = new PrintWriter(outFile)) {
                String first = "";
                if (input.hasNext())
                    first = input.nextLine();
                positionOfExist = 1;
                while (input.hasNext()) {
                    if (first.compareTo(name) > 0)
                        break;
                    output.println(first);
                    first = input.nextLine();
                    positionOfExist++;
                }
                output.println(name);
                output.println(first);
                while (input.hasNext()) {
                    output.println(input.nextLine());
                }
            } catch (FileNotFoundException ex) {
                return -1;
            }
            com.d9nich.exercise12.Refactor.copyingOfFile(file, outFile);
        }
        return positionOfExist;
    }
}
