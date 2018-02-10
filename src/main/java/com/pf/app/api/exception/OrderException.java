package com.pf.app.api.exception;

/**
 * TODO(这里用一句话描述这个类的作用)
 *
 * @author dosh
 * @date 2015/8/21 17:04
 */
public class OrderException extends BaseException {
    /**
	 *
	 */
	private static final long serialVersionUID = 8819278821524754399L;
    private String code;

    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderException(Throwable cause) {
        super(cause);
    }

    public OrderException(String code, String message) {
        super(message);
        this.code = code;
    }

    protected OrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OrderException(String message, Object... format) {
        super(message, format);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
