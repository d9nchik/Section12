package com.d9nich.exercise1;

public class Calculator {
    public static void main(String[] args) {
        // Check number of strings passed
        if (args.length != 3) {
            System.out.println(
                    "Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        // The result of the operation
        int result = 0;
        try {
            // Determine the operator
            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) +
                            Integer.parseInt(args[2]);
                    break;
                case '−':
                    result = Integer.parseInt(args[0]) -
                            Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) *
                            Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) /
                            Integer.parseInt(args[2]);
            }

            // Display result
            System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                    + " = " + result);

        } catch (NumberFormatException ex) {

            String output = ex.getMessage().replaceFirst("For input string: \"", "Wrong Input: ");
            output=output.substring(0, output.length()-1);
            System.out.println(output);
        }
    }
}
