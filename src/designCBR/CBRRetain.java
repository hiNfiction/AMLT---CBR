package designCBR;

import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;

public class CBRRetain extends CBRComponent{

	public CBRRetain(RecipesMemory caseMemory) {
		super(caseMemory);
	}
	
	public void retain(Component comp){
		if(comp instanceof CoffeeRecipe) 
			caseMemory.getComponents().put(comp.getName(), (CoffeeRecipe)comp);
	}

}
