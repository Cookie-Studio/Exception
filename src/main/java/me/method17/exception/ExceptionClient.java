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
