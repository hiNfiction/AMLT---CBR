package designCBR;

import coffeeStructure.Component;

public class CBR {
	private RecipesMemory caseMemory;
	
	private CBRRetrieveImpl cbrRetrieveComponent;
	private CBRReuseImpl cbrReuseComponent;
	private CBRReviseImpl cbrReviseComponent;
	private CBRRetainImpl cbrRetainComponent;
	
	public CBR(RecipesMemory caseMemory){
		this.caseMemory = caseMemory;
		cbrRetrieveComponent = new CBRRetrieveImpl(this.caseMemory);
		cbrReuseComponent = new CBRReuseImpl(this.caseMemory);
		cbrReviseComponent = new CBRReviseImpl(this.caseMemory);
		cbrRetainComponent = new CBRRetainImpl(this.caseMemory);
	}
	
	public void applyCBR(Component newRecipe){
		Component similarComponent = (Component) cbrRetrieveComponent.retrieveSimilarComponent(newRecipe);
		newRecipe = cbrReuseComponent.reuse(similarComponent,newRecipe);
		//CBRRevise???
		cbrRetainComponent.retain(newRecipe);
	}
	
	

}
