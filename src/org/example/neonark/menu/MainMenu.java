package org.example.neonark.menu;

import org.example.neonark.service.WardenService;

import java.util.Scanner;

/*
 This class controls the main menu of the program.
 It shows options to the user and routes them to the correct feature.
*/
public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private WardenService wardenService = new WardenService();

    /*
     Starts the menu loop.
     Keeps running until the user chooses to exit.
    */
    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    wardenService.addNewWarden();
                    break;
                case 2:
                    wardenService.viewAllWardens();
                    break;
                case 3:
                    wardenService.updateWardenSimulated();
                    break;
                case 4:
                    wardenService.manageCertificationsSimulated();
                    break;
                case 5:
                    wardenService.deactivateWardenSimulated();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /*
     Prints the menu options to the screen.
    */
    private void printMenu() {
        System.out.println("\n=== NEON ARK WARDEN CONSOLE ===");
        System.out.println("1. Add New Warden");
        System.out.println("2. View Wardens");
        System.out.println("3. Update Warden");
        System.out.println("4. Manage Certifications");
        System.out.println("5. Deactivate / Terminate Warden");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    /*
     Gets user input and makes sure it is a number.
    */
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // clears leftover input
        return choice;
    }
}