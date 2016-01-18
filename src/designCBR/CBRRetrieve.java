package designCBR;

import java.util.HashMap;
import java.util.Map;

import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;
import utils.Distances;

public class CBRRetrieve extends CBRComponent{

	private Map<String,Integer> distances;
	private String similarRecipe;
	private int distSimRecipe = Integer.MAX_VALUE;
	
	public CBRRetrieve(RecipesMemory caseMemory) {
		super(caseMemory);
		distances = new HashMap<String,Integer>();
				
	}
	
	public Object retrieveSimilarComponent(Component newRecipe){
		for(Object obj: caseMemory.getComponents().values()){
			if(obj instanceof CoffeeRecipe){
				CoffeeRecipe recipe = (CoffeeRecipe) obj;
				int distance = Distances.LevenshteinDistance(recipe.getName(), newRecipe.getName());
				distances.put(recipe.getName(), distance);
				if(distance < distSimRecipe){
					distSimRecipe = distance;
					similarRecipe = recipe.getName();
				}
			}
		}
		return caseMemory.getComponents().get(similarRecipe);
	}

	
	
}
