package com.d9nich.exercise20;

import com.d9nich.exercise12.Refactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DelPackage {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage DelPackageStatement srcRootDirectory");
            System.exit(1);
        }
        File sourceDirectory = validationOfGivenData(args);

        remarkAllFiles(sourceDirectory);
    }

    public static File validationOfGivenData(String[] args) {
        File sourceDirectory = new File(args[0]);

        if (!sourceDirectory.exists()) {
            System.out.println("Path not exist");
            System.exit(3);
        }

        if (!sourceDirectory.isDirectory()) {
            System.out.println("File has been given");
            System.exit(2);
        }
        return sourceDirectory;
    }

    private static void remarkAllFiles(File fatherDirectory) {
        File[] objectInFather = fatherDirectory.listFiles();
        assert objectInFather != null;
        for (File file : objectInFather) {
            if (file.isDirectory())
                remarkAllFiles(file);
            else if (file.getName().split("\\.")[1].equals("java"))
                delPackage(file);
        }
    }

    private static void delPackage(File fileToChange) {
        File targetFile = new File("temp.txt");
        try (
                Scanner input = new Scanner(fileToChange);
                PrintWriter output = new PrintWriter(targetFile)
        ) {
            if (input.hasNext() && !input.nextLine().split(" ")[0].equals("package")) {
                output.close();
                if (!targetFile.delete())
                    System.out.println("Problem of deleting ");
                return;
            }
            while (input.hasNext()) {
                output.println(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("System error");
            System.exit(106);
        }

        Refactor.copyingOfFile(fileToChange, targetFile);
    }
}
