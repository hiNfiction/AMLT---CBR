package coffeeStructure;

/**
 * This class is modeling a recipe's step, which can be:
 * 	- specific: e.g. adding a certain component
 * 	- general: using the description field to specify it
 * @author Stefania
 *
 */
public class Step {
	
	Step nextStep;
	String description;
	
	public Step(){}
	
	public Step(String description) {
		this.description = description;
	}
	
	public Step addNextStep(Step step) {
		this.nextStep = step;		
		return this.nextStep;
	}
	
	public Step getNextStep() {
		return nextStep;
	}

	public void setNextStep(Step nextStep) {
		this.nextStep = nextStep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
