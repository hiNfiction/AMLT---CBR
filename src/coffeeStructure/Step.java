package coffeeStructure;

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
	
	@Override
	public String toString() {
		return description;
	}
}
