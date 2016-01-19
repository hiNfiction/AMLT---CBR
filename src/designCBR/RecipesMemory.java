package designCBR;

import java.util.HashMap;
import java.util.Map;

import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;
/**
 * Extends the CaseMemory abstract class. Implementation of the CaseMemory containing CoffeeRecipes
 * @author dgl3
 *
 */
public class RecipesMemory extends CaseMemory{

	protected Map<String,CoffeeRecipe> memory;
	
	public RecipesMemory() {
		memory = new HashMap<String,CoffeeRecipe>();
	}

	@Override
	public void addComponent(Component component) {
		if(component instanceof CoffeeRecipe) {
			memory.put(component.getName(), (CoffeeRecipe) component);}
		
	}

	@Override
	public Map getComponents() {
		return memory;
	}

	@Override
	public void setComponent(Map memory) {
			this.memory = memory;
	}
}
