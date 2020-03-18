package com.d9nich.exercise11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Remover {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(
                    "Usage: java Remover wordToDel sourceFile");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[1]);
        if (!sourceFile.exists()) {
            System.out.println("File " + args[1] + " does not exist");
            System.exit(2);
        }

File outputFile = new File("temp.txt");

        try (
// input and output files
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(outputFile)
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[0], "");
                output.println(s2);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try (
// input and output files
                Scanner input = new Scanner(outputFile);
                PrintWriter output = new PrintWriter(sourceFile)
        ) {
            while (input.hasNext()) {
                output.println(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Program error");
        }
        if (!outputFile.delete())
            System.out.println("Problem with deleting");

    }
}
