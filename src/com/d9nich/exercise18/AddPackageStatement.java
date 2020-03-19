package com.d9nich.exercise18;

import com.d9nich.exercise12.Refactor;
import com.d9nich.exercise20.DelPackage;

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
        File sourceDirectory = DelPackage.validationOfGivenData(args);

        markAllFiles(sourceDirectory, sourceDirectory);
    }

    private static void markAllFiles(File fatherDirectory, File parent) {
        File[] objectInFather = fatherDirectory.listFiles();
        assert objectInFather != null;
        for (File file : objectInFather) {
            if (file.isDirectory())
                markAllFiles(file, parent);
            else if (file.getName().split("\\.")[1].equals("java"))
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
