package com.d9nich.exercise29;

import com.d9nich.exercise28.FileNameReplace;

import java.io.File;

public class FileRenaming {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage FileRenaming argument");
            System.exit(1);
        }
        File[] filesInDirectory = FileNameReplace.checkOfDirectory(args);
        for (File file : filesInDirectory) {
            if (file.isFile() && file.getName().matches("Exercise\\d*_\\d\\.\\w*")) {
                String name = file.getParent() + "/" + file.getName().replaceFirst("_", "_0");
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
