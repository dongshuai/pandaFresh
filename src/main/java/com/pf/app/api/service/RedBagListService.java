package com.pf.app.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfUserRedbagRecordMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfUserRedbagRecord;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.RedBagVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@ReadOnly
public class RedBagListService extends AbstractService<RedBagVo> {

    private static final Logger logger = LoggerFactory.getLogger(RedBagListService.class);
    @Resource
    private PfUserRedbagRecordMapper pfUserRedbagRecordMapper;
    @Override
    public InterfaceResponse check(RedBagVo vo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(RedBagVo vo) {

        logger.info("查询用户红包记录开始");
        Example example = new Example(PfUserRedbagRecord.class);
        example.createCriteria().andEqualTo("userId",getUserId());

        Page<PfGoods> page = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPage(() -> pfUserRedbagRecordMapper.selectByExample(example));
        logger.info("查询用户红包记录结束");
        return success(page);
    }
}
