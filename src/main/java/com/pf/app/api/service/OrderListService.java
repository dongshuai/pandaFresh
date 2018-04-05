package com.pf.app.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfOrderMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.OrderListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@ReadOnly
public class OrderListService extends AbstractService<OrderListVo>{
    private static final Logger logger = LoggerFactory.getLogger(OrderListService.class);

    @Resource
    private PfOrderMapper pfOrderMapper;
    @Override
    public InterfaceResponse check(OrderListVo vo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(OrderListVo vo) {

        logger.info("查询订单开始,订单列表状态:{}",vo);

        Long userId = getUserId();
        Integer status = vo.getStatus();
        Page<PfGoods> page = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPage(() -> pfOrderMapper.selectOderList(vo.getStatus()));
        return success(page);
    }
}
