package designCBR;

import coffeeStructure.Component;

public class CBRReuse extends CBRComponent{

	public CBRReuse(RecipesMemory caseMemory) {
		super(caseMemory);
	}
	
	public Component reuse(Component simComponent, Component newComponent){
		return null;
	}

}
