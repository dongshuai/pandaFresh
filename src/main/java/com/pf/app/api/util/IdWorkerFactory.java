package com.pf.app.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class IdWorkerFactory {
    private static final Logger logger = LoggerFactory.getLogger(IdWorkerFactory.class);

    public static IdWorker idWorker;

    public static IdWorker getIdWorker() {
        return idWorker;
    }

    @Autowired
    public void setIdWorker(IdWorker idWorker) {
        IdWorkerFactory.idWorker = idWorker;
    }

    /**
     * 格式：yyyymmddhhMMssSSS+2位随机
     * @return
     */
    public static long generateyyyymmddhhMMssSSSAnd2Random() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) * 1000000000000000L
                + (c.get(Calendar.MONTH) + 1) * 10000000000000L
                + c.get(Calendar.DAY_OF_MONTH) * 100000000000L
                + c.get(Calendar.HOUR_OF_DAY) * 1000000000L
                + c.get(Calendar.MINUTE) * 10000000L
                + c.get(Calendar.SECOND) * 100000
                + c.get(Calendar.MILLISECOND) * 100
                + (int)(Math.random() * 100);
    }


}

