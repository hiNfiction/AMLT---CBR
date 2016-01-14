package designCBR;

public abstract class CBRComponent {
	private RecipesMemory caseMemory;
	
	public CBRComponent(RecipesMemory caseMemory){
		this.caseMemory = caseMemory;
	}

	public RecipesMemory getCaseMemory() {
		return caseMemory;
	}

	public void setCaseMemory(RecipesMemory caseMemory) {
		this.caseMemory = caseMemory;
	}

	@Override
	public String toString() {
		return "CBRComponent [caseMemory=" + caseMemory + "]";
	}
	
	

}
