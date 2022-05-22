package de.htwberlin.webtech.web.api;

import java.util.List;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String identifier;
    private List<Long> recipeId;

    public Person(long id, String firstName, String lastName, String gender, String identifier, List<Long> recipeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.identifier = identifier;
        this.recipeId = recipeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Long> getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(List<Long> recipeId) {
        this.recipeId = recipeId;
    }
}
