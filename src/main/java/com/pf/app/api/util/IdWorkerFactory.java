package com.pf.app.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


}

