package com.pf.app.api.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * TODO(这里用一句话描述这个类的作用)
 *
 * @author dosh
 * @date 2015/8/21 17:06
 */
public class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     */
    public BaseException(String message, Object ... format) {
        super(getMsg(message, format));
    }

    private static String getMsg(String format, Object ... obj) {
        if (StringUtils.isBlank(format)) {
            return format;
        }

        if (obj == null) {
            return format;
        }

        if (obj.length == 1) {
            return StringUtils.replace(format, "{}", obj[0] == null ? "null" : obj[0].toString());
        }

        int i = 0;
        while(true) {
            int indexof = StringUtils.indexOf(format, "{}");
            if (indexof == -1)
                break;
            String left = StringUtils.substring(format, 0, indexof + 1);
            String right = StringUtils.substring(format, indexof + 1);
            format = left + i++ + right;
        }

        String[] search = new String[obj.length];
        String[] replace = new String[obj.length];

        for (int j = 0; j < obj.length; j ++) {
            search[j] = "{" + j + "}";
            replace[j] = obj[j] == null ? "null" : obj[j].toString();
        }

        return StringUtils.replaceEach(format, search, replace);
    }
}
