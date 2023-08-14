package dodd.json;

import java.util.Locale;

public class Blade extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "turbine_rotor_blade_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"model\": \"nuclearcraft:turbine_rotor_blade\",\n"
				+ "		\"textures\": {\n"
				+ "			\"texture\": \"nuclearcraft:blocks/blade_%s\"\n"
				+ "		}\n"
				+ "	},\n"
				+ "	\"variants\": {\n"
				+ "		\"inventory\": [{}],\n"
				+ "		\"dir\": {\n"
				+ "			\"invisible\": {\n"
				+ "				\"model\": \"nuclearcraft:block_invisible\"\n"
				+ "			},\n"
				+ "			\"x\": {\"x\": 90, \"y\": 90},\n"
				+ "			\"y\": {},\n"
				+ "			\"z\": {\"x\": 90}\n"
				+ "		}\n"
				+ "	}\n"
				+ "}\n"
				+ "",
				blockName);
	}
}
