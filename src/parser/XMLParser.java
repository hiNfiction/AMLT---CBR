package parser;

import designCBR.CaseMemory;
/**
 * Interface that should be implemented by all different XML parsers. In our case, the XMLRecipesParser, which parses recipes from an XML file.
 * @author dgl3
 *
 */
public interface XMLParser {

	/**
	 * The method should parse an XML file containing the memory of the CBR
	 * @return CaseMemory CM of the CBR
	 * @throws Exception
	 */
	public CaseMemory parseXML() throws Exception;
}
