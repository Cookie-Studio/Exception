package me.method17.exception.ui.clickgui;

import me.method17.exception.feature.Category;
import me.method17.exception.utils.render.Area;
import me.method17.exception.utils.render.RenderUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClickGUI extends GuiScreen {
    private int bgColor=0x66101010,
                spaceColor=0xff555555,
                selectedColor=0xff777777,
                groundColor=0xff363636;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int startWidth= (int) (this.width*0.2),stopWidth= (int) (this.width*0.8);
        int startHeight= (int) (this.height*0.2),stopHeight= (int) (this.height*0.8);
        int spaceSize= (int) (this.width*0.007),bigSpace=spaceSize*3;
        drawRect(0, 0, this.width, this.height, bgColor);
        RenderUtil.roundRect(startWidth,startHeight,stopWidth,stopHeight,spaceSize,groundColor,20);
        RenderUtil.drawText("§c§lEx§r§fception",startWidth+spaceSize*2,startHeight+bigSpace,spaceSize/2.5F,false);
        int yAxis=startHeight+bigSpace*3,moduleHeight=(stopHeight-startHeight)/8;
        for(Category category:Category.values()){
            Area area=new Area(startWidth+spaceSize,yAxis,startWidth+(24*spaceSize),yAxis+moduleHeight);
            RenderUtil.roundRect(area,spaceSize/2,area.mouseIn(mouseX,mouseY)?selectedColor:spaceColor,20);
            category.drawIconAt(startWidth+spaceSize+bigSpace,yAxis+spaceSize*2,bigSpace,bigSpace);
            RenderUtil.drawText("§f"+category.getName(),startWidth+spaceSize+(bigSpace*3),yAxis+bigSpace,spaceSize/5F,false);
            yAxis+=moduleHeight+spaceSize;
        }
        RenderUtil.rect(startWidth+(24*spaceSize)+spaceSize,startHeight,startWidth+(24*spaceSize)+spaceSize*2,stopHeight,selectedColor);
    }
}
