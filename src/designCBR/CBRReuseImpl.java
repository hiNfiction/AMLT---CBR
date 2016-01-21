package designCBR;

import utils.Constants;
import coffeeStructure.AddComponentStep;
import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;
import coffeeStructure.Ingredient;
import coffeeStructure.Ingredient.Unit;

/**
 * Reuse component of the CBR implementation
 * 
 * @author Stefania
 *
 */
public class CBRReuseImpl extends CBRComponent implements CBRReuse {

	public CBRReuseImpl(RecipesMemory caseMemory) {
		super(caseMemory);
	}

	public Component reuse(Component simComponent, Component newComponent) {

		// Assume both components are coffee recipes
		CoffeeRecipe simCoffeeRecipe = (CoffeeRecipe) simComponent;
		CoffeeRecipe newCoffeeRecipe = (CoffeeRecipe) newComponent;

		// Add all ingredients and all Steps to the new component
		newCoffeeRecipe.setClonedComponents(simCoffeeRecipe.getComponents());
		newCoffeeRecipe.setClonedSteps(simCoffeeRecipe.getSteps());

		String simComponentName = simCoffeeRecipe.getName().toLowerCase();
		String newComponentName = newCoffeeRecipe.getName().toLowerCase();
		// Remove, if found, the name of the similar component
		// from the name of the new component
		int foundIndex = newComponentName.indexOf(simComponentName);
		if (foundIndex > -1) {
			newComponentName = newComponentName.substring(0, foundIndex)
					+ newComponentName.substring(foundIndex
							+ simComponentName.length());
		}

		// search for keywords within the title and modify the recipe
		// accordingly
		searchComponentDoubled(newCoffeeRecipe, simComponentName,
				newComponentName);
		searchSweetCoffee(newCoffeeRecipe, simComponentName, newComponentName);
		searchDryCoffee(newCoffeeRecipe, simComponentName, newComponentName);
		searchWetCoffee(newCoffeeRecipe, simComponentName, newComponentName);

		return newComponent;
	}

	boolean searchComponentDoubled(CoffeeRecipe newRecipe,
			String simComponentName, String newComponentName) {

		// Search whether an ingredient is doubled
		if (!componentNameContains(newComponentName, Constants.DOUBLE))
			return false;
		String searchStr = Constants.DOUBLE + " ";

		// Find the ingredient which is doubled
		Component compFound = null;
		for (Component comp : newRecipe.getComponents()) {

			String compName = comp.getName().toLowerCase();
			if (componentNameContains(newComponentName, searchStr + compName)) {
				if (componentNameContains(simComponentName, searchStr
						+ compName))
					continue;
				compFound = comp;
				break;
			}
		}

		if (compFound != null) {
			compFound.setQuantity(2 * compFound.getQuantity());
			return true;
		}
		// Search for short name of ingredients
		int indexAfter = newComponentName.indexOf(searchStr)
				+ searchStr.length();
		String compName = newComponentName.substring(indexAfter).split(" ")[0];
		if (componentNameContains(simComponentName, searchStr + compName))
			return false;

		compFound = newRecipe.getComponentByName(compName);
		if (compFound != null) {
			compFound.setQuantity(2 * compFound.getQuantity());
			return true;
		}
		return false;
	}

	void searchSweetCoffee(CoffeeRecipe newRecipe, String simComponentName,
			String newComponentName) {

		// Search whether we should add sugar
		if (componentNameContains(newComponentName, Constants.SWEET)) {
			if (componentNameContains(simComponentName, Constants.SWEET))
				return;

			Ingredient sugar = (Ingredient) newRecipe
					.getComponentByName("sugar");
			if (sugar != null) {
				sugar.setQuantity(sugar.getQuantity() * 2);
				return;
			}

			// Add sugar
			Ingredient ingredient = new Ingredient("Sugar",
					Constants.IDEAL_SUGAR_QUANT, Unit.OUNCES);
			newRecipe.addComponent(ingredient);
			newRecipe.getSteps().add(new AddComponentStep(ingredient));
		}
	}

	void searchDryCoffee(CoffeeRecipe newRecipe, String simComponentName,
			String newComponentName) {

		// Search whether we should add sugar
		if (componentNameContains(newComponentName, Constants.DRY)) {
			if (componentNameContains(simComponentName, Constants.DRY))
				return;

			Ingredient foam = (Ingredient) newRecipe.getComponentByName("foam");
			if (foam != null) {
				foam.setQuantity(foam.getQuantity() * 2);
				return;
			}

			// Add sugar
			Ingredient ingredient = new Ingredient("Foam",
					Constants.IDEAL_FOAM_QUANT, Unit.MILLILITERS);
			newRecipe.addComponent(ingredient);
			newRecipe.getSteps().add(new AddComponentStep(ingredient));
		}
	}

	void searchWetCoffee(CoffeeRecipe newRecipe, String simComponentName,
			String newComponentName) {

		// Search whether we should add sugar
		if (componentNameContains(newComponentName, Constants.WET)) {
			if (componentNameContains(simComponentName, Constants.WET))
				return;

			Ingredient milk = (Ingredient) newRecipe.getComponentByName("milk");
			if (milk != null) {
				milk.setQuantity(milk.getQuantity() * 2);
				return;
			}

			// Add sugar
			Ingredient ingredient = new Ingredient("Milk",
					Constants.IDEAL_MILK_QUANT, Unit.MILLILITERS);
			newRecipe.addComponent(ingredient);
			newRecipe.getSteps().add(new AddComponentStep(ingredient));
		}
	}

	boolean componentNameContains(String name, String searchStr) {
		return name.contains(searchStr);
	}

}
