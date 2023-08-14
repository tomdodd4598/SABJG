package dodd.json;

import java.util.Locale;

public class Sink extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "solid_fission_sink_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"model\":\"cube_all\",\n"
				+ "		\"textures\": {\n"
				+ "			\"all\": \"nuclearcraft:blocks/sink_%s\"\n"
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
