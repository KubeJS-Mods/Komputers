package dev.latvian.mods.komputers.api;

import dev.latvian.mods.komputers.data.Computer;
import net.minecraft.server.level.ServerLevel;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class SystemAPI {
	private final Computer<?> computer;
	public transient final ServerLevel overworld;

	public SystemAPI(Computer<?> c) {
		computer = c;
		overworld = computer.info.server.overworld();
	}

	public void exit(String message) {
		throw new ExitException(message);
	}

	public void exit() {
		exit("");
	}

	public long getNanoTime() {
		return System.nanoTime();
	}

	public long getTime() {
		return System.nanoTime() / 10000000L;
	}

	public long getTick() {
		return overworld.getGameTime();
	}

	public void sleep(long ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		} catch (InterruptedException ex) {
		}
	}

	public void sleepNanos(long nanos) {
		if (nanos > 0L) {
			try {
				TimeUnit.NANOSECONDS.sleep(nanos);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void sleepTicks(long ticks) {
		long done = overworld.getGameTime() + ticks;

		while (overworld.getGameTime() < done) {
			sleep(10L);
		}
	}

	public String getDateUTC() {
		return Instant.now().toString();
	}

	public int getOnlinePlayerCount() {
		return computer.info.server.getPlayerCount();
	}

	public String[] getOnlinePlayers() {
		return computer.info.server.getPlayerNames();
	}
}
