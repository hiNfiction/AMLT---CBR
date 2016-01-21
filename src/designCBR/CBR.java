package designCBR;

import utils.StringOps;
import coffeeStructure.CoffeeRecipe;
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

	public boolean applyCBR(Component newRecipe){
		
		newRecipe.setName(StringOps.capitalizeString(newRecipe.getName()));
		Component similarComponent = (Component) cbrRetrieveComponent.retrieveSimilarComponent(newRecipe);
		newRecipe = cbrReuseComponent.reuse(similarComponent,newRecipe);
		System.out.println(((CoffeeRecipe)similarComponent).getEntireCoffeeRecipe());
		System.out.println(((CoffeeRecipe)newRecipe).getEntireCoffeeRecipe());

		if(!cbrReviseComponent.revise(newRecipe))
			return false;
		cbrRetainComponent.retain(newRecipe);
		return true;
	}
	
	

}
