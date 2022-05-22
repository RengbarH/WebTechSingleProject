package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.Recipe;
import de.htwberlin.webtech.web.api.RecipeManipulationRequest;
import de.htwberlin.webtech.web.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;


    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/api/v1/recipes")
    public ResponseEntity<List<Recipe>> fetchRecipes() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping(path = "/api/v1/recipes/{id}")
    public ResponseEntity<Recipe> fetchRecipesById(@PathVariable Long id) {
        var recipe = recipeService.findById(id);
        return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/recipes")
    public ResponseEntity<Void> createRecipe(@RequestBody RecipeManipulationRequest request) throws URISyntaxException {
        var recipe = recipeService.create(request);
        URI uri = new URI("/api/v1/recipes/" + recipe.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeManipulationRequest request) {
        var recipe = recipeService.update(id, request);
        return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/recipes/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long id) {
        boolean successful = recipeService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
