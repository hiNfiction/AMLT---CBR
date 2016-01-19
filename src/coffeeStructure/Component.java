package coffeeStructure;

/**
 * It is used for a coffee recipe
 * Can be either an ingredient or a coffee recipe
 * @author Stefania
 *
 */
public abstract class Component {

	String name;
	float quantity;

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
