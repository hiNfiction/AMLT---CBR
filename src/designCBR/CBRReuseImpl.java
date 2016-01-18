package designCBR;

import coffeeStructure.Component;
/**
 * Reuse component of the CBR implementation
 * @author dgl3
 *
 */
public class CBRReuseImpl extends CBRComponent implements CBRReuse{

	public CBRReuseImpl(RecipesMemory caseMemory) {
		super(caseMemory);
	}
	
	public Component reuse(Component simComponent, Component newComponent){
		return null;
	}

}
