package coffeeStructure;

import java.util.ArrayList;

public class CoffeeRecipe extends Component {

	private ArrayList<Component> components;
	private Step recipe;
	
	public CoffeeRecipe(String name) {
		
		this.setName(name);
		this.setComponents(new ArrayList<>());
	}

	public boolean addComponent(Component ingredient) {
		return components.add(ingredient);
	}
	
	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public Step getRecipe() {
		return recipe;
	}

	public void setRecipe(Step recipe) {
		this.recipe = recipe;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
