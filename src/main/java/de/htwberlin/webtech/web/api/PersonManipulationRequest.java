package de.htwberlin.webtech.web.api;

public class PersonManipulationRequest {

    private String firstName;
    private String lastName;
    private String gender;

    private String identifier;

    public PersonManipulationRequest(String firstName, String lastName, String gender, String identifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.identifier = identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
