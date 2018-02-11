package com.pf.app.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfGoodsMapper;
import com.pf.app.api.mapper.PfHotSearchMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfHotSearch;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.util.IdWorkerFactory;
import com.pf.app.api.vo.GoodsVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@ReadOnly
public class GoodsListService extends AbstractService<GoodsVO> {

    private static final Logger logger = LoggerFactory.getLogger(GoodsListService.class);

    @Resource
    private PfGoodsMapper pfGoodsMapper;
    @Resource
    private PfHotSearchMapper pfHotSearchMapper;


    @Override
    public InterfaceResponse check(GoodsVO vo) {
        if(null != vo.getId()){
            logger.debug("根据主键查询");
            return null;
        }
        if (StringUtils.isBlank(vo.getCity())) {
            return error(2000, "城市不能为空");
        }
        return null;
    }

    @Override
    public InterfaceResponse executor(GoodsVO vo) {

        Long id = vo.getId();
        if(null != id){
            logger.debug("查询单个商品信息");
            PfGoods goods = pfGoodsMapper.selectByPrimaryKey(id);
            List<PfGoods> pfGoodsList = new ArrayList<>(1);
            if(null != goods){
                pfGoodsList.add(goods);
            }
            return success(pfGoodsList);
        }

        logger.info("查询商品列表开始");
        Example example = new Example(PfGoods.class);
        Example.Criteria criteria = example.createCriteria();
        String name = vo.getName();
        Long categoryId = vo.getCategoryId();
        if (StringUtils.isNotBlank(name)) {
            logger.debug("通过商品名称查询商品");
            criteria.andLike("name", "%" + name.trim() + "%");
            PfHotSearch pfHotSearch = new PfHotSearch();
            pfHotSearch.setWord(name);
            PfHotSearch hs = pfHotSearchMapper.selectOne(pfHotSearch);
            if (null != hs) {
                logger.debug("搜索词已经存在，更新次数");
                PfHotSearch entity = new PfHotSearch();
                entity.setId(hs.getId());
                entity.setTimes(hs.getTimes() + 1);
                pfHotSearchMapper.updateByPrimaryKeySelective(entity);
            } else {
                logger.debug("搜索词不存在存在，保存搜索词");
                pfHotSearch.setTimes(1);
                pfHotSearch.setWord(name);
                pfHotSearch.setId(IdWorkerFactory.getIdWorker().nextId());
                pfHotSearchMapper.insert(pfHotSearch);
            }
        }
        if (null != categoryId) {
            criteria.andEqualTo("categoryId", categoryId);
        }
        criteria.andEqualTo("city", vo.getCity().trim());

        Page<PfGoods> page = PageHelper.startPage(vo.getPageNum(), vo.getPageSize()).doSelectPage(() -> pfGoodsMapper.selectByExample(example));
        logger.info("查询商品列表结束");
        return success(page);


    }
}
