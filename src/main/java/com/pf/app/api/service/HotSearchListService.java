package com.pf.app.api.service;

import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfHotSearchMapper;
import com.pf.app.api.model.PfHotSearch;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.HotSearchVo;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service
@ReadOnly
public class HotSearchListService extends AbstractService<HotSearchVo> {

    private static final Logger logger = LoggerFactory.getLogger(HotSearchListService.class);

    @Resource
    private PfHotSearchMapper pfHotSearchMapper;
    @Override
    public InterfaceResponse check(HotSearchVo hotSearchVo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(HotSearchVo hotSearchVo) {

        Example example = new Example(PfHotSearch.class);
        example.setOrderByClause("times desc");
        RowBounds rowBounds = new RowBounds(0,10);
        List<PfHotSearch> pfHotSearchList =  pfHotSearchMapper.selectByExampleAndRowBounds(example,rowBounds);
        return success(pfHotSearchList);
    }
}
