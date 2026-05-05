package org.example.neonark.model;

/*
 This class represents a single Warden.
 It just holds data that comes from the CSV file.
*/
public class Warden {

    private int wardenId;
    private String firstName;
    private String lastName;
    private String email;
    private String identifierType;
    private String identifierValue;
    private String role;
    private String employmentStatus;
    private String clearanceLevel;
    private String startDate;
    private String endDate;

    /*
     Constructor used to create a Warden object from CSV data.
    */
    public Warden(int wardenId, String firstName, String lastName, String email,
                  String identifierType, String identifierValue, String role,
                  String employmentStatus, String clearanceLevel,
                  String startDate, String endDate) {

        this.wardenId = wardenId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.identifierType = identifierType;
        this.identifierValue = identifierValue;
        this.role = role;
        this.employmentStatus = employmentStatus;
        this.clearanceLevel = clearanceLevel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // getters below just return each field

    public int getWardenId() {
        return wardenId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public String getIdentifierValue() {
        return identifierValue;
    }

    public String getRole() {
        return role;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public String getClearanceLevel() {
        return clearanceLevel;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}