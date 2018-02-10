package com.pf.app.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * 2017/11/1 9:37
 */
public class UserVoucherException extends BaseException {

    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(UserVoucherException.class);

    public UserVoucherException(String massage){
        super(massage);
    }
}
