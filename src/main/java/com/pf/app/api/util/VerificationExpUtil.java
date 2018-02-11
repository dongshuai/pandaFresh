package com.pf.app.api.util;

import java.util.Date;

public class VerificationExpUtil {

    public static Boolean isExp(Date expDate){
        long now = new Date().getTime();
        return now >= expDate.getTime();
    }
}
