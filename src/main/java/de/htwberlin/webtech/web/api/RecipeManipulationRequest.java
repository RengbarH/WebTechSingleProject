package de.htwberlin.webtech.web.api;

public class RecipeManipulationRequest {

    private String recipeTitle;
    private String subtitle;
    private String complexity;
    private Long ownerId;

    public RecipeManipulationRequest(String recipeTitle, String subtitle, String complexity, Long ownerId) {
        this.recipeTitle = recipeTitle;
        this.subtitle = subtitle;
        this.complexity = complexity;
        this.ownerId = ownerId;
    }

    public RecipeManipulationRequest() {
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
