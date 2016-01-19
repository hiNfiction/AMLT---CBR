package coffeeStructure;

/**
 * This class is modeling a real-life ingredient, which has:
 * 	- name
 * 	- quantity
 * 	- measurement unit
 * @author Stefania
 *
 */
public class Ingredient extends Component {
	
	public enum Unit {
		MILLILITERS,
		GRAMS,
		OUNCES
	}

	private Unit unit;
	
	public Ingredient(){}
	public Ingredient(String name, float quantity, Unit unit) {
		
		this.setName(name);
		this.quantity = quantity;
		this.setUnit(unit);
		
	}

	public static Unit getUnitForString(String unitStr) {
		
		for(Unit aUnit : Unit.values()) {
			if(aUnit.toString().equals(unitStr))
				return aUnit;
		}
		return null;
	}
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return quantity + " " + unit + " of " + name;
	}
}
