package com.pf.app.api.proxy;

public interface RrpServiceProxy<T> extends SelfProxy {

    /**
     * 执行代理,  可执行 read only 只读事物, 也可以完全就不执行事物
     * doExecute:<br>
     *
     * @param t
     * @return
     * @since 1.0
     */
    InterfaceResponse doExecute(T t);

    /**
     * 事物执行代理
     * doExecuteByTransactional:<br>
     *
     * @param t
     * @return
     * @since 1.0
     */
    InterfaceResponse doExecuteByTransactional(T t);

}