package de.htwberlin.webtech.web.service;

import de.htwberlin.webtech.web.api.Recipe;
import de.htwberlin.webtech.web.api.RecipeManipulationRequest;
import de.htwberlin.webtech.web.persistance.Complexity;
import de.htwberlin.webtech.web.persistance.PersonRepository;
import de.htwberlin.webtech.web.persistance.RecipeEntity;
import de.htwberlin.webtech.web.persistance.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final PersonRepository personRepository;


    public RecipeService(RecipeRepository recipeRepository, PersonRepository personRepository) {
        this.recipeRepository = recipeRepository;
        this.personRepository = personRepository;
    }

    public List<Recipe> findAll() {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe findById(Long id) {
        var recipeEntity = recipeRepository.findById(id);
        return recipeEntity.map(this::transformEntity).orElse(null);
    }

    public Recipe create(RecipeManipulationRequest request) {
        var complexity = Complexity.valueOf(request.getComplexity());
        var owner = personRepository.findById(request.getOwnerId()).orElseThrow();

        var recipeEntity = new RecipeEntity(request.getRecipeTitle(), request.getSubtitle(), complexity, owner);
        recipeEntity = recipeRepository.save(recipeEntity);

        return transformEntity(recipeEntity);
    }

    public Recipe update(Long id, RecipeManipulationRequest request) {
        var recipeEntityOptional = recipeRepository.findById(id);
        if (recipeEntityOptional.isEmpty()) {
            return null;
        }
        var recipeEntity = recipeEntityOptional.get();
        recipeEntity.setRecipeTitle(request.getRecipeTitle());
        recipeEntity.setSubtitle(request.getSubtitle());
        recipeEntity.setComplexity(Complexity.valueOf(request.getComplexity()));
        recipeEntity = recipeRepository.save(recipeEntity);

        return transformEntity(recipeEntity);
    }

    public boolean deleteById(Long id) {
        if (!recipeRepository.existsById(id)) {
            return false;
        }
        recipeRepository.deleteById(id);
        return true;
    }

    private Recipe transformEntity(RecipeEntity recipeEntity) {
        var complexity = recipeEntity.getComplexity() != null ? recipeEntity.getComplexity().name() : Complexity.UNKNOWN.name();
        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getRecipeTitle(),
                recipeEntity.getSubtitle(),
                complexity,
                recipeEntity.getOwner().getId()
        );
    }
}
