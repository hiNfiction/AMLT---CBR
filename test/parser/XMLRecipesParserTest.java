package parser;
import static org.junit.Assert.*;

import org.junit.Test;

import designCBR.RecipesMemory;

public class XMLRecipesParserTest {


	@Test
	public void parseXMLRecipesTest() throws Exception {
		XMLRecipesParser parser = new XMLRecipesParser();
		RecipesMemory caseMemory = (RecipesMemory) parser.parseXML();
		System.out.println(caseMemory.toString());
		assertNotNull(caseMemory);
	}
	

}
