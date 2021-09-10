package dev.latvian.mods.komputers.data;

import me.shedaniel.architectury.utils.NbtType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.ArrayList;
import java.util.List;

public class ComputerInfo extends SavedData {
	public static ComputerInfo create(MinecraftServer server, long id) {
		return server.overworld().getDataStorage().computeIfAbsent(() -> new ComputerInfo(server, id), String.format("komputers_%016x", id));
	}

	public final MinecraftServer server;
	public final long id;
	public final String stringId;
	public boolean active;
	public final List<Component> consoleOutput;
	public String lastExitMessage;

	public ComputerInfo(MinecraftServer s, long l) {
		super(String.format("komputers_%016x", l));
		server = s;
		id = l;
		stringId = String.format("%016x", id);
		active = false;
		consoleOutput = new ArrayList<>();
		lastExitMessage = "";
	}

	@Override
	public String toString() {
		return stringId;
	}

	@Override
	public void load(CompoundTag tag) {
		active = tag.getBoolean("Active");

		ListTag consoleOutputTag = tag.getList("ConsoleOutput", NbtType.STRING);

		consoleOutput.clear();

		for (int i = 0; i < consoleOutputTag.size(); i++) {
			String s = consoleOutputTag.getString(i);
			consoleOutput.add(s.isEmpty() ? TextComponent.EMPTY : Component.Serializer.fromJson(s));
		}

		lastExitMessage = tag.getString("LastExitMessage");
	}

	@Override
	public CompoundTag save(CompoundTag tag) {
		tag.putBoolean("Active", active);

		ListTag consoleOutputTag = new ListTag();

		for (Component c : consoleOutput) {
			consoleOutputTag.add(StringTag.valueOf(c == TextComponent.EMPTY ? "" : Component.Serializer.toJson(c)));
		}

		tag.put("ConsoleOutput", consoleOutputTag);
		tag.putString("LastExitMessage", lastExitMessage);
		return tag;
	}
}
