package de.htwberlin.webtech.web.api;

public class Recipe {

    private Long id;
    private String recipeTitle;
    private String subtitle;
    private String complexity;
    private Long ownerId;

    public Recipe(Long id, String recipeTitle, String subtitle, String complexity, Long ownerId) {
        this.id = id;
        this.recipeTitle = recipeTitle;
        this.subtitle = subtitle;
        this.complexity = complexity;
        this.ownerId = ownerId;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
