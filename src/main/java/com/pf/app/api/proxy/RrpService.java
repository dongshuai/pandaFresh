package com.pf.app.api.proxy;

import javax.servlet.http.HttpServletRequest;

public interface RrpService<T> {

    InterfaceResponse execute(T var1);

    T createVo();

    void setRequest(HttpServletRequest request);
}