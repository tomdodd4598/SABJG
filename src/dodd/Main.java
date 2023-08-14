package dodd;

import java.util.*;
import java.util.stream.Collectors;

import dodd.json.*;

public class Main {
	
	static final List<String> TYPE_LIST = new ArrayList<>();
	static final Map<String, Block> BLOCK_MAP = new HashMap<>();
	
	static void put(String type, Block block) {
		TYPE_LIST.add(type);
		BLOCK_MAP.put(type, block);
	}
	
	static {
		put("sink", new Sink());
		put("heater", new Heater());
		put("heater_port", new HeaterPort());
		put("source", new Source());
		put("shield", new Shield());
		
		put("coil", new Coil());
		put("blade", new Blade());
		put("stator", new Stator());
		
		put("rtg", new RTG());
		put("battery", new Battery());
	}
	
	static String typeList() {
		return TYPE_LIST.stream().collect(Collectors.joining("\n", "Available block types:\n", "\n"));
	}
	
	public static void main(String[] args) {
		int argc = args.length;
		if (argc == 0) {
			System.out.print("Requires block type as first argument!\n" + typeList());
			return;
		}
		
		String blockType = args[0].toLowerCase(Locale.ROOT);
		if (!BLOCK_MAP.containsKey(blockType)) {
			System.out.print("Could not find block type \"" + blockType + "\"!\n" + typeList());
			return;
		}
		
		Block block = BLOCK_MAP.get(blockType);
		for (int i = 1; i < argc; ++i) {
			String blockName = args[i].toLowerCase(Locale.ROOT);
			block.writeToFile(blockName);
		}
	}
}
