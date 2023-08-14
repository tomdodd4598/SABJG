package dodd.json;

import dodd.Helpers;

public abstract class Block {
	
	public void writeToFile(String blockName) {
		Helpers.writeFile(getFileName(blockName), getJsonContents(blockName));
	}
	
	public abstract String getFileName(String blockName);
	
	public abstract String getJsonContents(String blockName);
}
