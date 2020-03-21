package com.d9nich.exercise27;

import com.d9nich.exercise12.Refactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordReplace {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage WordReplace argument");
            System.exit(1);
        }
        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.out.println("Directory not exist");
            System.exit(2);
        }
        if (!directory.isDirectory()) {
            System.out.println("Not directory provided");
            System.exit(3);
        }
        File[] filesInDirectory = directory.listFiles();
        assert filesInDirectory != null;
        for (File file : filesInDirectory) {
            if (file.isFile()) {
                File outFile = new File("output.txt");
                try (Scanner input = new Scanner(file);
                     PrintWriter output = new PrintWriter(outFile)) {
                    while (input.hasNext()) {
                        String line = input.nextLine();
                        if (line.matches(".*Exercise\\d+_\\d+.*")) {
                            StringBuilder outString = new StringBuilder();
                            String[] words = line.split(" ");
                            for (String word : words) {
                                if (word.matches("Exercise\\d+_\\d+")) {
                                    String workingWord = word.substring(8);
                                    addingToSingleZero(outString, workingWord);
                                    outString.append(" ");
                                } else
                                    outString.append(word).append(" ");
                            }
                            outString.deleteCharAt(outString.length() - 1);
                            output.println(outString.toString());
                        } else
                            output.println(line);
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("System problem");
                }
                Refactor.copyingOfFile(file, outFile);
            }
        }
    }

    private static void addingToSingleZero(StringBuilder outString, String workingWord) {
        outString.append("Exercise");
        String[] numbers = workingWord.split("_");
        if (numbers[0].length() == 1 && numbers[0].charAt(0) <= '9')
            outString.append('0');
        outString.append(numbers[0]).append("_");
        if (numbers[1].length() == 1 && numbers[1].charAt(0) <= '9')
            outString.append('0');
        outString.append(numbers[1]);
    }
}
