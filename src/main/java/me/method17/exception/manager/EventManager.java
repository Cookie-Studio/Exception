package me.method17.exception.manager;

import me.method17.exception.ExceptionClient;
import me.method17.exception.utils.RenderUtil;

public class EventManager {
    public static void handleRender2D(){
        RenderUtil.drawText("§c§lEx§r§fception §7b"+ ExceptionClient.CLIENT_VERSION,10,10,1,false);
    }
}
