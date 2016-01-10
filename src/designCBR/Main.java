package designCBR;

import coffeeStructure.CoffeeRecipe;
import recipesStorage.BasicRecipes;

public class Main {

	public static void main(String[] args) {

		BasicRecipes basicR = new BasicRecipes();
		RecipesMemory recipesMem = new RecipesMemory();
		CoffeeRecipe espressoShot = basicR.makeEspressoShot();
		CoffeeRecipe cappuccino = basicR.makeCappuccino();
		recipesMem.addRecipe(espressoShot);
		recipesMem.addRecipe(cappuccino);
		
		System.out.println("Print recipes database");
		System.out.println(recipesMem);
		System.out.println("\n__Print Espresso Shot ingredients__");
		System.out.println(espressoShot.getComponents());
		System.out.println("__Print Espresso Shot first step of recipe__");
		System.out.println(espressoShot.getRecipe());

		System.out.println("\n__Print Cappuccino ingredients__");
		System.out.println(cappuccino.getComponents());
		System.out.println("__Print Cappuccino first step of recipe__");
		System.out.println(cappuccino.getRecipe());
	}

}
