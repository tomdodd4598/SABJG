package dodd.json;

import java.util.Locale;

public class HeaterPort extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "fission_heater_port_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"model\": \"nuclearcraft:fission_port_overlayed\",\n"
				+ "		\"textures\": {\n"
				+ "			\"front\": \"nuclearcraft:blocks/heater_port_%s\",\n"
				+ "			\"overlay\": \"nuclearcraft:blocks/fission/port/heater/off\"\n"
				+ "		}\n"
				+ "	},\n"
				+ "	\"variants\": {\n"
				+ "		\"inventory\": [{}],\n"
				+ "		\"active\": {\n"
				+ "			\"false\": {},\n"
				+ "			\"true\": {\n"
				+ "				\"textures\": {\n"
				+ "					\"overlay\": \"nuclearcraft:blocks/fission/port/heater/on\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"axis\": {\n"
				+ "			\"x\": {\"y\": 90},\n"
				+ "			\"y\": {\"x\": 90},\n"
				+ "			\"z\": {}\n"
				+ "		}\n"
				+ "	}\n"
				+ "}\n"
				+ "",
				blockName);
	}
}
