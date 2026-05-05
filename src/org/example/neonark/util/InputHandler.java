package org.example.neonark.util;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner = new Scanner(System.in);

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

    public String getOptionalInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}