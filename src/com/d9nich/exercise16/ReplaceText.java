package com.d9nich.exercise16;

import com.d9nich.exercise12.Refactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 3) {
            System.out.println(
                    "Usage: java ReplaceText file oldStr newStr");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }


        File targetFile = new File("temp.txt");
        try (
// Create input and output files
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile)
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);
                output.println(s2);
            }
        }

        Refactor.copyingOfFile(sourceFile, targetFile);
    }
}
