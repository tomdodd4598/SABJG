package dodd.json;

import java.util.Locale;

public class Battery extends Block {
	
	@Override
	public String getFileName(String blockName) {
		return "battery_" + blockName + ".json";
	}
	
	@Override
	public String getJsonContents(String blockName) {
		return String.format(Locale.ROOT,
				"{\n"
				+ "	\"forge_marker\": 1,\n"
				+ "	\"defaults\": {\n"
				+ "		\"textures\": {\n"
				+ "			\"particle\":\"nuclearcraft:blocks/battery_%s_side_in\",\n"
				+ "			\"north\":\"nuclearcraft:blocks/battery_%s_side_in\",\n"
				+ "			\"east\":\"nuclearcraft:blocks/battery_%s_side_in\",\n"
				+ "			\"south\":\"nuclearcraft:blocks/battery_%s_side_in\",\n"
				+ "			\"west\":\"nuclearcraft:blocks/battery_%s_side_in\",\n"
				+ "			\"up\":\"nuclearcraft:blocks/battery_%s_top_in\",\n"
				+ "			\"down\":\"nuclearcraft:blocks/battery_%s_top_in\"\n"
				+ "		},\n"
				+ "		\"model\":\"cube\",\n"
				+ "		\"transform\":\"forge:default-block\"\n"
				+ "	},\n"
				+ "	\"variants\": {\n"
				+ "		\"inventory\": [{}],\n"
				+ "		\"north\": {\n"
				+ "			\"in\": {},\n"
				+ "			\"out\": {\n"
				+ "			   \"textures\": {\n"
				+ "					\"north\":\"nuclearcraft:blocks/battery_%s_side_out\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"non\": {\n"
				+ "				 \"textures\": {\n"
				+ "					\"north\":\"nuclearcraft:blocks/battery_%s_side_non\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"east\": {\n"
				+ "			\"in\": {},\n"
				+ "			\"out\": {\n"
				+ "			   \"textures\": {\n"
				+ "					\"east\":\"nuclearcraft:blocks/battery_%s_side_out\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"non\": {\n"
				+ "				 \"textures\": {\n"
				+ "					\"east\":\"nuclearcraft:blocks/battery_%s_side_non\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"south\": {\n"
				+ "			\"in\": {},\n"
				+ "			\"out\": {\n"
				+ "			   \"textures\": {\n"
				+ "					\"south\":\"nuclearcraft:blocks/battery_%s_side_out\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"non\": {\n"
				+ "				 \"textures\": {\n"
				+ "					\"south\":\"nuclearcraft:blocks/battery_%s_side_non\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"west\": {\n"
				+ "			\"in\": {},\n"
				+ "			\"out\": {\n"
				+ "			   \"textures\": {\n"
				+ "					\"west\":\"nuclearcraft:blocks/battery_%s_side_out\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"non\": {\n"
				+ "				 \"textures\": {\n"
				+ "					\"west\":\"nuclearcraft:blocks/battery_%s_side_non\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"up\": {\n"
				+ "			\"in\": {},\n"
				+ "			\"out\": {\n"
				+ "			   \"textures\": {\n"
				+ "					\"up\":\"nuclearcraft:blocks/battery_%s_top_out\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"non\": {\n"
				+ "				 \"textures\": {\n"
				+ "					\"up\":\"nuclearcraft:blocks/battery_%s_top_non\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		},\n"
				+ "		\"down\": {\n"
				+ "			\"in\": {},\n"
				+ "			\"out\": {\n"
				+ "			   \"textures\": {\n"
				+ "					\"down\":\"nuclearcraft:blocks/battery_%s_top_out\"\n"
				+ "				}\n"
				+ "			},\n"
				+ "			\"non\": {\n"
				+ "				 \"textures\": {\n"
				+ "					\"down\":\"nuclearcraft:blocks/battery_%s_top_non\"\n"
				+ "				}\n"
				+ "			}\n"
				+ "		}\n"
				+ "	}\n"
				+ "}",
				blockName);
	}
}