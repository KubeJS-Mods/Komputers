package dev.latvian.mods.komputers.api;

import dev.latvian.mods.komputers.data.Computer;

public class KNetAPI {
	private final Computer<?> computer;

	public KNetAPI(Computer<?> c) {
		computer = c;
	}

	public void send(String id, String event, Object data) {
	}

	public void broadcast(String event, Object data) {
	}
}
