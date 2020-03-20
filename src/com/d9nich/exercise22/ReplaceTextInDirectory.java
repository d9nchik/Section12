package com.d9nich.exercise22;

import com.d9nich.exercise16.ReplaceText;

import java.io.File;
import java.io.FileNotFoundException;

public class ReplaceTextInDirectory {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage ReplaceTextInDirectory dir oldString newString");
            System.exit(1);
        }
        File fatherDirectory = new File(args[0]);
        File[] subObjects = fatherDirectory.listFiles();
        assert subObjects != null;
        try {

            for (File subObject : subObjects) {
                if (subObject.isFile()) {
                    String[] output = {subObject.getPath(), args[1], args[2]};
                    ReplaceText.main(output);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with opening file!");
            System.exit(2);
        }
    }
}
