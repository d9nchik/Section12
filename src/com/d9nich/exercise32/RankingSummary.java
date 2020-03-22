package com.d9nich.exercise32;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RankingSummary {
    public static void main(String[] args) {
        for (int i = 0; i < 140; i++)
            System.out.print("*");
        System.out.println();
        System.out.print("Year\t");
        for (int i = 0; i < 2; i++)
            for (int j = 1; j <= 5; j++)
                System.out.printf("Rank %-6d", j);
        System.out.println();
        for (int i = 0; i < 140; i++)
            System.out.print("*");
        System.out.println();

        for (int year = 2010; year >= 2001; year--) {
            System.out.print(year + "\t");
            try {

                URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking"
                        + year + ".txt");

                Scanner input = new Scanner(url.openStream());
                String[] manNames = new String[5];
                for (int i = 0; i < 5; i++) {
                    String[] words = input.nextLine().split("\\s");
                    manNames[i] = words[2];
                    System.out.printf("%-11s", words[5]);
                }
                for (int i = 0; i < 5; i++)
                    System.out.printf("%-11s", manNames[i]);
                System.out.println();
            } catch (MalformedURLException ex) {
                System.out.println("Invalid URL");
            } catch (IOException ex) {
                System.out.println("I/O Errors: no such file");
            }

        }
    }
}
