package dev.latvian.mods.komputers.core.mixin.common;

import dev.latvian.mods.komputers.core.EntityK;
import dev.latvian.mods.komputers.data.EntityData;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author LatvianModder
 */
@Mixin(Entity.class)
public abstract class EntityMixin implements EntityK {
	private EntityData entityDataK;

	@Override
	public EntityData getEntityDataK() {
		if (entityDataK == null) {
			entityDataK = new EntityData((Entity) (Object) this);
		}

		return entityDataK;
	}
}
