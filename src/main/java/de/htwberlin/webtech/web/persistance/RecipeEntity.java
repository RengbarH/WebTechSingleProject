package de.htwberlin.webtech.web.persistance;

import javax.persistence.*;

@Entity(name = "recipes")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "recipe_title")
    private String recipeTitle;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "complexity")
    private Complexity complexity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private PersonEntity owner;

    public RecipeEntity() {
    }

    public RecipeEntity(String recipeTitle, String subtitle, Complexity complexity, PersonEntity owner) {
        this.recipeTitle = recipeTitle;
        this.subtitle = subtitle;
        this.complexity = complexity;
        this.owner = owner;
    }

    public Long getId() {
        return id;
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

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity owner) {
        this.owner = owner;
    }
}
