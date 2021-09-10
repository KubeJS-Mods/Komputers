package dev.latvian.mods.komputers.data;

import dev.latvian.mods.komputers.api.ExitException;

public class ComputerThread extends Thread {
	public final Computer<?> computer;

	public ComputerThread(Computer<?> c) {
		super("Komputers-" + c.info.stringId);
		computer = c;
	}

	@Override
	public void run() {
		try {
			while (computer.isRunning()) {
				// Nothing
			}
		} catch (ExitException ex) {
			computer.info.lastExitMessage = ex.getMessage();
			computer.info.setDirty();
		} catch (Exception ex) {
		}
	}
}
