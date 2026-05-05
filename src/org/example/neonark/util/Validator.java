package org.example.neonark.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Validator {

    public boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean isValidRole(String role) {
        return role.equals("Admin")
                || role.equals("Field")
                || role.equals("Rift")
                || role.equals("Trainer")
                || role.equals("Astral");
    }

    public boolean isValidStatus(String status) {
        return status.equals("Active")
                || status.equals("OnLeave")
                || status.equals("Terminated");
    }

    public boolean isValidClearance(String clearance) {
        return clearance.equals("Alpha")
                || clearance.equals("Omega")
                || clearance.equals("Eclipse");
    }

    public boolean isValidIdentifierType(String type) {
        return type.equals("Badge")
                || type.equals("Passport")
                || type.equals("Visa");
    }
}