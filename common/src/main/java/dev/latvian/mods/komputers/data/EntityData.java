package dev.latvian.mods.komputers.data;

import dev.latvian.mods.rhino.util.MapLike;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EntityData implements MapLike<String, Object> {
	public final transient Entity entity;
	private final Map<String, Object> apis;

	public EntityData(Entity e) {
		entity = e;
		apis = new HashMap<>();
		KomputersEvents.REGISTER_ENTITY_APIS.invoker().act(new EntityDataEvent(apis));
	}

	@Override
	@Nullable
	public Object getML(String s) {
		return apis.get(s);
	}

	@Override
	public Collection<String> keysML() {
		return apis.keySet();
	}

	public String getUuid() {
		return entity.getStringUUID();
	}

	public String getName() {
		return entity.getScoreboardName();
	}

	public double getX() {
		return entity.getX();
	}

	public double getY() {
		return entity.getY();
	}

	public double getZ() {
		return entity.getZ();
	}
}
