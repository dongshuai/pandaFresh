package com.pf.app.api.proxy;


public interface RrpService<T> {

    InterfaceResponse execute(T var1);

    T createVo();

    void setUserId(Long userId);
}