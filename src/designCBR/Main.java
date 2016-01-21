package designCBR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parser.XMLRecipesParser;
import coffeeStructure.CoffeeRecipe;

public class Main {
	
	public static RecipesMemory createCBMemory() {
		
		XMLRecipesParser parser = new XMLRecipesParser();
		RecipesMemory caseMemory = null;
		try {
			caseMemory = (RecipesMemory) parser.parseXML();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(caseMemory == null)
			System.out.println("no recipes");
		return caseMemory;
	}
	public static void testCBR(CBR cbr, RecipesMemory caseMemory, String recipeName) {
		// Use CBR on an example
		System.out.println("=========================================================");
		System.out.println("Recipies in database:\n\t" + caseMemory.getComponents().keySet());
		CoffeeRecipe newRecipe = new CoffeeRecipe(recipeName);
		
		System.out.println("... After system reasoning ...\n");
		boolean succeeded = cbr.applyCBR(newRecipe);
		if(!succeeded) {
			System.out.println("Unfortunately, we cannot fulfill your request."
					+ " We are sorry for the inconvenience");
		}
		System.out.println("=========================================================");
		System.out.println("Recipies in after-database:\n\t" + caseMemory.getComponents().keySet());
	}

	public static void main(String[] args) {		
		
		// Create Case-Base Memory
		RecipesMemory caseMemory = createCBMemory();
		
		CBR cbr = null;
		cbr = new CBR(caseMemory);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	boolean contFlag = true;
    		while(contFlag) {
    	        System.out.print("Enter the desired recipe name:\n");    			
				String recipeName = br.readLine();
		        testCBR(cbr, caseMemory, recipeName);
    	        System.out.print("Would you wish to continue? y/n\n"); 		
				String response = br.readLine();
    	        if(response.equals("n"))
    	        	contFlag = false;
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
