package me.method17.exception;

import me.method17.exception.manager.FileManager;
import me.method17.exception.utils.render.RenderUtil;

public class ExceptionClient {
    public static final String MOD_ID = "exception";
    public static final String CLIENT_NAME = "Exception";
    public static final int CLIENT_VERSION = 1;
    public static final boolean IN_DEV = true;
    public static final String CLIENT_CREATOR = "Method17";

    private static ExceptionClient instance;

    public ExceptionClient(){
        instance=this;
        System.out.println("Loading "+CLIENT_NAME+" b"+CLIENT_VERSION+"...");
    }

    public void start(){
        System.out.println("Starting "+CLIENT_NAME+" b"+CLIENT_VERSION+"...");
        FileManager.init();
        RenderUtil.init();
        System.out.println("Client is OK!");
    }

    public static ExceptionClient getInstance(){
        return instance;
    }
}
