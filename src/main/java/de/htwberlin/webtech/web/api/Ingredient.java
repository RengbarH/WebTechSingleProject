package de.htwberlin.webtech.web.api;

public class Ingredient {

    private Long id;
    private String name;

    private Long recipeId;

    public Ingredient(Long id, String name, Long recipeId) {
        this.id = id;
        this.name = name;
        this.recipeId = recipeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
