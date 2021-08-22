package dev.latvian.mods.komputers.data;

import java.util.Map;

public class EntityDataEvent {
	private final Map<String, Object> apis;

	public EntityDataEvent(Map<String, Object> m) {
		apis = m;
	}

	public void add(String name, Object api) {
		apis.put(name, api);
	}
}
