package de.htwberlin.webtech.web.api;

public class IngredientManipulationRequest {

    private String name;
    private Long recipeId;

    public IngredientManipulationRequest(String name, Long recipeId) {
        this.name = name;
        this.recipeId = recipeId;
    }

    public IngredientManipulationRequest() {
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
