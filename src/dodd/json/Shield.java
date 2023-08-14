package dodd.json;

import java.util.Locale;

public class Shield extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "fission_shield_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"model\": \"nuclearcraft:cube_all_overlayed\",\n"
				+ "		\"textures\": {\n"
				+ "			\"all\": \"nuclearcraft:blocks/shield_%s\",\n"
				+ "			\"overlay\": \"nuclearcraft:blocks/fission/shield/on\"\n"
				+ "		}\n"
				+ "	},\n"
				+ "	\"variants\": {\n"
				+ "		\"inventory\": [{}],\n"
				+ "		\"active\": {\n"
				+ "			\"false\": {\n"
				+ "				\"textures\": {\n"
				+ "					\"overlay\": \"nuclearcraft:blocks/fission/shield/off\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"true\": {}\n"
				+ "		}\n"
				+ "	}\n"
				+ "}\n"
				+ "",
				blockName);
	}
}
