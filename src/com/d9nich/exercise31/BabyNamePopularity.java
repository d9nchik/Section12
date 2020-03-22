package com.d9nich.exercise31;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class BabyNamePopularity {
    public static void main(String[] args) {
        Scanner inputFromConsole = new Scanner(System.in);


        try {
            System.out.print("Enter the year: ");
            int year = inputFromConsole.nextInt();
            URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking"
                    + year + ".txt");
            System.out.print("Enter the gender: ");
            char gender = inputFromConsole.next().charAt(0);
            if (gender != 'M' && gender != 'F') {
                System.out.println("Gender is incorrect!");
                System.exit(1);
            }
            System.out.print("Enter the name: ");
            String name = inputFromConsole.next();

            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String[] words = input.nextLine().split("\\s");
                if ((gender == 'M' && name.equals(words[2])) || (gender == 'F' && name.equals(words[5]))) {
                    System.out.println(name + " is ranked #" + words[0] + " in year " + year);
                    System.exit(0);
                }
            }
            System.out.println("The name " + name + " is not ranked in year " + year);
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
    }
}
