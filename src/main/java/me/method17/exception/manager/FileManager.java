package me.method17.exception.manager;

import me.method17.exception.utils.FileUtil;

import java.io.File;

public class FileManager {
    public static void init(){
        File folder=new File("./Exception");
        if(!folder.exists()){
            folder.mkdirs();
        }
        {
            File font = new File("./Exception/font.png");
            if(!font.exists()){
                try {
                    FileUtil.writeFile("./Exception/font.png"
                            ,FileUtil.getByteFromInputStream(FileUtil.getInputStreamFromResource("res/font.png")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
