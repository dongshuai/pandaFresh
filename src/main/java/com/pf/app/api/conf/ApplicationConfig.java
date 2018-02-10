package com.pf.app.api.conf;


import com.pf.app.api.proxy.SelfProxyPostProcessor;
import com.pf.app.api.util.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    @Value("${workerId}")
    private long workerId;
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(workerId);
    }
    @Bean
    public SelfProxyPostProcessor selfProxyPostProcessor(){
        return new SelfProxyPostProcessor();
    }
}
