package dev.latvian.mods.komputers.api;

import dev.latvian.mods.komputers.Komputers;
import dev.latvian.mods.komputers.data.Computer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class ConsoleAPI {
	private final Computer<?> computer;
	public transient String input;

	public ConsoleAPI(Computer<?> c) {
		computer = c;
		input = "";
	}

	public void println(Component text) {
		computer.info.consoleOutput.add(text);
		computer.info.setDirty();
		Komputers.LOGGER.info(text.getString());
		// send to clients
	}

	public void println() {
		computer.info.consoleOutput.add(TextComponent.EMPTY);
		computer.info.setDirty();
		Komputers.LOGGER.info("");
		// send to clients
	}

	public String readString() {
		while (input.isEmpty()) {
			computer.system.sleep(50L);
		}

		String s = input;
		input = "";
		return s;
	}

	public int readInt() {
		return Integer.parseInt(readString());
	}

	public double readFloat() {
		return Double.parseDouble(readString());
	}

	public boolean readBoolean() {
		String s = readString();
		return s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("T") || s.equalsIgnoreCase("true");
	}
}
