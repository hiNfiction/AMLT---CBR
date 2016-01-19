package parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import coffeeStructure.CoffeeRecipe;
import coffeeStructure.Ingredient;
import coffeeStructure.Ingredient.Unit;
import coffeeStructure.Step;
import designCBR.CaseMemory;
import designCBR.RecipesMemory;
/**
 * Implementation of the XMLParser interface.
 * @author dgl3
 *
 */
public class XMLRecipesParser implements XMLParser{
	
	/**
	 * Parses the xml file containing all the recipes and returns the case memory of the cbr
	 * @return RecipeMemory It is the case memory of the CBR
	 * @throws Exception
	 */
	public CaseMemory parseXML() throws Exception{
		//DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//DOM Builder
		try{
			DocumentBuilder builder =factory.newDocumentBuilder();
			
			//Load and parse the XML file. document contains the complete XML as a Tree
			Document document = builder.parse(new File("resources/recipes.xml"));
			
			//Extracts the root element <RECIPES>
			Element root = document.getDocumentElement();
			RecipesMemory caseMemory = new RecipesMemory();

			/**------------------------------------------------------------------------
			 * ------------------------------------------------------------------------
			 * Read CoffeRecipes
			 * ------------------------------------------------------------------------
			 * ------------------------------------------------------------------------
			 */
			NodeList coffeeRecipesNodeList = root.getChildNodes();
			for(int i = 0; i < coffeeRecipesNodeList.getLength(); i++){
				//<CoffeeRecipe> tag found
				Node coffeeRecipeNode = coffeeRecipesNodeList.item(i);
				System.out.println("\nCurrent Element :" 
			               + coffeeRecipeNode.getNodeName());
				if (coffeeRecipeNode.getNodeType() == Node.ELEMENT_NODE){
					CoffeeRecipe recipe = new CoffeeRecipe();
					
					//Get the element CoffeeRecipe
					Element coffeeRecipeElement = (Element) coffeeRecipeNode;
					
					//Set CoffeeRecipe's name
					System.out.println("Type : " + coffeeRecipeElement.getElementsByTagName("TYPE").item(0).getTextContent());
					recipe.setName(coffeeRecipeElement.getElementsByTagName("TYPE").item(0).getTextContent());
					
					
					/**------------------------------------------------------------------------
					 * ------------------------------------------------------------------------
					 * Set CoffeeRecipe's Ingredients
					 * ------------------------------------------------------------------------
					 * ------------------------------------------------------------------------
					 */
					NodeList ingredientsNodeList = coffeeRecipeElement.getElementsByTagName("INGREDIENT");
					for(int j = 0; j < ingredientsNodeList.getLength(); j++){
						Node ingredientNode = ingredientsNodeList.item(j);
						System.out.println("\nCurrent Element :" 
					               + ingredientNode.getNodeName());
						
						if (ingredientNode.getNodeType() == Node.ELEMENT_NODE){
							Ingredient ingredient = new Ingredient();

							//Get the element Ingredient
							Element ingredientElement = (Element) ingredientNode;
							
							//Set ingredient's name
							System.out.println("Name : " + ingredientElement.getElementsByTagName("NAME").item(0).getTextContent());
							ingredient.setName(ingredientElement.getElementsByTagName("NAME").item(0).getTextContent());
							
							//Set ingredient's quantity
							System.out.println("Quantity : " + ingredientElement.getElementsByTagName("QUANTITY").item(0).getTextContent());
							ingredient.setQuantity(Float.parseFloat(ingredientElement.getElementsByTagName("QUANTITY").item(0).getTextContent()));		
							
							//Set ingredient's unit
							System.out.println("Unit : " + ingredientElement.getElementsByTagName("UNIT").item(0).getTextContent());
							switch(ingredientElement.getElementsByTagName("UNIT").item(0).getTextContent()){
								case "MILLIMETERS":
									ingredient.setUnit(Unit.MILLILITERS);
								case "GRAMS":
									ingredient.setUnit(Unit.GRAMS);
								case "BOUNCES":
									ingredient.setUnit(Unit.BOUNCES);
							}
							
							//Add ingredient to the current recipe
							recipe.addComponent(ingredient);	
						}
						
					}
					
					/**------------------------------------------------------------------------
					 * ------------------------------------------------------------------------
					 * Set CoffeeRecipe's Steps
					 * ------------------------------------------------------------------------
					 * ------------------------------------------------------------------------
					 */
					NodeList stepsNodeList = coffeeRecipeElement.getElementsByTagName("STEP");
					for(int j = 0; j < stepsNodeList.getLength(); j++){
						Node stepNode = stepsNodeList.item(j);
						System.out.println("\nCurrent Element :" 
					               + stepNode.getNodeName());	
						if (stepNode.getNodeType() == Node.ELEMENT_NODE){
							Step step = new Step();
							
							//Get the element Step
							Element stepElement = (Element) stepNode;
							
							//Set step's description
							System.out.println("Description : " + stepElement.getTextContent());
							step.setDescription(stepElement.getNodeValue());
							recipe.getSteps().add(step);	
						}
					}
					caseMemory.addComponent(recipe);
				}
			}
			return caseMemory;
		}catch(IOException | ParserConfigurationException | SAXException io){
			throw io;
		}		
	}

}
