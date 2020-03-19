package com.d9nich.exercise19;

import com.d9nich.exercise12.Refactor;
import com.d9nich.exercise15.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LinkingTwoFiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File bookFile = new File("src/com/d9nich/exercise19/books.txt");
        File authorFile = new File("src/com/d9nich/exercise19/authors.txt");
        char answer;
        do {
            System.out.print("Enter title of book: ");
            String title = input.nextLine();
            System.out.print("Enter author: ");
            String author = input.nextLine();
            if (!addBook(author, title, authorFile, bookFile))
                System.out.println("Adding of book is unsuccessful!");
            System.out.print("Do you want to continue(y,n): ");
            answer = input.nextLine().charAt(0);
        } while (answer != 'n');
    }

    private static boolean addBook(String authorName, String bookName, File authorFile, File bookFile) {
        File outputFile = new File("temp1.txt");
        try (Scanner input = new Scanner(bookFile); PrintWriter output = new PrintWriter(outputFile)) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                if (s1.split(" ")[0].equals(bookName.split(" ")[0])) {
                    if (outputFile.delete()) {
                        System.out.println("File deleting unsuccessful!");
                        return false;
                    }
                    return true;
                }
                output.println(s1);
            }
            output.println(bookName + " " + Main.writeInFile(authorName, authorFile));
        } catch (FileNotFoundException ex) {
            return false;
        }
        Refactor.copyingOfFile(bookFile, outputFile);
        return true;
    }
}
