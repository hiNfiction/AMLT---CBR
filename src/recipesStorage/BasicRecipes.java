package recipesStorage;

import com.sun.xml.internal.bind.v2.TODO;

import coffeeStructure.AddComponentStep;
import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Ingredient;
import coffeeStructure.Step;
import coffeeStructure.Ingredient.Unit;

/**
 * Add basic coffee recipes, based on which others will be created through CBR
 * Recipes source: http://www.espressocoffeeguide.com/
 * @author Stefania
 *
 */
public class BasicRecipes {

	
	public CoffeeRecipe makeEspressoShot() {
		
		CoffeeRecipe espressoShot = new CoffeeRecipe("Espresso Shot");
		
		// Add ingredients
		Ingredient water = new Ingredient("Water", 100, Unit.MILLILITERS);
		espressoShot.addComponent(water);
		Ingredient groundCoffee= new Ingredient("Ground coffee", 20, Unit.GRAMS);
		espressoShot.addComponent(groundCoffee);
		
		// Add recipe (steps)
		// TODO maybe read the steps from file
		Step stepZero = new Step(
				"Use an espresso machine; all ingredients are to be added there");
		Step stepOne = stepZero.addNextStep(new AddComponentStep(water));
		Step stepTwo = stepOne.addNextStep(new Step("Pre-warm the demitasse"));
		Step stepThree = stepTwo.addNextStep(new Step("Grind the coffee"));
		Step stepFour = stepThree.addNextStep(new Step("Position the demitasse"));
		
		Step stepFive = stepFour.addNextStep(new AddComponentStep(groundCoffee));
		
		Step stepSix = stepFive.addNextStep(new Step("Tamp the ground coffee"));
		stepSix.addNextStep(new Step(
				"Brew the espresso for an optimal time(usually around 22 seconds)"));
		//espressoShot.setRecipe(stepZero);
		
		return espressoShot;
	}
	
	public CoffeeRecipe makeCappuccino() {
		
		CoffeeRecipe cappuccino = new CoffeeRecipe("Cappuccino");
		
		Ingredient milk = new Ingredient("Steamed milk", 50, Unit.MILLILITERS);
		cappuccino.addComponent(milk);
		CoffeeRecipe es = makeEspressoShot();
		es.setQuantity(2);
		cappuccino.addComponent(es);
		Ingredient foam = new Ingredient("Foam", 50, Unit.MILLILITERS);
		
		Step stepOne = new AddComponentStep(milk);
		Step stepTwo = stepOne.addNextStep(new AddComponentStep(es));
		stepTwo.addNextStep(new AddComponentStep(foam));
		
		//cappuccino.setRecipe(stepOne);
		return cappuccino;
	}
	
}
