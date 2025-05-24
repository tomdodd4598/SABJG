package dodd

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

val rotationMap = mapOf(
    "down" to ("x" to 90),
    "up" to ("x" to 270),
    "north" to null,
    "south" to ("y" to 180),
    "west" to ("y" to 270),
    "east" to ("y" to 90)
)

fun rotationPair(dir: String) = dir to (rotationMap[dir]?.let { obj(it) } ?: obj())

abstract class Writer {

    fun writeToFile(blockName: String) {
        val path = getFilePath(blockName)
        Files.createDirectories(Paths.get(path.substring(0, path.lastIndexOf('/'))))
        File(path).writeText(getJsonContents(blockName))
    }

    abstract fun getFilePath(blockName: String): String

    abstract fun getJsonContents(blockName: String): String
}

object RTG : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/rtg_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_column",
            "textures" to obj(
                "end" to "nuclearcraft:blocks/rtg_${blockName}_top",
                "side" to "nuclearcraft:blocks/rtg_${blockName}_side"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object Battery : Writer() {

    private fun texture(blockName: String, side: String, sorption: String) = "nuclearcraft:blocks/battery_${blockName}_${side}_$sorption"

    private fun variant(blockName: String, dir: String, side: String) = dir to obj(
        "in" to obj(),
        "out" to obj(
            "textures" to obj(
                dir to texture(blockName, side, "out")
            )
        ),
        "non" to obj(
            "textures" to obj(
                dir to texture(blockName, side, "non")
            )
        )
    )

    override fun getFilePath(blockName: String) = "blockstates/battery_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "textures" to obj(
                "particle" to texture(blockName, "side", "in"),
                "down" to texture(blockName, "top", "in"),
                "up" to texture(blockName, "top", "in"),
                "north" to texture(blockName, "side", "in"),
                "south" to texture(blockName, "side", "in"),
                "west" to texture(blockName, "side", "in"),
                "east" to texture(blockName, "side", "in")
            ),
            "model" to "cube",
            "transform" to "forge:default-block"
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            variant(blockName, "down", "top"),
            variant(blockName, "up", "top"),
            variant(blockName, "north", "side"),
            variant(blockName, "south", "side"),
            variant(blockName, "west", "side"),
            variant(blockName, "east", "side")
        )
    )
}

object Sink : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/solid_fission_sink_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/sink_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object Heater : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/salt_fission_heater_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/heater_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object HeaterPort : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/fission_heater_port_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:fission_port_overlayed",
            "textures" to obj(
                "front" to "nuclearcraft:blocks/heater_port_$blockName",
                "overlay" to "nuclearcraft:blocks/fission/port/heater/off"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "active" to obj(
                "false" to obj(),
                "true" to obj(
                    "textures" to obj(
                        "overlay" to "nuclearcraft:blocks/fission/port/heater/on"
                    )
                )
            ),
            "axis" to obj(
                "x" to obj(
                    "y" to 90
                ),
                "y" to obj(
                    "x" to 90
                ),
                "z" to obj()
            )
        )
    )
}

object Source : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/fission_source_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:wall_part",
            "textures" to obj(
                "in" to "nuclearcraft:blocks/source_$blockName",
                "out" to "nuclearcraft:blocks/fission/source_out_off",
                "side" to "nuclearcraft:blocks/fission/source_side",
                "top" to "nuclearcraft:blocks/fission/source_side"
            )
        ),
        "variants" to obj(
            "inventory" to arr(
                obj(
                    "y" to 180
                )
            ),
            "active" to obj(
                "false" to obj(),
                "true" to obj(
                    "textures" to obj(
                        "out" to "nuclearcraft:blocks/fission/source_out_on"
                    )
                )
            ),
            "facing" to obj(
                rotationPair("down"),
                rotationPair("up"),
                rotationPair("north"),
                rotationPair("south"),
                rotationPair("west"),
                rotationPair("east")
            )
        )
    )
}

object Shield : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/fission_shield_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:cube_all_overlayed",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/shield_$blockName",
                "overlay" to "nuclearcraft:blocks/fission/shield/on"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "active" to obj(
                "false" to obj(
                    "textures" to obj(
                        "overlay" to "nuclearcraft:blocks/fission/shield/off"
                    )
                ),
                "true" to obj()
            )
        )
    )
}

object Tube : Writer() {

    private fun model(blockName: String, suffix: String) = "nuclearcraft:heat_exchanger_tube_${blockName}_$suffix"

    private fun part(dir: String, variant: String, model: String) = obj(
        "when" to obj(
            dir to variant
        ),
        "apply" to obj(*listOfNotNull(
            "model" to model,
            rotationMap[dir],
            "uvlock" to true
        ).toTypedArray())
    )

    override fun getFilePath(blockName: String) = "blockstates/heat_exchanger_tube_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "multipart" to arr(
            obj(
                "apply" to obj(
                    "model" to model(blockName, "center")
                )
            ),
            part("down", "open", model(blockName, "open")),
            part("up", "open", model(blockName, "open")),
            part("north", "open", model(blockName, "open")),
            part("south", "open", model(blockName, "open")),
            part("west", "open", model(blockName, "open")),
            part("east", "open", model(blockName, "open")),
            part("down", "closed_baffle", "nuclearcraft:heat_exchanger_tube_closed_baffle"),
            part("up", "closed_baffle", "nuclearcraft:heat_exchanger_tube_closed_baffle"),
            part("north", "closed_baffle", "nuclearcraft:heat_exchanger_tube_closed_baffle"),
            part("south", "closed_baffle", "nuclearcraft:heat_exchanger_tube_closed_baffle"),
            part("west", "closed_baffle", "nuclearcraft:heat_exchanger_tube_closed_baffle"),
            part("east", "closed_baffle", "nuclearcraft:heat_exchanger_tube_closed_baffle"),
            part("down", "open_baffle", model(blockName, "open_baffle")),
            part("up", "open_baffle", model(blockName, "open_baffle")),
            part("north", "open_baffle", model(blockName, "open_baffle")),
            part("south", "open_baffle", model(blockName, "open_baffle")),
            part("west", "open_baffle", model(blockName, "open_baffle")),
            part("east", "open_baffle", model(blockName, "open_baffle")),
        )
    )
}

object TubeCenter : Writer() {

    override fun getFilePath(blockName: String) = "models/block/heat_exchanger_tube_${blockName}_center.json"

    override fun getJsonContents(blockName: String) = json(
        "parent" to "nuclearcraft:block/heat_exchanger_tube_center",
        "textures" to obj(
            "all" to "nuclearcraft:blocks/heat_exchanger_tube_${blockName}_center"
        )
    )
}

object TubeOpen : Writer() {

    override fun getFilePath(blockName: String) = "models/block/heat_exchanger_tube_${blockName}_open.json"

    override fun getJsonContents(blockName: String) = json(
        "parent" to "nuclearcraft:block/heat_exchanger_tube_open",
        "textures" to obj(
            "all" to "nuclearcraft:blocks/heat_exchanger_tube_${blockName}_open"
        )
    )
}

object TubeOpenBaffle : Writer() {

    override fun getFilePath(blockName: String) = "models/block/heat_exchanger_tube_${blockName}_open_baffle.json"

    override fun getJsonContents(blockName: String) = json(
        "parent" to "nuclearcraft:block/heat_exchanger_tube_open_baffle",
        "textures" to obj(
            "all" to "nuclearcraft:blocks/heat_exchanger_tube_${blockName}_open_baffle"
        )
    )
}

object TubeItem : Writer() {

    override fun getFilePath(blockName: String) = "models/item/heat_exchanger_tube_${blockName}.json"

    override fun getJsonContents(blockName: String) = json(
        "parent" to "nuclearcraft:block/heat_exchanger_tube_${blockName}_center",
    )
}

object Coil : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/turbine_dynamo_coil_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/coil_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object Blade : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/turbine_rotor_blade_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:turbine_rotor_blade",
            "textures" to obj(
                "texture" to "nuclearcraft:blocks/blade_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "dir" to obj(
                "invisible" to obj(
                    "model" to "nuclearcraft:block_invisible"
                ),
                "x" to obj(
                    "x" to 90,
                    "y" to 90
                ),
                "y" to obj(),
                "z" to obj(
                    "x" to 90
                )
            )
        )
    )
}

object Stator : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/turbine_rotor_stator_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:turbine_rotor_stator",
            "textures" to obj(
                "texture" to "nuclearcraft:blocks/stator_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "dir" to obj(
                "invisible" to obj(
                    "model" to "nuclearcraft:block_invisible"
                ),
                "x" to obj(
                    "x" to 90,
                    "y" to 90
                ),
                "y" to obj(),
                "z" to obj(
                    "x" to 90
                )
            )
        )
    )
}

object Machine : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:machine",
            "textures" to obj(
                "top" to "nuclearcraft:blocks/${blockName}_top",
                "bottom" to "nuclearcraft:blocks/${blockName}_side",
                "front" to "nuclearcraft:blocks/${blockName}_front_off",
                "side" to "nuclearcraft:blocks/${blockName}_side",
                "back" to "nuclearcraft:blocks/${blockName}_side"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "active" to obj(
                "false" to obj(),
                "true" to obj(
                    "textures" to obj(
                        "front" to "nuclearcraft:blocks/${blockName}_front_on"
                    )
                )
            ),
            "facing" to obj(
                rotationPair("north"),
                rotationPair("south"),
                rotationPair("west"),
                rotationPair("east")
            )
        )
    )
}

object Processor : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:processor",
            "textures" to obj(
                "front" to "nuclearcraft:blocks/${blockName}_front_off"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "active" to obj(
                "false" to obj(),
                "true" to obj(
                    "textures" to obj(
                        "front" to "nuclearcraft:blocks/${blockName}_front_on"
                    )
                )
            ),
            "facing" to obj(
                rotationPair("north"),
                rotationPair("south"),
                rotationPair("west"),
                rotationPair("east")
            )
        )
    )
}

object Cooler : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/accelerator_cooler_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/cooler_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object RFCavity : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/accelerator_rf_cavity_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/rf_cavity_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object Magnet : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/accelerator_magnet_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/magnet_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object Detector : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/particle_chamber_detector_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/detector_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object ChamberHeater : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/vacuum_chamber_heater_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "cube_all",
            "textures" to obj(
                "all" to "nuclearcraft:blocks/chamber_heater_$blockName"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "normal" to arr(obj())
        )
    )
}

object IonSource : Writer() {

    override fun getFilePath(blockName: String) = "blockstates/accelerator_source_$blockName.json"

    override fun getJsonContents(blockName: String) = json(
        "forge_marker" to 1,
        "defaults" to obj(
            "model" to "nuclearcraft:machine",
            "textures" to obj(
                "top" to "qmd:blocks/accelerator/casing",
                "bottom" to "qmd:blocks/accelerator/casing",
                "front" to "nuclearcraft:blocks/ion_source_${blockName}_front",
                "side" to "qmd:blocks/accelerator/casing",
                "back" to "nuclearcraft:blocks/ion_source_${blockName}_back"
            )
        ),
        "variants" to obj(
            "inventory" to arr(obj()),
            "facing" to obj(
                rotationPair("down"),
                rotationPair("up"),
                rotationPair("north"),
                rotationPair("south"),
                rotationPair("west"),
                rotationPair("east")
            )
        )
    )
}
