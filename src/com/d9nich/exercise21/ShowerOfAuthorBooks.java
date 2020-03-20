package com.d9nich.exercise21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShowerOfAuthorBooks {
    public static void main(String[] args) {
        File bookFile = new File("src/com/d9nich/exercise21/books.txt");
        File authorFile = new File("src/com/d9nich/exercise21/authors.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name of author: ");
        String nameOfAuthor = input.nextLine();
        int counter = 0;
        try (Scanner readerOfAuthor = new Scanner(authorFile)) {
            while (readerOfAuthor.hasNext()) {
                String author = readerOfAuthor.nextLine();
                counter++;
                if (author.equals(nameOfAuthor))
                    break;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Authors file not found");
            System.exit(2);
        }
        try (Scanner readerOfBooks = new Scanner(bookFile)) {
            while (readerOfBooks.hasNext()) {
                String bookName = readerOfBooks.nextLine();
                if (bookName.matches(counter + " .*"))
                    System.out.println(bookName.replaceFirst(counter + " ", ""));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Books file not found");
            System.exit(2);
        }
    }
}
