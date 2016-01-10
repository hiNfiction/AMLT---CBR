package coffeeStructure;

public class AddComponentStep extends Step {

	private Component component;
	
	public AddComponentStep(Component component) {
		this.setComponent(component);
		if (component instanceof Ingredient) {
			Ingredient ingr = (Ingredient) component;
			this.description = "Add " + ingr.getQuantity() + " "
					+ ingr.getUnit() + " of " + ingr.getName();
		} else {
			CoffeeRecipe coffee = (CoffeeRecipe) component;
			this.description = "Add " + coffee.getName() + " of "
					+ coffee.getName();
		}
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	

}
