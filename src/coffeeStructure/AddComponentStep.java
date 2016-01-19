package coffeeStructure;

/**
 * Add component to the steps of the recipe
 * - either ingredient or another type of coffee
 * @author Stefania
 *
 */
public class AddComponentStep extends Step {

	private Component component;
	
	public AddComponentStep(Component component) {
		this.setComponent(component);
		this.setDescription("Add " + component.getName());
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	

}
