package dev.latvian.mods.komputers.net;

import dev.latvian.mods.komputers.Komputers;
import me.shedaniel.architectury.networking.NetworkManager.PacketContext;
import me.shedaniel.architectury.networking.simple.BaseS2CMessage;
import me.shedaniel.architectury.networking.simple.MessageType;
import net.minecraft.network.FriendlyByteBuf;

/**
 * @author LatvianModder
 */
public class KNetUpdate extends BaseS2CMessage {
	private final long id;
	private final int value;

	public KNetUpdate(long i, int v) {
		id = i;
		value = v;
	}

	KNetUpdate(FriendlyByteBuf buffer) {
		id = buffer.readLong();
		value = buffer.readVarInt();
	}

	@Override
	public MessageType getType() {
		return KomputersNet.PAINT;
	}

	@Override
	public void write(FriendlyByteBuf buffer) {
		buffer.writeLong(id);
		buffer.writeVarInt(value);
	}

	@Override
	public void handle(PacketContext context) {
		Komputers.PROXY.knetUpdate(id, value);
	}
}