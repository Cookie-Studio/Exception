package me.method17.exception.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class YAKFontRenderer extends FontRenderer {
    public YAKFontRenderer(Minecraft mc) {
        super(mc.gameSettings, new ResourceLocation("textures/font/yak.png"), mc.renderEngine, false);

        //read texture
        BufferedImage bufferedimage;
        try {
            bufferedimage = TextureUtil.readBufferedImage(this.getResourceInputStream(this.locationFontTexture));
        } catch (IOException var17) {
            throw new RuntimeException(var17);
        }

        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        int[] aint = new int[i * j];
        bufferedimage.getRGB(0, 0, i, j, aint, 0, i);
        int k = j / 16;
        int l = i / 16;
        int i1 = 1;
        float f = 8.0F / (float)l;

        for(int j1 = 0; j1 < 256; ++j1) {
            int k1 = j1 % 16;
            int l1 = j1 / 16;
            if (j1 == 32) {
                this.charWidth[j1] = 3 + i1;
            }

            int i2;
            for(i2 = l - 1; i2 >= 0; --i2) {
                int j2 = k1 * l + i2;
                boolean flag = true;

                for(int k2 = 0; k2 < k && flag; ++k2) {
                    int l2 = (l1 * l + k2) * i;
                    if ((aint[j2 + l2] >> 24 & 255) != 0) {
                        flag = false;
                    }
                }

                if (!flag) {
                    break;
                }
            }

            ++i2;
            this.charWidth[j1] = (int)(0.5D + (double)((float)i2 * f)) + i1;
        }
    }

    @Override
    protected float renderUnicodeChar(char ch, boolean italic) {
        //ignore language force unicode(like ZH_CN)
        if(ch<256) {
            return renderDefaultChar(ch, italic);
        }else{
            return super.renderUnicodeChar(ch,italic);
        }
    }
}
