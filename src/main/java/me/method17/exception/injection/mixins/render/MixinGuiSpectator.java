package me.method17.exception.injection.mixins.render;

import me.method17.eventapi.EventManager;
import me.method17.exception.events.Render2DEvent;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.gui.ScaledResolution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiSpectator.class)
public class MixinGuiSpectator {
    @Inject(method = "renderTooltip", at = @At("RETURN"))
    private void renderTooltip(ScaledResolution sr, float partialTicks, CallbackInfo ci) {
        EventManager.callEvent(new Render2DEvent());
    }
}
