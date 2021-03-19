package me.method17.exception.events;

import me.method17.eventapi.events.CancellableEvent;
import net.minecraft.network.Packet;

public class PacketEvent extends CancellableEvent {
    private final Packet packet;
    private final Type type;
    public PacketEvent(Packet packet, Type type) {
        this.packet = packet;
        this.type = type;
    }

    public Packet getPacket() {
        return packet;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        RECEIVE,
        SEND
    }
}
