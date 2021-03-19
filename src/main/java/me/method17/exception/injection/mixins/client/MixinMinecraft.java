package me.method17.exception.injection.mixins.client;

import me.method17.eventapi.EventManager;
import me.method17.eventapi.events.CancellableEvent;
import me.method17.exception.ExceptionClient;
import me.method17.exception.events.KeyEvent;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Shadow
    public int displayWidth;
    @Shadow
    public int displayHeight;

    private boolean initialized = false;

    @Inject(method = "run", at = @At("HEAD"))
    private void init(CallbackInfo callbackInfo) {
        if (displayWidth < 1067) {
            displayWidth = 1067;
        }
        if (displayHeight < 622) {
            displayHeight = 622;
        }
        if (!initialized) {
            new ExceptionClient();
            initialized = true;
        }
    }

    @Inject(method = "createDisplay", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V", shift = At.Shift.AFTER))
    private void createDisplay(CallbackInfo callbackInfo) {
        Display.setTitle(ExceptionClient.CLIENT_NAME + " b" + ExceptionClient.CLIENT_VERSION + " " + (ExceptionClient.IN_DEV ? "| DEVELOPMENT BUILD" : "by " + ExceptionClient.CLIENT_CREATOR));
    }

    @Inject(method = "startGame", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;", shift = At.Shift.AFTER))
    private void startGame(CallbackInfo callbackInfo) {
        ExceptionClient.getInstance().start();
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER))
    private void onKey(CallbackInfo callbackInfo) {
        if (Keyboard.getEventKeyState()) {
            CancellableEvent event = new KeyEvent(Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey());
            EventManager.callEvent(event);
            if (event.isCancelled()) {
                callbackInfo.cancel();
            }
        }
    }
}
