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
package me.method17.exception;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExceptionClient.MOD_ID, name = ExceptionClient.CLIENT_NAME, version = "b"+ ExceptionClient.CLIENT_VERSION,useMetadata = true)
public class ExceptionMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("init");
    }
}
