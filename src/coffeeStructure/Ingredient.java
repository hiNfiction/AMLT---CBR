package coffeeStructure;

public class Ingredient extends Component {
	
	public enum Unit {
		MILLILITERS,
		GRAMS,
		BOUNCES
	}

	private Unit unit;
	
	public Ingredient(){}
	public Ingredient(String name, float quantity, Unit unit) {
		
		this.setName(name);
		this.quantity = quantity;
		this.setUnit(unit);
		
	}
	


	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	

}
