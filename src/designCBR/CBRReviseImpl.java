package designCBR;

import coffeeStructure.AddComponentStep;
import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;
import coffeeStructure.Step;

/**
 * Revise component of the CBR implementation.
 * @author dgl3
 *
 */
public class CBRReviseImpl extends CBRComponent implements CBRRevise{

	public CBRReviseImpl(RecipesMemory caseMemory) {
		super(caseMemory);
	}

	@Override
	public boolean revise(Component component) {

		// Assume we are dealing with a coffee recipe
		CoffeeRecipe recipe = (CoffeeRecipe) component;
		
		// Check if every component is used
		if(!checkComponentsUsed(recipe))
			return false;
		
		// Check if here are any steps using components that are not written
		//	in the components list 
		return checkStepsHaveIngredients(recipe);
	}
	
	boolean checkComponentsUsed(CoffeeRecipe recipe) {
		
		for(Component comp : recipe.getComponents()) {
			boolean found = false;
			for(Step step : recipe.getSteps()) {
				if(step instanceof AddComponentStep) {
					if (comp.getName().equals(
							((AddComponentStep) step).getComponent().getName())) {
						found = true;
					}
				}
			}
			if(!found) 
				return false;
		}
		return true;
	}

	boolean checkStepsHaveIngredients(CoffeeRecipe recipe) {
	
		for(Step step : recipe.getSteps()) {
			if(step instanceof AddComponentStep) {
				Component comp = ((AddComponentStep)step).getComponent(); 
				if(recipe.getComponentByName(comp.getName()) == null)
					// Add component to the recipe
					return recipe.addComponent(comp);
			}
		}
		return true;
	}
			
}
