package me.method17.exception.utils;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class YAKFontRenderer extends FontRenderer {
    public YAKFontRenderer(GameSettings p_i1035_1_, ResourceLocation p_i1035_2_, TextureManager p_i1035_3_, boolean p_i1035_4_) {
        super(p_i1035_1_, p_i1035_2_, p_i1035_3_, p_i1035_4_);
    }

    @Override
    protected float renderUnicodeChar(char ch, boolean italic) {
        int i = ch % 16 * 8;
        int j = ch / 16 * 8;
        int k = italic ? 1 : 0;
        this.bindTexture(this.locationFontTexture);
        int glyph=this.glyphWidth[ch]&255;
        int l = glyph&15;
        int kk = glyph >>> 4;
        float f = (l+1) - kk - 0.02F;
        GL11.glBegin(5);
        GL11.glTexCoord2f((float)i / 128.0F, (float)j / 128.0F);
        GL11.glVertex3f(this.posX + (float)k, this.posY, 0.0F);
        GL11.glTexCoord2f((float)i / 128.0F, ((float)j + 7.99F) / 128.0F);
        GL11.glVertex3f(this.posX - (float)k, this.posY + 7.99F, 0.0F);
        GL11.glTexCoord2f(((float)i + f - 1.0F) / 128.0F, (float)j / 128.0F);
        GL11.glVertex3f(this.posX + f - 1.0F + (float)k, this.posY, 0.0F);
        GL11.glTexCoord2f(((float)i + f - 1.0F) / 128.0F, ((float)j + 7.99F) / 128.0F);
        GL11.glVertex3f(this.posX + f - 1.0F - (float)k, this.posY + 7.99F, 0.0F);
        GL11.glEnd();
        return (float)l;
    }
}
