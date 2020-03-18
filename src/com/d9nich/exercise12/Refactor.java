package com.d9nich.exercise12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Refactor {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java Remover sourceFile");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            System.exit(2);
        }

        File outputFile = new File("temp.txt");

        try (
// input and output files
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(outputFile)
        ) {
            StringBuilder first = new StringBuilder(input.nextLine());
            while (input.hasNext()) {
                String second = input.nextLine();
                if (second.trim().charAt(0) == '{') {
                    first.append(" {");
                    second = second.replaceFirst("\\{", "");
                }
                if (first.toString().trim().length() != 0)
                    output.println(first);
                first = new StringBuilder(second);
            }
            if (first.toString().trim().length() != 0)
                output.println(first);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        copyingOfFile(sourceFile, outputFile);

    }

    public static void copyingOfFile(File sourceFile, File outputFile) {
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
