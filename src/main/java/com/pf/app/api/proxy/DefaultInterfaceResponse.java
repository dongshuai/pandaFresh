package com.pf.app.api.proxy;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefaultInterfaceResponse extends HashMap<String, Object> implements InterfaceResponse {
    private static final long serialVersionUID = 6910216446826972058L;

    public DefaultInterfaceResponse() {
    }

    public DefaultInterfaceResponse success() {
        return this.code(1000);
    }

    public DefaultInterfaceResponse success(int code) {
        return this.code(code);
    }

    public DefaultInterfaceResponse code(int code) {
        this.setCode(code);
        this.setMsg(CodeUtil.getText(code));
        return this;
    }

    public DefaultInterfaceResponse error() {
        if (this.getCode() == 0) {
            this.code(2304);
        }

        return this;
    }

    public DefaultInterfaceResponse error(int code) {
        return this.code(code);
    }

    public DefaultInterfaceResponse error(String messageFormat, Object... obj) {
        this.error();
        return this.message(messageFormat, obj);
    }

    public DefaultInterfaceResponse error(int code, String messageFormat, Object... obj) {
        this.code(code);
        return this.message(messageFormat, obj);
    }

    public DefaultInterfaceResponse add(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("key is null !");
        } else if (StringUtils.equalsIgnoreCase(key, "code")) {
            throw new IllegalArgumentException("[code] is reserved !");
        } else if (StringUtils.equalsIgnoreCase(key, "msg")) {
            throw new IllegalArgumentException("[msg] is reserved !");
        } else if (StringUtils.equalsIgnoreCase(key, "values")) {
            throw new IllegalArgumentException("[values] is reserved !");
        } else {
            super.put(key, value);
            return this;
        }
    }

    public DefaultInterfaceResponse message(String formatMessage, Object... obj) {
        return this.addMessage(formatMessage, obj);
    }

    public DefaultInterfaceResponse addMessage(String format, Object... obj) {
        if (StringUtils.isBlank(format)) {
            return this;
        } else if (obj == null) {
            this.addValue(format);
            return this;
        } else if (obj.length == 1) {
            this.addValue(StringUtils.replace(format, "{}", obj[0] == null ? "null" : obj[0].toString()));
            return this;
        } else {
            int i = 0;

            while (true) {
                int search = StringUtils.indexOf(format, "{}");
                String msg;
                if (search == -1) {
                    String[] var7 = new String[obj.length];
                    String[] var8 = new String[obj.length];

                    for (int var9 = 0; var9 < obj.length; ++var9) {
                        var7[var9] = "{" + var9 + "}";
                        var8[var9] = obj[var9] == null ? "null" : obj[var9].toString();
                    }

                    msg = StringUtils.replaceEach(format, var7, var8);
                    this.addValue(msg);
                    if (StringUtils.isBlank(this.getMsg())) {
                        this.setMsg(msg);
                    }

                    return this;
                }

                String replace = StringUtils.substring(format, 0, search + 1);
                msg = StringUtils.substring(format, search + 1);
                format = replace + i++ + msg;
            }
        }
    }

    public int getCode() {
        Object _code = this.get("code");
        return _code == null ? 0 : Integer.parseInt(_code.toString());
    }

    public void setCode(int code) {
        super.put("code", Integer.valueOf(code));
    }

    public String getMsg() {
        Object _msg = this.get("msg");
        return _msg == null ? null : _msg.toString();
    }

    public void setMsg(String msg) {
        super.put("msg", msg);
    }

    public List<Object> getValues() {
        Object _values = this.get("values");
        return (List) (_values == null ? new ArrayList() : (List) _values);
    }

    public void setValues(List<Object> values) {
        super.put("values", values);
    }

    public void addValue(Object obj) {
        List values = this.getValues();
        values.add(obj);
        this.setValues(values);
    }

    public <T> T getData() {
        return (T) this.get("data");
    }

    public int getCount() {
        Object obj = this.get("count");
        return obj == null ? 0 : Integer.parseInt(obj.toString());
    }
}
