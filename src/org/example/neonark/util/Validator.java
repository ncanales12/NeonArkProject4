package org.example.neonark.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/*
 This class holds simple validation rules for the program.
 It keeps validation separate from the menu and service code.
*/
public class Validator {

    /*
     Checks if a value is blank.
    */
    public boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    /*
     Checks for a basic email format.
    */
    public boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    /*
     Checks that the date can be read as YYYY-MM-DD.
    */
    public boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /*
     Checks if the role is one of the allowed values.
    */
    public boolean isValidRole(String role) {
        return role.equals("Admin")
                || role.equals("Field")
                || role.equals("Rift")
                || role.equals("Trainer")
                || role.equals("Astral");
    }

    /*
     Checks if the status is one of the allowed values.
    */
    public boolean isValidStatus(String status) {
        return status.equals("Active")
                || status.equals("OnLeave")
                || status.equals("Terminated");
    }

    /*
     Checks if the clearance is one of the allowed values.
    */
    public boolean isValidClearance(String clearance) {
        return clearance.equals("Alpha")
                || clearance.equals("Omega")
                || clearance.equals("Eclipse");
    }

    /*
     Checks if the identifier type is one of the allowed values.
    */
    public boolean isValidIdentifierType(String type) {
        return type.equals("Badge")
                || type.equals("Passport")
                || type.equals("Visa");
    }
}