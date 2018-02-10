package com.pf.app.api.proxy;

import java.util.HashMap;

public class CodeUtil {
    public static final int CODE_NO_ERROR = 1000;
    public static final String TEXT_NO_ERROR = "Command completed successfully";
    public static final int CODE_NO_ERROR_ENDING_SESSION = 1500;
    public static final String TEXT_NO_ERROR_ENDING_SESSION = "Command completed successfully; ending session";
    public static final int CODE_UNKNOWN_COMMAND = 2000;
    public static final String TEXT_UNKNOWN_COMMAND = "Unknown command";
    public static final int CODE_COMMAND_SYNTAX_ERROR = 2001;
    public static final String TEXT_COMMAND_SYNTAX_ERROR = "Command syntax error";
    public static final int CODE_COMMAND_USE_ERROR_NOT_LOGIN = 2002;
    public static final String TEXT_COMMAND_USE_ERROR_NOT_LOGIN = "Command use error; session not login";
    public static final int CODE_COMMAND_USE_ERROR_ALREADY_LOGIN = 2003;
    public static final String TEXT_COMMAND_USE_ERROR_ALREADY_LOGIN = "Command use error; session already login";
    public static final int CODE_PARAMETER_VALUE_SYNTAX_ERROR = 2004;
    public static final String TEXT_PARAMETER_VALUE_SYNTAX_ERROR = "Parameter value syntax error";
    public static final int CODE_AUTHENTICATION_ERROR = 2200;
    public static final String TEXT_AUTHENTICATION_ERROR = "Authentication error";
    public static final int CODE_AUTHORIZATION_ERROR = 2201;
    public static final String TEXT_AUTHORIZATION_ERROR = "Authorization error";
    public static final int CODE_OBJECT_PENDING_TRANSFER = 2300;
    public static final String TEXT_OBJECT_PENDING_TRANSFER = "Object pending transfer";
    public static final int CODE_OBJECT_NOT_PENDING_TRANSFER = 2301;
    public static final String TEXT_OBJECT_NOT_PENDING_TRANSFER = "Object not pending transfer";
    public static final int CODE_OBJECT_EXISTS = 2302;
    public static final String TEXT_OBJECT_EXISTS = "Object exists";
    public static final int CODE_OBJECT_DOES_NOT_EXIST = 2303;
    public static final String TEXT_OBJECT_DOES_NOT_EXIST = "Object does not exist";
    public static final int CODE_OBJECT_STATUS_PROHIBITS_OPERATION = 2304;
    public static final String TEXT_OBJECT_STATUS_PROHIBITS_OPERATION = "Object status prohibits operation";
    public static final int CODE_NO_ENOUGH_FEE = 2305;
    public static final String TEXT_NO_ENOUGH_FEE = "No enough Fee";
    public static final int CODE_PARAMETER_VALUE_POLICY_ERROR = 2306;
    public static final String TEXT_PARAMETER_VALUE_POLICY_ERROR = "Parameter value policy error";
    public static final int CODE_OBJECT_IS_REPETITIVE_OPERATION_IN_24HOUR = 2308;
    public static final String TEXT_OBJECT_IS_REPETITIVE_OPERATION_IN_24HOUR = "Object is repetitive operation in 24hour";
    public static final int CODE_OBJECT_IS_NOT_ELIGIBLE_FOR_TRANSFER = 2307;
    public static final String TEXT_OBJECT_IS_NOT_ELIGIBLE_FOR_TRANSFER = "Object is not eligible for transfer";
    public static final int CODE_COMMAND_FAILED = 2400;
    public static final String TEXT_COMMAND_FAILED = "Command failed";
    public static final int CODE_COMMAND_FAILED_SERVER_CLOSING_CONNECTION = 2500;
    public static final String TEXT_COMMAND_FAILED_SERVER_CLOSING_CONNECTION = "Command failed; server closing connection";
    public static final int CODE_SESSION_LIMIT_EXCEEDED_SERVER_CLOSING_CONNECTION = 2501;
    public static final String TEXT_SESSION_LIMIT_EXCEEDED_SERVER_CLOSING_CONNECTION = "Session limit exceeded; server closing connection";
    public static final int CODE_INDIVIDUAL_REGISTRANT_KEYWORD_LIMITED = 2052;
    //public static final String TEXT_INDIVIDUAL_REGISTRANT_KEYWORD_LIMITED = "The individual registrant who has " + KeywordIndividualService.getIndividualKeywordLimit() + " keywords does not get the new keyword";
    public static final int CODE_INDIVIDUAL_REGISTRANT_ID_NUMBER_LIMITED = 2053;
    public static final String TEXT_INDIVIDUAL_REGISTRANT_ID_NUMBER_LIMITED = "The individual registrant can\'t update the ID number and type";
    public static int RIGHT_SYNTAX = 0;
    private static HashMap codeMap = new HashMap();

    static {
        codeMap.put(new Integer(1000), "Command completed successfully");
        codeMap.put(new Integer(1500), "Command completed successfully; ending session");
        codeMap.put(new Integer(2000), "Unknown command");
        codeMap.put(new Integer(2001), "Command syntax error");
        codeMap.put(new Integer(2002), "Command use error; session not login");
        codeMap.put(new Integer(2003), "Command use error; session already login");
        codeMap.put(new Integer(2004), "Parameter value syntax error");
        codeMap.put(new Integer(2200), "Authentication error");
        codeMap.put(new Integer(2201), "Authorization error");
        codeMap.put(new Integer(2300), "Object pending transfer");
        codeMap.put(new Integer(2301), "Object not pending transfer");
        codeMap.put(new Integer(2302), "Object exists");
        codeMap.put(new Integer(2303), "Object does not exist");
        codeMap.put(new Integer(2304), "Object status prohibits operation");
        codeMap.put(new Integer(2305), "No enough Fee");
        codeMap.put(new Integer(2306), "Parameter value policy error");
        codeMap.put(new Integer(2307), "Object is not eligible for transfer");
        codeMap.put(new Integer(2400), "Command failed");
        codeMap.put(new Integer(2500), "Command failed; server closing connection");
        codeMap.put(new Integer(2501), "Session limit exceeded; server closing connection");
        codeMap.put(new Integer(2501), "Session limit exceeded; server closing connection");
        //codeMap.put(new Integer(2052), TEXT_INDIVIDUAL_REGISTRANT_KEYWORD_LIMITED);
        codeMap.put(new Integer(2053), "The individual registrant can\'t update the ID number and type");
        codeMap.put(new Integer(2308), "Object is repetitive operation in 24hour");
    }

    public CodeUtil() {
    }

    public static String getText(int code) {
        Object object = codeMap.get(new Integer(code));
        return object != null && object instanceof String ? (String) object : null;
    }
}