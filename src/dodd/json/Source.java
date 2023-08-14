package dodd.json;

import java.util.Locale;

public class Source extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "fission_source_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"model\": \"nuclearcraft:wall_part\",\n"
				+ "		\"textures\": {\n"
				+ "			\"in\": \"nuclearcraft:blocks/source_%s\",\n"
				+ "			\"out\": \"nuclearcraft:blocks/fission/source_out_off\",\n"
				+ "			\"side\": \"nuclearcraft:blocks/fission/source_side\",\n"
				+ "			\"top\": \"nuclearcraft:blocks/fission/source_side\"\n"
				+ "		}\n"
				+ "	},\n"
				+ "	\"variants\": {\n"
				+ "		\"inventory\": [{\n"
				+ "			\"y\": 180\n"
				+ "		}],\n"
				+ "		\"active\": {\n"
				+ "			\"false\": {},\n"
				+ "			\"true\": {\n"
				+ "				\"textures\": {\n"
				+ "					\"out\": \"nuclearcraft:blocks/fission/source_out_on\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"facing\": {\n"
				+ "			\"down\": {\"x\": 90},\n"
				+ "			\"up\": {\"x\": 270},\n"
				+ "			\"north\": {},\n"
				+ "			\"east\": {\"y\": 90},\n"
				+ "			\"south\": {\"y\": 180},\n"
				+ "			\"west\": {\"y\": 270}\n"
				+ "		}\n"
				+ "	}\n"
				+ "}\n"
				+ "",
				blockName);
	}
}
