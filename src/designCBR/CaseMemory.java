package designCBR;
import java.util.HashMap;
import java.util.Map;

import coffeeStructure.Component;

/**
 * Abstract class with the implementation of an initial case memory.
 * 
 * @author dgl3
 *
 */
public abstract class CaseMemory {
	protected Map memory;

	public CaseMemory(){
		memory = new HashMap<String,Component>();
	}
	
	public abstract void addComponent(Component component);
	public abstract Map getComponents();
	public abstract void setComponent(Map components);
	
	@Override
	public String toString() {
		return memory.toString();
	}

}
