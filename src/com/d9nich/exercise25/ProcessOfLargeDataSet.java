package com.d9nich.exercise25;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ProcessOfLargeDataSet {
    public static void main(String[] args) {
        final String[] rank = {"assistant", "associate", "full"};
        double[] salary = new double[rank.length];
        int[] counter = new int[rank.length];
        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
            Scanner input = new Scanner(url.openStream());

            while (input.hasNext()) {
                String[] words = input.nextLine().split(" ");
                if (words.length != 4) {
                    System.out.println("Problem with data in file");
                    continue;
                }
                for (int i = 0; i < rank.length; i++)
                    if (rank[i].equals(words[2])) {
                        salary[i] += Double.parseDouble(words[3]);
                        counter[i]++;
                        break;
                    }
            }
            System.out.println("Total salary:");
            for (int i = 0; i < rank.length; i++) {
                System.out.printf("%s = %.2f\n", rank[i], salary[i]);
            }
            System.out.println("Average salary:");
            for (int i = 0; i < rank.length; i++) {
                System.out.printf("%s = %.2f\n", rank[i], salary[i] / (double) counter[i]);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Errors no such file");
        }
    }
}
