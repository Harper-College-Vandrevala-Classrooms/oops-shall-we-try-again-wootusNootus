package com.csc;
import java.util.Scanner;

public class Menu
{
    public static int validateInput(Integer lowerBound, Integer upperBound, String prompt, String error)
    {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        int input = 0; // default of 0
        boolean valid = false;

        System.out.println(prompt);

        while(!valid)
        {
            if(scan.hasNextInt())
            {
                input = scan.nextInt();

                boolean withinLowerBound = true;
                if (lowerBound != null) 
                {
                    withinLowerBound = input >= lowerBound;
                }

                boolean withinUpperBound = true;
                if (upperBound != null) 
                {
                    withinUpperBound = input <= upperBound;
                }

                if (withinLowerBound && withinUpperBound) 
                {
                    valid = true;
                } else 
                {
                    System.out.println(error);
                }
            }
            else 
            {
                System.out.println(error);
                scan.next();
            }   
        }

        return input;
    }

    public static void main(String[] args) 
    {
        // Test case 1: No bounds
        int value1 = validateInput(null, null, "Enter any integer: ", "Invalid input, try again!");
        System.out.println("You entered: " + value1);

        // Test case 2: With a lower bound
        int value2 = validateInput(10, null, "Enter an integer >= 10: ", "That's not it.");
        System.out.println("You entered: " + value2);

        // Test case 3: With an upper bound
        int value3 = validateInput(null, 20, "Enter an integer <= 20: ", "ERROR! I REPEAT! ERROR!.");
        System.out.println("You entered: " + value3);

        // Test case 4: With both bounds
        int value4 = validateInput(50, 15, "Enter an integer between 5 and 15: ", "Invalid input, please try again.");
        System.out.println("You entered: " + value4);
    }
}