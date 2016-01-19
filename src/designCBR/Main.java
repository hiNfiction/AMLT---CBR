package designCBR;

import parser.XMLRecipesParser;
import recipesStorage.BasicRecipes;
import utils.Distances;
import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Ingredient;
import coffeeStructure.Ingredient.Unit;

public class Main {

	public static void main(String[] args) {		
		
		// Create Case-Base Memory
		XMLRecipesParser parser = new XMLRecipesParser();
		RecipesMemory caseMemory = null;
		try {
			caseMemory = (RecipesMemory) parser.parseXML();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(caseMemory == null)
			System.out.println("no recipes");
		CBR cbr = new CBR(caseMemory);
		
		// Use CBR on an example
		System.out.println("=========================================================");
		System.out.println("Recipies in database:\n\t" + caseMemory.getComponents().keySet());
		System.out.println(((CoffeeRecipe)caseMemory.getComponents().get("Cappuccino")).getEntireCoffeeRecipe());
		CoffeeRecipe newRecipe = new CoffeeRecipe("Wet Espresso Shot");
		System.out.println(newRecipe.getEntireCoffeeRecipe());
		
		System.out.println("... After system processing ...\n");
		cbr.applyCBR(newRecipe);
		System.out.println("=========================================================");
		
	}
}
