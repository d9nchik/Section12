package com.d9nich.exercise13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: pathToFile");
            System.exit(1);
        }
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.out.println("File doesn't exist");
        }

        int numberOfCharacters = 0;
        int numberOfWords = 0;
        int numberOfLines = 0;

        try (
                Scanner input = new Scanner(inputFile)
        ) {
            while (input.hasNext()) {
                String line = input.nextLine();
                numberOfCharacters += line.length();
                numberOfLines++;
                numberOfWords += line.split(" ").length;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("File " + args[0] + " has");
        System.out.println(numberOfCharacters + " characters");
        System.out.println(numberOfWords + " words");
        System.out.println(numberOfLines + " lines");
    }
}
