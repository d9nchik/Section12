package com.d9nich.exercise24;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreatorOfDataset {
    public static void main(String[] args) {
        String[] rank = {"assistant", "associate", "full"};
        try (PrintWriter output = new PrintWriter("src/com/d9nich/exercise24/Salary.txt")) {
            Random my = new Random();
            for (int i = 0; i < 1_000; i++) {
                output.print("FirstName" + (i + 1) + " LastName" + (i + 1) + " ");
                int rankNumber = my.nextInt(rank.length);
                output.print(rank[rankNumber] + " ");
                double salary;
                if (rankNumber == 0)
                    salary = 50_000 + my.nextDouble() * 30_000;
                else if (rankNumber == 1)
                    salary = 60_000 + my.nextDouble() * 50_000;
                else
                    salary = 75_000 + my.nextDouble() * 55_000;
                output.printf("%.2f\n", salary);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with finding file");
            System.exit(2);
        }
    }
}
