package dodd

val typeList = mutableListOf<String>()
val writerMap = mutableMapOf<String, List<Writer>>()

fun put(type: String, vararg writers: Writer) {
    typeList.add(type)
    writerMap[type] = writers.asList()
}

fun types() = typeList.joinToString("\n", "Available block types:\n", "\n")

fun main(args: Array<String>) {
    put("rtg", RTG)
    put("battery", Battery)
    put("sink", Sink)
    put("heater", Heater, HeaterPort)
    put("source", Source)
    put("shield", Shield)
    put("tube", Tube, TubeCenter, TubeOpen, TubeOpenBaffle, TubeItem)
    put("coil", Coil)
    put("blade", Blade)
    put("stator", Stator)

    put("machine", Machine)
    put("processor", Processor)

    put("cooler", Cooler)
    put("rf_cavity", RFCavity)
    put("magnet", Magnet)
    put("detector", Detector)
    put("chamber_heater", ChamberHeater)
    put("ion_source", IonSource)

    val argc = args.size
    if (argc == 0) {
        print("""Requires block type as first argument!
${types()}
"""
        )
        return
    }

    val blockType = args[0].lowercase()
    if (!writerMap.containsKey(blockType)) {
        print("""Could not find block type "$blockType"!
${types()}
"""
        )
        return
    }

    val writers = writerMap[blockType]!!
    for (i in 1 until argc) {
        val blockName = args[i].lowercase()
        for (writer in writers) {
            writer.writeToFile(blockName)
        }
    }
}
