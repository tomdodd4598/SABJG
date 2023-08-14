package dodd

val typeList = mutableListOf<String>()
val blockMap = mutableMapOf<String, Block>()

fun put(type: String, block: Block) {
    typeList.add(type)
    blockMap[type] = block
}

fun types() = typeList.joinToString("\n", "Available block types:\n", "\n")

fun main(args: Array<String>) {
    put("sink", Sink())
    put("heater", Heater())
    put("heater_port", HeaterPort())
    put("source", Source())
    put("shield", Shield())
    put("coil", Coil())
    put("blade", Blade())
    put("stator", Stator())
    put("rtg", RTG())
    put("battery", Battery())
    put("rf_cavity", RFCavity())
    put("magnet", Magnet())
    put("detector", Detector())
    put("chamber_heater", ChamberHeater())

    val argc = args.size
    if (argc == 0) {
        print("""Requires block type as first argument!
${types()}
"""
        )
        return
    }

    val blockType = args[0].lowercase()
    if (!blockMap.containsKey(blockType)) {
        print("""Could not find block type "$blockType"!
${types()}
"""
        )
        return
    }

    val block = blockMap[blockType]
    for (i in 1 until argc) {
        val blockName = args[i].lowercase()
        block!!.writeToFile(blockName)
    }
}
