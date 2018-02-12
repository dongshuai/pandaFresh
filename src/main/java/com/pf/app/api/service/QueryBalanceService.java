package com.pf.app.api.service;

import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfUserBalanceMapper;
import com.pf.app.api.model.PfUserBalance;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.BalanceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
@ReadOnly
public class QueryBalanceService extends AbstractService<BalanceVo> {

    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(QueryBalanceService.class);

    /**
     * 用户账户mapper
     */
    @Resource
    private PfUserBalanceMapper pfUserBalanceMapper;
    @Override
    public InterfaceResponse check(BalanceVo balanceVo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(BalanceVo balanceVo) {
        logger.info("查询用户账户开始");
        long userId = getUserId();
        PfUserBalance pfUserBalance = pfUserBalanceMapper.selectByPrimaryKey(userId);
        logger.info("查询用户账户结束");
        return success(pfUserBalance);
    }
}
