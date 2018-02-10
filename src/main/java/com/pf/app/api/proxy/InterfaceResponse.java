package com.pf.app.api.proxy;

public interface InterfaceResponse extends RrpResponse {
    <T> T getData();

    int getCount();

    String getMsg();

    int getCode();

}