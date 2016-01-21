package designCBR;

import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;

/**
 * Retain component of the CBR implementation.
 * 
 * @author Stefania
 *
 */
public class CBRRetainImpl extends CBRComponent implements CBRRetain {

	public CBRRetainImpl(RecipesMemory caseMemory) {
		super(caseMemory);
	}

	@Override
	public void retain(Component comp) {
		if (comp instanceof CoffeeRecipe)
			caseMemory.getComponents().put(comp.getName(), (CoffeeRecipe) comp);
	}

}
