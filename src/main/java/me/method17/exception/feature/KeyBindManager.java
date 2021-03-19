package me.method17.exception.feature;

import me.method17.eventapi.events.EventHandler;
import me.method17.eventapi.listener.Listener;
import me.method17.exception.events.KeyEvent;
import me.method17.exception.ui.clickgui.ClickGUI;
import net.minecraft.client.Minecraft;

public class KeyBindManager extends Listener {
    @EventHandler
    public void onKey(KeyEvent event) {
        if (event.getName().equals("RSHIFT")) {
            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
        }
    }
}
