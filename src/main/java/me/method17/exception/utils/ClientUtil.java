package me.method17.exception.utils;

import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class ClientUtil {
    public static void displayChatMessage(final String message) {
        Minecraft mc = Minecraft.getMinecraft();

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", message);

        mc.thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent(jsonObject.toString()));
    }

    public static ResourceLocation loadImageFromBase64(String image) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(image));
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
        byteArrayInputStream.close();
        ResourceLocation rl = new ResourceLocation("exception_resource_" + MathUtil.randDouble(-100, 100));
        Minecraft.getMinecraft().getTextureManager()
                .loadTexture(rl, new DynamicTexture(bufferedImage));
        return rl;
    }

    public static ResourceLocation loadImageFromFile(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        inputStream.close();
        ResourceLocation rl = new ResourceLocation("exception_resource_" + MathUtil.randDouble(-100, 100));
        Minecraft.getMinecraft().getTextureManager()
                .loadTexture(rl, new DynamicTexture(bufferedImage));
        return rl;
    }
}
