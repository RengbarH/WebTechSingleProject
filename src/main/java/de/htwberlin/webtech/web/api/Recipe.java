package de.htwberlin.webtech.web.api;

public class Recipe {

    private Long id;
    private String recipeTitle;
    private String subtitle;
    private String complexity;

    public Recipe(Long id, String recipeTitle, String subtitle, String complexity) {
        this.id = id;
        this.recipeTitle = recipeTitle;
        this.subtitle = subtitle;
        this.complexity = complexity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
