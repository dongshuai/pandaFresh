package com.pf.app.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfUserAddrMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfUserAddr;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.AddrListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@ReadOnly
public class AddrListService extends AbstractService<AddrListVo> {

    private static final Logger logger = LoggerFactory.getLogger(AddrListService.class);
    /**
     * 收货地址mapper
     */
    @Resource
    private PfUserAddrMapper pfUserAddrMapper;
    @Override
    public InterfaceResponse check(AddrListVo vo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(AddrListVo vo) {
        Example example = new Example(PfUserAddr.class);
        example.createCriteria().andEqualTo("userId",getUserId());
        example.orderBy("defaultFlag").desc().orderBy("id").desc();
        Page<PfGoods> page = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPage(() -> pfUserAddrMapper.selectByExample(example));

        return success(page);
    }
}
