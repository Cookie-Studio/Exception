package me.method17.exception.feature.module;

import me.method17.eventapi.listener.Listener;
import me.method17.exception.feature.Category;

public class Module extends Listener {
    public String name;
    public String displayName;
    public Category category;

    public Module(String name, String displayName, Category category) {
        ModuleManager.registerModule(this);
        this.setActive(false);
    }

    public void onEnable() {

    }

    public void onDisable() {

    }
}
