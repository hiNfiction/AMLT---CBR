package designCBR;

import java.util.HashMap;
import java.util.Map;

import coffeeStructure.CoffeeRecipe;

public class RecipesMemory {

	protected Map<String,CoffeeRecipe> recipes;
	
	public RecipesMemory() {
		recipes = new HashMap<String,CoffeeRecipe>();
	}
	
	public void addRecipe(CoffeeRecipe recipe) {
		recipes.put(recipe.getName(), recipe);
	}

	public Map<String, CoffeeRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Map<String,CoffeeRecipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return recipes.toString();
	}
}
