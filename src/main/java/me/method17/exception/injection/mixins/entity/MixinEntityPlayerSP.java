package me.method17.exception.injection.mixins.entity;

import me.method17.eventapi.EventManager;
import me.method17.exception.events.MotionEvent;
import me.method17.exception.events.UpdateEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP extends MixinEntity {
    @Inject(method = "onUpdate", at = @At("HEAD"))
    private void onUpdate(CallbackInfo ci) {
        EventManager.callEvent(new UpdateEvent());
    }

    @Inject(method = "onUpdateWalkingPlayer", at = @At("HEAD"))
    private void onUpdateWalkingPlayerPre(CallbackInfo ci) {
        MotionEvent event = new MotionEvent(posX, posY, posZ, motionX, motionY, motionZ, rotationYaw, rotationPitch, onGround);
        EventManager.callEvent(event);
        posX = event.getX();
        posY = event.getY();
        posZ = event.getZ();
        motionX = event.getMotionX();
        motionY = event.getMotionY();
        motionZ = event.getMotionZ();
        rotationYaw = event.getYaw();
        rotationPitch = event.getPitch();
        onGround = event.isOnGround();
    }
}
