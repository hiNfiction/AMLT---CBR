package designCBR;

import java.util.HashMap;
import java.util.Map;

import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Component;
import utils.Distances;
/**
 * Retrieve component of the CBR implementation.
 * @author dgl3
 *
 */
public class CBRRetrieveImpl extends CBRComponent implements CBRRetrieve{

	private Map<String,Integer> distances;
	private String similarRecipe;
	private int distSimRecipe = Integer.MAX_VALUE;
	
	public CBRRetrieveImpl(RecipesMemory caseMemory) {
		super(caseMemory);
		distances = new HashMap<String,Integer>();
				
	}
	@Override
	public Object retrieveSimilarComponent(Component component){
		for(Object obj: caseMemory.getComponents().values()){
			if(obj instanceof CoffeeRecipe){
				CoffeeRecipe recipe = (CoffeeRecipe) obj;
				int distance = Distances.LevenshteinDistance(recipe.getName(), component.getName());
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
