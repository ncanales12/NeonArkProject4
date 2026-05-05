package org.example.neonark.service;

import org.example.neonark.data.CsvWardenRepository;
import org.example.neonark.model.Warden;
import org.example.neonark.util.InputHandler;
import org.example.neonark.util.Validator;

import java.util.List;

public class WardenService {

    private CsvWardenRepository repository = new CsvWardenRepository();
    private InputHandler input = new InputHandler();
    private Validator validator = new Validator();

    public void addNewWarden() {
        System.out.println("\n=== ADD NEW WARDEN ===");

        String firstName = input.getRequiredInput("First name: ");
        String lastName = input.getRequiredInput("Last name: ");

        String email;
        while (true) {
            email = input.getRequiredInput("Email: ");

            if (!validator.isValidEmail(email)) {
                System.out.println("Invalid email format. Try again.");
            } else if (emailAlreadyExists(email)) {
                System.out.println("That email already exists. Try again.");
            } else {
                break;
            }
        }

        String identifierType;
        while (true) {
            identifierType = input.getRequiredInput("Identifier type (Badge, Passport, Visa): ");

            if (validator.isValidIdentifierType(identifierType)) {
                break;
            }

            System.out.println("Invalid identifier type. Use Badge, Passport, or Visa.");
        }

        String identifierValue;
        while (true) {
            identifierValue = input.getRequiredInput("Identifier value: ");

            if (identifierAlreadyExists(identifierType, identifierValue)) {
                System.out.println("That identifier already exists. Try again.");
            } else {
                break;
            }
        }

        String role;
        while (true) {
            role = input.getRequiredInput("Role (Admin, Field, Rift, Trainer, Astral): ");

            if (validator.isValidRole(role)) {
                break;
            }

            System.out.println("Invalid role. Use Admin, Field, Rift, Trainer, or Astral.");
        }

        String status;
        while (true) {
            status = input.getRequiredInput("Status (Active, OnLeave, Terminated): ");

            if (validator.isValidStatus(status)) {
                break;
            }

            System.out.println("Invalid status. Use Active, OnLeave, or Terminated.");
        }

        String clearance;
        while (true) {
            clearance = input.getRequiredInput("Clearance (Alpha, Omega, Eclipse): ");

            if (validator.isValidClearance(clearance)) {
                break;
            }

            System.out.println("Invalid clearance. Use Alpha, Omega, or Eclipse.");
        }

        String startDate;
        while (true) {
            startDate = input.getRequiredInput("Start date (YYYY-MM-DD): ");

            if (validator.isValidDate(startDate)) {
                break;
            }

            System.out.println("Invalid date. Use YYYY-MM-DD.");
        }

        System.out.println("\nHTTP METHOD: POST");
        System.out.println("ENDPOINT: /api/wardens");
        System.out.println("DESCRIPTION: Create new warden");

        System.out.println("\nPAYLOAD:");
        System.out.println("{");
        System.out.println("  \"firstName\": \"" + firstName + "\",");
        System.out.println("  \"lastName\": \"" + lastName + "\",");
        System.out.println("  \"email\": \"" + email + "\",");
        System.out.println("  \"identifierType\": \"" + identifierType + "\",");
        System.out.println("  \"identifierValue\": \"" + identifierValue + "\",");
        System.out.println("  \"role\": \"" + role + "\",");
        System.out.println("  \"status\": \"" + status + "\",");
        System.out.println("  \"clearance\": \"" + clearance + "\",");
        System.out.println("  \"startDate\": \"" + startDate + "\"");
        System.out.println("}");

        System.out.println("\nRESULT: SUCCESS (simulated)");
        System.out.println("NOTE: CSV file was not changed.");
    }

    public void viewAllWardens() {
        List<Warden> wardens = repository.getAllWardens();

        if (wardens.isEmpty()) {
            System.out.println("No wardens found.");
            return;
        }

        System.out.println("\n=== ALL WARDENS ===");
        System.out.printf("%-4s %-12s %-12s %-28s %-10s %-10s %-12s %-12s%n",
                "ID", "First", "Last", "Email", "Role", "Status", "Clearance", "Start Date");

        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Warden warden : wardens) {
            System.out.printf("%-4d %-12s %-12s %-28s %-10s %-10s %-12s %-12s%n",
                    warden.getWardenId(),
                    warden.getFirstName(),
                    warden.getLastName(),
                    warden.getEmail(),
                    warden.getRole(),
                    warden.getEmploymentStatus(),
                    warden.getClearanceLevel(),
                    warden.getStartDate());
        }
    }

    public void updateWardenSimulated() {
        System.out.println("\n=== UPDATE WARDEN (SIMULATED) ===");
        System.out.println("HTTP METHOD: PUT");
        System.out.println("ENDPOINT: /api/wardens/{wardenId}");
        System.out.println("DESCRIPTION: Update an existing warden record");
        System.out.println("RESULT: SUCCESS (simulated)");
        System.out.println("NOTE: No data was changed.");
    }

    public void manageCertificationsSimulated() {
        System.out.println("\n=== MANAGE CERTIFICATIONS (SIMULATED) ===");
        System.out.println("HTTP METHOD: POST");
        System.out.println("ENDPOINT: /api/wardens/{wardenId}/certifications");
        System.out.println("DESCRIPTION: Add or update warden certification information");
        System.out.println("RESULT: SUCCESS (simulated)");
        System.out.println("NOTE: No data was changed.");
    }

    public void deactivateWardenSimulated() {
        System.out.println("\n=== DEACTIVATE / TERMINATE WARDEN (SIMULATED) ===");
        System.out.println("HTTP METHOD: PATCH");
        System.out.println("ENDPOINT: /api/wardens/{wardenId}/status");
        System.out.println("DESCRIPTION: Change warden employment status");
        System.out.println("RESULT: SUCCESS (simulated)");
        System.out.println("NOTE: No data was changed.");
    }

    private boolean emailAlreadyExists(String email) {
        List<Warden> wardens = repository.getAllWardens();

        for (Warden warden : wardens) {
            if (warden.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    private boolean identifierAlreadyExists(String type, String value) {
        List<Warden> wardens = repository.getAllWardens();

        for (Warden warden : wardens) {
            if (warden.getIdentifierType().equalsIgnoreCase(type)
                    && warden.getIdentifierValue().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }
}