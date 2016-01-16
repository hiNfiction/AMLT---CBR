package designCBR;

import coffeeStructure.Component;

public class CBR {
	private RecipesMemory caseMemory;
	
	private CBRRetrieve cbrRetrieveComponent;
	private CBRReuse cbrReuseComponent;
	private CBRRevise cbrReviseComponent;
	private CBRRetain cbrRetainComponent;
	
	public CBR(RecipesMemory caseMemory){
		this.caseMemory = caseMemory;
		cbrRetrieveComponent = new CBRRetrieve(this.caseMemory);
		cbrReuseComponent = new CBRReuse(this.caseMemory);
		cbrReviseComponent = new CBRRevise(this.caseMemory);
		cbrRetainComponent = new CBRRetain(this.caseMemory);
	}
	
	public void applyCBR(Component newRecipe){
		Component similarComponent = cbrRetrieveComponent.retrieveSimilarComponent(newRecipe);
		newRecipe = cbrReuseComponent.reuse(similarComponent,newRecipe);
		//CBRRevise???
		cbrRetainComponent.retain(newRecipe);
	}
	
	

}
