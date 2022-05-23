package de.htwberlin.webtech.web.service;

import de.htwberlin.webtech.web.api.Ingredient;
import de.htwberlin.webtech.web.api.IngredientManipulationRequest;
import de.htwberlin.webtech.web.persistance.IngredientEntity;
import de.htwberlin.webtech.web.persistance.IngredientRepository;
import de.htwberlin.webtech.web.persistance.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;


    public IngredientService(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> recipes = ingredientRepository.findAll();
        return recipes.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Ingredient findById(Long id) {
        var ingredientEntity = ingredientRepository.findById(id);
        return ingredientEntity.map(this::transformEntity).orElse(null);
    }


    public Ingredient create(IngredientManipulationRequest request) {
        var recipe = recipeRepository.findById(request.getRecipeId()).orElseThrow();

        var ingredientEntity = new IngredientEntity(request.getName(), recipe);
        ingredientEntity = ingredientRepository.save(ingredientEntity);

        return transformEntity(ingredientEntity);
    }

    public Ingredient update(Long id, IngredientManipulationRequest request) {
        var ingredientEntityOptional = ingredientRepository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }
        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setName(request.getName());
        ingredientEntity = ingredientRepository.save(ingredientEntity);

        return transformEntity(ingredientEntity);
    }


    public boolean deleteById(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return false;
        }
        ingredientRepository.deleteById(id);
        return true;
    }


    private Ingredient transformEntity(IngredientEntity ingredientEntity) {
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getName(),
                ingredientEntity.getRecipe().getId()
        );
    }


}
