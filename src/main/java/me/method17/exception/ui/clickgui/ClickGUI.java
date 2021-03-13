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
package me.method17.exception.ui.clickgui;

import me.method17.exception.utils.RenderUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClickGUI extends GuiScreen {
    private int bgColor=0x66101010,
                spaceColor=0xff8470ff,
                groundColor=0xff363636;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int startWidth= (int) (this.width*0.2),stopWidth= (int) (this.width*0.8);
        int startHeight= (int) (this.height*0.2),stopHeight= (int) (this.height*0.8);
        int spaceSize= (int) (this.width*0.007);
        drawRect(0, 0, this.width, this.height, bgColor);
        RenderUtil.roundRect(startWidth,startHeight,stopWidth,stopHeight,spaceSize*2,groundColor,20);
        RenderUtil.drawText("§c§lEx§r§fception",startWidth+(spaceSize*3),startHeight+(spaceSize*3),spaceSize/2.5F,false);
    }
}
