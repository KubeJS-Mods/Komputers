package dev.latvian.mods.komputers.data;

import me.shedaniel.architectury.event.Event;
import me.shedaniel.architectury.event.EventActor;
import me.shedaniel.architectury.event.EventFactory;

public interface KomputersEvents {
	Event<EventActor<EntityDataEvent>> REGISTER_ENTITY_APIS = EventFactory.createEventActorLoop();
}
