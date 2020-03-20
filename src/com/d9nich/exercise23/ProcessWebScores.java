package com.d9nich.exercise23;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ProcessWebScores {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
            Scanner input = new Scanner(url.openStream());
            long counter = 0;
            long total = 0;
            while (input.hasNext()) {
                String[] line = input.nextLine().split(" ");
                for (String s : line) {
                    counter++;
                    total += Integer.parseInt(s);
                }
            }
            System.out.println("Total scores are " + total);
            System.out.println("Average score is " + (double) total / counter);

        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Error: no such file");
        }

    }
}
