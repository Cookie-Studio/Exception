package me.method17.exception.feature.module.modules.settings;

import me.method17.eventapi.events.EventHandler;
import me.method17.exception.ExceptionClient;
import me.method17.exception.events.Render2DEvent;
import me.method17.exception.feature.Category;
import me.method17.exception.feature.module.Module;
import me.method17.exception.utils.render.RenderUtil;

public class HUD extends Module {
    public HUD() {
        super("hud", "HUD", Category.RENDER);
    }

    @EventHandler
    public void onRender2D(Render2DEvent event) {
        RenderUtil.drawText("§c§lEx§r§fception §7b" + ExceptionClient.CLIENT_VERSION, 10, 10, 1, false);
    }
}
