package dev.latvian.mods.komputers.data;

import dev.latvian.mods.komputers.api.ConsoleAPI;
import dev.latvian.mods.komputers.api.SystemAPI;

public class Computer<T> {
	public final ComputerInfo info;
	public final T holder;
	public boolean running;

	public final SystemAPI system;
	public final ConsoleAPI console;

	public Computer(ComputerInfo i, T h) {
		info = i;
		holder = h;
		running = true;

		system = new SystemAPI(this);
		console = new ConsoleAPI(this);
	}

	public boolean isRunning() {
		return running;
	}
}
