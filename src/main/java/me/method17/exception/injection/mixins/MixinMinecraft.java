/*
 * Copyright (c) 2021 Method17
 * Exception is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package me.method17.exception.injection.mixins;

import me.method17.exception.ExceptionClient;
import me.method17.exception.ui.clickgui.ClickGUI;
import me.method17.exception.utils.ClientUtil;
import me.method17.exception.utils.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
@SideOnly(Side.CLIENT)
public class MixinMinecraft{
    @Shadow
    public int displayWidth;
    @Shadow
    public int displayHeight;

    private boolean initialized=false;

    @Inject(method = "run", at = @At("HEAD"))
    private void init(CallbackInfo callbackInfo) {
        if (displayWidth < 1067){
            displayWidth = 1067;
        }
        if (displayHeight < 622) {
            displayHeight = 622;
        }
        if(!initialized){
            new ExceptionClient();
            initialized=true;
        }
    }

    @Inject(method = "createDisplay", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V", shift = At.Shift.AFTER))
    private void createDisplay(CallbackInfo callbackInfo) {
        Display.setTitle(ExceptionClient.CLIENT_NAME+" b"+ ExceptionClient.CLIENT_VERSION+" "+(ExceptionClient.IN_DEV?"| DEVELOPMENT BUILD":"by "+ ExceptionClient.CLIENT_CREATOR));
    }

    @Inject(method = "startGame", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;", shift = At.Shift.AFTER))
    private void startGame(CallbackInfo ci) {
        RenderUtil.init();
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER))
    private void onKey(CallbackInfo callbackInfo) {
        if (Keyboard.getEventKeyState()){
            int code=Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
            String name=Keyboard.getKeyName(code);
            ClientUtil.displayChatMessage("key="+name+", code="+code);
            if(name.equalsIgnoreCase("RSHIFT")){
                Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
            }
        }
    }
}
