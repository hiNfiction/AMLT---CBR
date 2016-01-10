package designCBR;

import java.util.ArrayList;

import coffeeStructure.CoffeeRecipe;

public class RecipesMemory {

	private ArrayList<CoffeeRecipe> recipes;
	
	public RecipesMemory() {
		
		setRecipes(new ArrayList<>());
	}
	
	public boolean addRecipe(CoffeeRecipe recipe) {
		return recipes.add(recipe);
	}

	public ArrayList<CoffeeRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<CoffeeRecipe> recipes) {
		this.recipes = recipes;
	}
	
	@Override
	public String toString() {
		return recipes.toString();
	}
}
