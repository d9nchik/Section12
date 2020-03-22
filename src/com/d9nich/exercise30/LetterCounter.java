package com.d9nich.exercise30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LetterCounter {
    public static void main(String[] args) {
        int[] counterOfLetters = new int['Z' - 'A' + 1];

        System.out.print("Enter a filename: ");
        File inputFile = new File(new Scanner(System.in).nextLine());

        try (Scanner input = new Scanner(inputFile)) {
            while (input.hasNext()) {
                String line = input.nextLine().toUpperCase();
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (symbol <= 'Z' && symbol >= 'A')
                        counterOfLetters[symbol - 'A']++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with finding file");
        }

        for (int i = 0; i < counterOfLetters.length; i++)
            System.out.println("Number of " + (char) ('A' + i) + "s: " + counterOfLetters[i]);
    }
}
