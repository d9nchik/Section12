package com.d9nich.exercise28;

import java.io.File;

public class FileNameReplace {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage FileNameReplace argument");
            System.exit(1);
        }
        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.out.println("Directory not exist");
            System.exit(2);
        }
        if (!directory.isDirectory()) {
            System.out.println("Not directory provided");
            System.exit(3);
        }
        File[] filesInDirectory = directory.listFiles();
        assert filesInDirectory != null;
        for (File file : filesInDirectory) {
            if (file.isFile() && file.getName().matches("Exercise\\d_\\d+\\..*")) {
                String name = file.getParent() + "/" + file.getName().replaceFirst("Exercise", "Exercise0");
                File newDestination = new File(name);
                if (newDestination.exists()) {
                    System.out.println("File with changed name already exist");
                    continue;
                }
                if (!file.renameTo(newDestination))
                    System.out.println("Renaming of file is unsuccessful");
            }
        }
    }
}
