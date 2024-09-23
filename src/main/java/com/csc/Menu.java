package com.csc;
import java.util.Scanner;

public class Menu
{
    public static Integer validateInput(Integer lowerBound, Integer upperBound, String prompt, String error)
    {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        Integer input = null; // default of 0
        boolean valid = false;

        System.out.println(prompt);

        while(!valid)
        {
            if(scan.hasNextInt())
            {
                input = scan.nextInt();

                if (isWithinBounds(input, lowerBound, upperBound)) 
                {
                    valid = true;
                } else 
                {
                    System.out.println(error);
                }
            }
            else
            {
                String userInput = scan.next();
                if(userInput.equalsIgnoreCase("exit"))
                {
                    break;
                }
                else if(userInput.equalsIgnoreCase("default"))
                {
                    input = 10;

                    if (isWithinBounds(input, lowerBound, upperBound)) 
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
        }

        return input;
    }

    public static boolean isWithinBounds(Integer input, Integer lowerBound, Integer upperBound) 
    {
        boolean withinLowerBound = (lowerBound == null || input >= lowerBound);
        boolean withinUpperBound = (upperBound == null || input <= upperBound);

        return withinLowerBound && withinUpperBound;
    }

    public static void handleUserInput(Integer value, String exitMessage)
    {
        if (value != null) 
        {
            System.out.println("You entered: " + value);
        } 
        else 
        {
            System.out.println(exitMessage);
        }
    }

    public static void main(String[] args) 
    {
        // Test case 1: No bounds
        Integer value1 = validateInput(null, null, "Enter any integer (Enter \"default\" to use default value of 10 [\"exit\" to leave test case]): ", "Invalid input, try again!");
        handleUserInput(value1, "You exited the test case.");

        // Test case 2: With a lower bound
        Integer value2 = validateInput(10, null, "Enter an integer >= 10 (Enter \"default\" to use default value of 10 [\"exit\" to leave test case]): ", "That's not it.");
        handleUserInput(value2, "You exited the test case.");

        // Test case 3: With an upper bound
        Integer value3 = validateInput(null, 20, "Enter an integer <= 20 (Enter \"default\" to use default value of 10 [\"exit\" to leave test case]): ", "ERROR! I REPEAT! ERROR!.");
        handleUserInput(value3, "You exited the test case.");

        // Test case 4: With both bounds
        Integer value4 = validateInput(5, 15, "Enter an integer between 5 and 15 (Enter \"default\" to use default value of 10 [\"exit\" to leave test case]): ", "Invalid input, please try again.");
        handleUserInput(value4, "You exited the test case.");
    }
}