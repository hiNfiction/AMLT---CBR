package coffeeStructure;

import java.util.ArrayList;

public class CoffeeRecipe extends Component {

	private ArrayList<Component> components;
	private ArrayList<Step> steps;
	
	public CoffeeRecipe(){
		this.setComponents(new ArrayList<Component>());
		this.setSteps(new ArrayList<Step>());
	}
	
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

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
