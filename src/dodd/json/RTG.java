package dodd.json;

import java.util.Locale;

public class RTG extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "rtg_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"model\":\"cube_column\",\n"
				+ "		\"textures\": {\n"
				+ "			\"end\": \"nuclearcraft:blocks/rtg_%s_top\",\n"
				+ "			\"side\": \"nuclearcraft:blocks/rtg_%s_side\"\n"
				+ "		}\n"
				+ "	},\n"
				+ "	\"variants\": {\n"
				+ "		\"inventory\": [{}],\n"
				+ "		\"normal\": [{}]\n"
				+ "	}\n"
				+ "}\n"
				+ "",
				blockName);
	}
}
