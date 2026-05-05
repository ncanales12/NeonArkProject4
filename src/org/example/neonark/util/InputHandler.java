package org.example.neonark.util;

import java.util.Scanner;

/*
 This class handles user input from the console.
 It makes sure required fields are not left empty.
*/
public class InputHandler {

    private Scanner scanner = new Scanner(System.in);

    /*
     Gets input that cannot be blank.
     Keeps asking until the user enters something.
    */
    public String getRequiredInput(String prompt) {
        String input;

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();

            if (input == null || input.trim().isEmpty()) {
                System.out.println("This field is required. Try again.");
            } else {
                return input.trim();
            }
        }
    }

    /*
     Gets input that can be empty if needed.
    */
    public String getOptionalInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}