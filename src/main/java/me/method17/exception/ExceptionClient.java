package me.method17.exception;

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

    public static ExceptionClient getInstance(){
        return instance;
    }
}
