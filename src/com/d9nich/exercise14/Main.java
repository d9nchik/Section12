package com.d9nich.exercise14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(readInFile("George", new File("src/com/d9nich/exercise14/peopleNames.txt")));
    }

    public static int readInFile(String line, File file) {
        int numberOfLine = -1;
        try (Scanner input = new Scanner(file)) {
            int counter = 1;
            while (input.hasNext()) {
                if (line.equals(input.nextLine())) {
                    numberOfLine = counter;
                    break;
                }
                counter++;
            }
        } catch (FileNotFoundException ex) {
            return -1;
        }
        return numberOfLine;
    }
}
