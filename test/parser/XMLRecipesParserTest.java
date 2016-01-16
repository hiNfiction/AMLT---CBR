package parser;
import static org.junit.Assert.*;

import org.junit.Test;

import designCBR.RecipesMemory;

public class XMLRecipesParserTest {

	@Test
	public void parseXMLRecipesTest() throws Exception {
		RecipesMemory caseMemory = XMLRecipesParser.parseXMLRecipes();
		System.out.println(caseMemory.toString());
		assertNotNull(caseMemory);
	}

}
