package com.d9nich.exercise16;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String[] output = {"src/com/d9nich/exercise16/input.txt", "типа", "*"};
        try {
            ReplaceText.main(output);
        } catch (FileNotFoundException ex) {
            System.out.println("File path is incorrect!");
        }
    }
}
