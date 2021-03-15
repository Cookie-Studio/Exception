package me.method17.exception.manager;

import me.method17.exception.ExceptionClient;
import me.method17.exception.ui.clickgui.ClickGUI;
import me.method17.exception.utils.render.RenderUtil;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class EventManager {
    public static void handleRender2D(){
        RenderUtil.drawText("§c§lEx§r§fception §7b"+ ExceptionClient.CLIENT_VERSION,10,10,1,false);
    }

    public static void handleKey(int code){
        String name= Keyboard.getKeyName(code);
//        ClientUtil.displayChatMessage("key="+name+", code="+code);
        if(name.equalsIgnoreCase("RSHIFT")){
            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
        }
    }
}
