package me.method17.exception.feature.module;

import me.method17.exception.feature.KeyBindManager;

public class ModuleManager {
    private static KeyBindManager keyBindManager;

    public static void init(){
        keyBindManager=new KeyBindManager();
    }

    public static void registerModule(Module module) {

    }
}
