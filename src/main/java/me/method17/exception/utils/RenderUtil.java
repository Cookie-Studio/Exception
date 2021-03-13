package me.method17.exception.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderUtil {
    public static FontRenderer YAK_FONT_RENDERER;

    public static void init(){
        Minecraft mc=Minecraft.getMinecraft();
//        YAK_FONT_RENDERER=Minecraft.getMinecraft().fontRendererObj;
        YAK_FONT_RENDERER=new YAKFontRenderer(mc.gameSettings, new ResourceLocation("textures/font/yak.png"), mc.renderEngine, true);
    }

    public static void drawText(String text,int width,int height,float size,boolean isMCFont){
        GlStateManager.pushMatrix();
        //set scale
        GlStateManager.scale(size,size,size);
        FontRenderer fontRenderer=YAK_FONT_RENDERER;
        if(isMCFont){
            fontRenderer=Minecraft.getMinecraft().fontRendererObj;
        }
        fontRenderer.drawString(text,Math.round(width/size),Math.round(height/size),0);
        GlStateManager.popMatrix();
    }

    public static void roundRect(int x1, int y1, int x2, int y2,int radius,int fill,int sections){
        //circle part
        drawFilledCircle(x1+radius,y1+radius,radius,fill,sections);
        drawFilledCircle(x2-radius,y1+radius,radius,fill,sections);
        drawFilledCircle(x1+radius,y2-radius,radius,fill,sections);
        drawFilledCircle(x2-radius,y2-radius,radius,fill,sections);
        //rect part
        rect(x1+radius, y1+radius, x2-radius, y2-radius, fill);
        rect(x1+radius, y1, x2-radius, y1+radius, fill);
        rect(x1+radius, y2-radius, x2-radius, y2, fill);
        rect(x1, y1+radius, x1+radius, y2-radius, fill);
        rect(x2-radius, y1+radius, x2, y2-radius, fill);
    }

    public static void drawFilledCircle(int xx, int yy, int radius, int fill,int sections) {
        double dAngle = 2 * Math.PI / sections;
        float x, y;

        float f = (fill >> 24 & 0xFF) / 255.0F;
        float f1 = (fill >> 16 & 0xFF) / 255.0F;
        float f2 = (fill >> 8 & 0xFF) / 255.0F;
        float f3 = (fill & 0xFF) / 255.0F;

        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glBegin(GL11.GL_TRIANGLE_FAN);
        GL11.glColor4f(f1, f2, f3, f);

        for (int i = 0; i < sections; i++) {
            x = (float) (radius * Math.sin((i * dAngle)));
            y = (float) (radius * Math.cos((i * dAngle)));

            GL11.glVertex2f(xx + x, yy + y);
        }

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

        GL11.glEnd();

        GL11.glPopAttrib();
    }

    public static void rect(int x1, int y1, int x2, int y2, int fill) {
        GlStateManager.color(0, 0, 0);
        GL11.glColor4f(0, 0, 0, 0);

        float f = (fill >> 24 & 0xFF) / 255.0F;
        float f1 = (fill >> 16 & 0xFF) / 255.0F;
        float f2 = (fill >> 8 & 0xFF) / 255.0F;
        float f3 = (fill & 0xFF) / 255.0F;

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);

        GL11.glPushMatrix();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(7);
        GL11.glVertex2d(x2, y1);
        GL11.glVertex2d(x1, y1);
        GL11.glVertex2d(x1, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glEnd();
        GL11.glPopMatrix();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }

}
