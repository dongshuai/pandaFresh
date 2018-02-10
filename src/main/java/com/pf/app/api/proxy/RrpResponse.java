package com.pf.app.api.proxy;

import java.util.List;

public interface RrpResponse {
    int getCode();

    String getMsg();

    List<Object> getValues();
}