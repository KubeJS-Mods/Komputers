package dev.latvian.mods.komputers.block;

import net.minecraft.util.StringRepresentable;

import java.util.HashMap;
import java.util.Map;

public enum LampColor implements StringRepresentable {
	BLACK("black", 0b000),
	RED("red", 0b001),
	GREEN("green", 0b010),
	BLUE("blue", 0b100),
	CYAN("cyan", 0b110),
	MAGENTA("magenta", 0b101),
	YELLOW("yellow", 0b011),
	WHITE("white", 0b111);

	public static final LampColor[] BY_INDEX = new LampColor[8];
	public static final Map<String, LampColor> BY_NAME = new HashMap<>();

	static {
		for (LampColor v : values()) {
			BY_INDEX[v.bits] = v;
			BY_NAME.put(v.name, v);
		}
	}

	private final String name;
	private final int bits;

	LampColor(String n, int b) {
		name = n;
		bits = b;
	}

	@Override
	public String getSerializedName() {
		return name;
	}
}
