package de.htwberlin.webtech.web.api;

public class RecipeManipulationRequest {

    private String recipeTitle;
    private String subtitle;
    private String complexity;

    public RecipeManipulationRequest(String recipeTitle, String subtitle, String complexity) {
        this.recipeTitle = recipeTitle;
        this.subtitle = subtitle;
        this.complexity = complexity;
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
}
