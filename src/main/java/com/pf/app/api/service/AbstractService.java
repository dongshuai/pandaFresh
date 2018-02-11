package com.pf.app.api.service;




import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.proxy.*;
import com.pf.app.api.util.ReflectUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by doshuai on 2015/12/1.
 */
public abstract class AbstractService<T> implements RrpService<T>, RrpServiceProxy<T> {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractService.class);
    protected static final String[] READ_ONLY_PREFIX = new String[]{"query", "info", "check"};
    private static String HEADER_TOKEN;
    private  String userId;
    private Class<T> clazz;
    protected RrpServiceProxy target;

    public AbstractService(){
        clazz = ReflectUtil.findParameterizedType(getClass(),0);
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public  T createVo(){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setSelf(SelfProxy self) {
        this.target = (RrpServiceProxy) self;
    }

    @Override
    public InterfaceResponse execute(T t) {
        String name = StringUtils.lowerCase(getClass().getSimpleName());
        int idx = StringUtils.indexOfAny(name, READ_ONLY_PREFIX);
        ReadOnly ro = getClass().getAnnotation(ReadOnly.class);
        if (idx > -1 || ro != null) {
            return target.doExecute(t);
        } else {
            return target.doExecuteByTransactional(t);
        }
    }

    @Override
    public InterfaceResponse doExecute(T t) {
        InterfaceResponse o = check(t);
        if(null==o) {
            return executor(t);
        }else{
            return o;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public InterfaceResponse doExecuteByTransactional(T t){

        InterfaceResponse response = null;
        response = doExecute(t);
        return response;
    }

    public abstract InterfaceResponse check(T t);

    public abstract InterfaceResponse executor(T t) ;

    protected InterfaceResponse error(int code, String message) {
        DefaultInterfaceResponse response = new DefaultInterfaceResponse();
        response.setCode(code);
        response.setMsg(message);
        return response;
    }

    protected InterfaceResponse success(int count, Object data) {
        DefaultInterfaceResponse response = new DefaultInterfaceResponse();
        response.setCode(0);
        response.setMsg("success");
        response.put("count", count);
        response.put("data", data);
        return response;
    }

    protected InterfaceResponse success(Object data) {
        DefaultInterfaceResponse response = new DefaultInterfaceResponse();
        response.setCode(0);
        response.setMsg("success");
        response.put("data", data);
        return response;
    }



    protected InterfaceResponse success() {
        DefaultInterfaceResponse response = new DefaultInterfaceResponse();
        response.setCode(0);
        response.setMsg("success");
        return response;
    }

}
