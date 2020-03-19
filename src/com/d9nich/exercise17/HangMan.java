package com.d9nich.exercise17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        File inputFile = new File("src/com/d9nich/exercise17/hangman.txt");

        if (!inputFile.exists()) {
            System.out.println("System error. Path is incorrect.");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);

        int numberOfWords = countWords(inputFile);


        char userContinue = 'y';
        while (userContinue != 'n') {
            String word = getWord(inputFile, (int) (Math.random() * numberOfWords));
            char[] guessingWord = createGuessingWord(word.length());

            int missed = 0;

            while (!(isGuessed(guessingWord))) {
                System.out.print("(Guess) Enter a letter in word ");
                showWord(guessingWord);
                System.out.print(" > ");
                char userChoice = input.next().charAt(0);
                if (isLetterOnTheWord(userChoice, word)) {
                    openLetter(userChoice, guessingWord, word);
                } else {
                    missed++;
                    System.out.println("\t" + userChoice + " is not in the word");
                }
            }

            System.out.println("The word is " + word + ". You missed " + missed + " time");
            System.out.println();
            System.out.print("Do you want to guess another word? Enter y or n> ");
            userContinue = input.next().charAt(0);
        }

    }

    public static char[] createGuessingWord(int length) {
        char[] guessingWord = new char[length];
        Arrays.fill(guessingWord, '*');
        return guessingWord;
    }

    public static boolean isGuessed(char[] guessingWord) {
        for (char c : guessingWord) {
            if (c == '*')
                return false;
        }
        return true;
    }

    public static void openLetter(char symbol, char[] guessingWord, String word) {
        for (int k = 0; k < word.length(); k++) {
            if (word.charAt(k) == symbol) {
                if (guessingWord[k] == symbol) {
                    System.out.println("\t" + symbol + " is already in the word");
                    return;
                }

                guessingWord[k] = symbol;
            }
        }
    }

    public static boolean isLetterOnTheWord(char symbol, String word) {
        for (int k = 0; k < word.length(); k++) {
            if (word.charAt(k) == symbol)
                return true;
        }
        return false;
    }

    public static void showWord(char[] word) {
        for (char symbol : word)
            System.out.print(symbol);
    }

    private static int countWords(File inputFile) {
        int counter = 0;
        try (
                Scanner input = new Scanner(inputFile)
        ) {
            input.useDelimiter(" ");
            while (input.hasNext()) {
                input.next();
                counter++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File with data not found!");
        }
        return counter;
    }

    private static String getWord(File inputFile, int wordIndex) {
        int counter = 0;
        String word = "";
        try (
                Scanner input = new Scanner(inputFile)
        ) {
            input.useDelimiter(" ");
            while (input.hasNext()) {
                word = input.next();
                if (counter == wordIndex)
                    return word;
                counter++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File with data not found!");
        }
        return word;
    }
}
