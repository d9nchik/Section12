package com.d9nich.exercise18;

import com.d9nich.exercise12.Refactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddPackageStatement {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage AddPackageStatement srcRootDirectory");
            System.exit(1);
        }
        File sourceDirectory = new File(args[0]);

        if (!sourceDirectory.exists()) {
            System.out.println("Path not exist");
            System.exit(3);
        }

        if (!sourceDirectory.isDirectory()) {
            System.out.println("File has been given");
            System.exit(2);
        }

        markAllFiles(sourceDirectory, sourceDirectory);
    }

    private static void markAllFiles(File fatherDirectory, File parent) {
        File[] objectInFather = fatherDirectory.listFiles();
        assert objectInFather != null;
        for (File file : objectInFather) {
            if (file.isDirectory())
                markAllFiles(file, parent);
            else
                addPackage(file, parent);
        }
    }

    private static void addPackage(File fileToChange, File parent) {
        String absolutePath = parent.getAbsolutePath();
        if (fileToChange.getParent().length() < absolutePath.length() + 1)
            return;
        String nameOfPackage = fileToChange.getParent().substring(absolutePath.length() + 1);
        nameOfPackage = nameOfPackage.replaceAll("\\\\", ".");
        File targetFile = new File("temp.txt");
        try (
// Create input and output files
                Scanner input = new Scanner(fileToChange);
                PrintWriter output = new PrintWriter(targetFile)
        ) {
            output.println("package " + nameOfPackage + ";");
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
