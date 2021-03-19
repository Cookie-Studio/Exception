package me.method17.exception;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExceptionClient.MOD_ID, name = ExceptionClient.CLIENT_NAME, version = "b" + ExceptionClient.CLIENT_VERSION, useMetadata = true)
public class ExceptionMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("init");
    }
}
