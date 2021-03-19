package me.method17.exception.injection.mixins.client;

import io.netty.channel.ChannelHandlerContext;
import me.method17.eventapi.EventManager;
import me.method17.eventapi.events.CancellableEvent;
import me.method17.exception.events.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {
    @Inject(method = "channelRead0", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/Packet;processPacket(Lnet/minecraft/network/INetHandler;)V", shift = At.Shift.BEFORE), cancellable = true)
    private void packetReceived(ChannelHandlerContext handlerContext, Packet packet, CallbackInfo callbackInfo) {
        CancellableEvent event = new PacketEvent(packet, PacketEvent.Type.RECEIVE);
        EventManager.callEvent(event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void sendPacket(Packet packet, CallbackInfo callbackInfo) {
        CancellableEvent event = new PacketEvent(packet, PacketEvent.Type.SEND);
        EventManager.callEvent(event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }
}
