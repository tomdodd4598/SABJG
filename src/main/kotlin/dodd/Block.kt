package dodd

import java.io.File

abstract class Block {

    fun writeToFile(blockName: String) {
        File(getFileName(blockName)).writeText(getJsonContents(blockName))
    }

    abstract fun getFileName(blockName: String): String

    abstract fun getJsonContents(blockName: String): String
}

class Sink : Block() {

    override fun getFileName(blockName: String) = "solid_fission_sink_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/sink_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class Heater : Block() {

    override fun getFileName(blockName: String) = "salt_fission_heater_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/heater_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class HeaterPort : Block() {

    override fun getFileName(blockName: String) = "fission_heater_port_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "nuclearcraft:fission_port_overlayed",
		"textures": {
			"front": "nuclearcraft:blocks/heater_port_$blockName",
			"overlay": "nuclearcraft:blocks/fission/port/heater/off"
		}
	},
	"variants": {
		"inventory": [{}],
		"active": {
			"false": {},
			"true": {
				"textures": {
					"overlay": "nuclearcraft:blocks/fission/port/heater/on"
				}
			}
		},
		"axis": {
			"x": {"y": 90},
			"y": {"x": 90},
			"z": {}
		}
	}
}
"""
}

class Source : Block() {

    override fun getFileName(blockName: String) = "fission_source_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "nuclearcraft:wall_part",
		"textures": {
			"in": "nuclearcraft:blocks/source_$blockName",
			"out": "nuclearcraft:blocks/fission/source_out_off",
			"side": "nuclearcraft:blocks/fission/source_side",
			"top": "nuclearcraft:blocks/fission/source_side"
		}
	},
	"variants": {
		"inventory": [{
			"y": 180
		}],
		"active": {
			"false": {},
			"true": {
				"textures": {
					"out": "nuclearcraft:blocks/fission/source_out_on"
				}
			}
		},
		"facing": {
			"down": {"x": 90},
			"up": {"x": 270},
			"north": {},
			"east": {"y": 90},
			"south": {"y": 180},
			"west": {"y": 270}
		}
	}
}
"""
}

class Shield : Block() {

    override fun getFileName(blockName: String) = "fission_shield_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "nuclearcraft:cube_all_overlayed",
		"textures": {
			"all": "nuclearcraft:blocks/shield_$blockName",
			"overlay": "nuclearcraft:blocks/fission/shield/on"
		}
	},
	"variants": {
		"inventory": [{}],
		"active": {
			"false": {
				"textures": {
					"overlay": "nuclearcraft:blocks/fission/shield/off"
				}
			},
			"true": {}
		}
	}
}
"""
}

class Coil : Block() {

    override fun getFileName(blockName: String) = "turbine_dynamo_coil_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/coil_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class Blade : Block() {

    override fun getFileName(blockName: String) = "turbine_rotor_blade_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "nuclearcraft:turbine_rotor_blade",
		"textures": {
			"texture": "nuclearcraft:blocks/blade_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"dir": {
			"invisible": {
				"model": "nuclearcraft:block_invisible"
			},
			"x": {"x": 90, "y": 90},
			"y": {},
			"z": {"x": 90}
		}
	}
}
"""
}

class Stator : Block() {

    override fun getFileName(blockName: String) = "turbine_rotor_stator_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "nuclearcraft:turbine_rotor_stator",
		"textures": {
			"texture": "nuclearcraft:blocks/stator_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"dir": {
			"invisible": {
				"model": "nuclearcraft:block_invisible"
			},
			"x": {"x": 90, "y": 90},
			"y": {},
			"z": {"x": 90}
		}
	}
}
"""
}

class RTG : Block() {

    override fun getFileName(blockName: String) = "rtg_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_column",
		"textures": {
			"end": "nuclearcraft:blocks/rtg_${blockName}_top",
			"side": "nuclearcraft:blocks/rtg_${blockName}_side"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class Battery : Block() {

    override fun getFileName(blockName: String) = "battery_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"textures": {
			"particle": "nuclearcraft:blocks/battery_${blockName}_side_in",
			"north": "nuclearcraft:blocks/battery_${blockName}_side_in",
			"east": "nuclearcraft:blocks/battery_${blockName}_side_in",
			"south": "nuclearcraft:blocks/battery_${blockName}_side_in",
			"west": "nuclearcraft:blocks/battery_${blockName}_side_in",
			"up": "nuclearcraft:blocks/battery_${blockName}_top_in",
			"down": "nuclearcraft:blocks/battery_${blockName}_top_in"
		},
		"model": "cube",
		"transform": "forge:default-block"
	},
	"variants": {
		"inventory": [{}],
		"north": {
			"in": {},
			"out": {
			   "textures": {
					"north": "nuclearcraft:blocks/battery_${blockName}_side_out"
				}
			},
			"non": {
				 "textures": {
					"north": "nuclearcraft:blocks/battery_${blockName}_side_non"
				}
			}
		},
		"east": {
			"in": {},
			"out": {
			   "textures": {
					"east": "nuclearcraft:blocks/battery_${blockName}_side_out"
				}
			},
			"non": {
				 "textures": {
					"east": "nuclearcraft:blocks/battery_${blockName}_side_non"
				}
			}
		},
		"south": {
			"in": {},
			"out": {
			   "textures": {
					"south": "nuclearcraft:blocks/battery_${blockName}_side_out"
				}
			},
			"non": {
				 "textures": {
					"south": "nuclearcraft:blocks/battery_${blockName}_side_non"
				}
			}
		},
		"west": {
			"in": {},
			"out": {
			   "textures": {
					"west": "nuclearcraft:blocks/battery_${blockName}_side_out"
				}
			},
			"non": {
				 "textures": {
					"west": "nuclearcraft:blocks/battery_${blockName}_side_non"
				}
			}
		},
		"up": {
			"in": {},
			"out": {
			   "textures": {
					"up": "nuclearcraft:blocks/battery_${blockName}_top_out"
				}
			},
			"non": {
				 "textures": {
					"up": "nuclearcraft:blocks/battery_${blockName}_top_non"
				}
			}
		},
		"down": {
			"in": {},
			"out": {
			   "textures": {
					"down": "nuclearcraft:blocks/battery_${blockName}_top_out"
				}
			},
			"non": {
				 "textures": {
					"down": "nuclearcraft:blocks/battery_${blockName}_top_non"
				}
			}
		}
	}
}
"""
}

class RFCavity : Block() {

    override fun getFileName(blockName: String) = "accelerator_rf_cavity_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/rf_cavity_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class Magnet : Block() {

    override fun getFileName(blockName: String) = "accelerator_magnet_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/magnet_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class Detector : Block() {

    override fun getFileName(blockName: String) = "particle_chamber_detector_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/detector_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}

class ChamberHeater : Block() {

    override fun getFileName(blockName: String) = "vacuum_chamber_heater_$blockName.json"

    override fun getJsonContents(blockName: String) = """{
	"forge_marker": 1,
	"defaults": {
		"model": "cube_all",
		"textures": {
			"all": "nuclearcraft:blocks/chamber_heater_$blockName"
		}
	},
	"variants": {
		"inventory": [{}],
		"normal": [{}]
	}
}
"""
}
