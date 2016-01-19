package coffeeStructure;

import java.util.ArrayList;
/**
 * Implementation of a coffee recipe
 * 	- consisting of the necessary components 
 * 		and the order of the recipe's steps to complete it
 * @author Stefania
 *
 */
public class CoffeeRecipe extends Component {

	private ArrayList<Component> components;
	private ArrayList<Step> steps;
	
	public CoffeeRecipe(){
		this.setComponents(new ArrayList<Component>());
		this.setSteps(new ArrayList<Step>());
	}
	
	public CoffeeRecipe(String name) {
		this();
		this.setName(name);
	}

	public boolean addComponent(Component ingredient) {
		return components.add(ingredient);
	}
	
	public Component getComponentByName(String name) {
		
		String searchName = name.toLowerCase();
		for(Component comp : components) {
			if(comp.name.toLowerCase().contains(searchName))
				return comp;
		}
		
		return null;
	}

	
	public void setClonedComponents(ArrayList<Component> components) {
		
		this.components = new ArrayList<>();
		for(Component comp : components) {
			if(comp instanceof Ingredient) {
				Ingredient ingr = (Ingredient) comp;
				Ingredient newIngr = new Ingredient(ingr.getName(),
						ingr.getQuantity(), ingr.getUnit());
				this.components.add(newIngr);
			} else {
				this.components.add(comp);
			}
		}
	}
	
	public void setClonedSteps(ArrayList<Step> steps) {
		
		this.steps = new ArrayList<>();
		
		for(Step step : steps) {
			if(step instanceof AddComponentStep) {
				AddComponentStep acStep = (AddComponentStep) step;

				// Find component
				Component foundComp = getComponentByName(acStep.getComponent().getName());
				if(foundComp != null) {
					steps.add(new AddComponentStep(foundComp));
				}
				else
					System.err.println("Component of add step not found");
			} else {
				this.steps.add(new Step(step.getDescription()));
			}
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		CoffeeRecipe cf = new CoffeeRecipe();
		cf.setClonedComponents(components);
		cf.setClonedSteps(steps);
		return cf;
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
		return quantity + " of " + name;
	}
	
	public String getEntireCoffeeRecipe() {
		String outStr = name + "\n";
		outStr += "Components: " + components + "\n";
		outStr += "Steps:\n";
		for(Step step : steps) {
			outStr += "\t" + step + "\n";
		}
		
		return outStr;
		
	}
}
