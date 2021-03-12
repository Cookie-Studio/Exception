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
package me.method17.exception.utils;

import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;

public class ClientUtil {
    public static void displayChatMessage(final String message) {
        Minecraft mc=Minecraft.getMinecraft();

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", message);

        mc.thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent(jsonObject.toString()));
    }
}
