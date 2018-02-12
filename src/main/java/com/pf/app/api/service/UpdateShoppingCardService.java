package com.pf.app.api.service;

import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfShoppingCartMapper;
import com.pf.app.api.model.PfShoppingCart;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.ShoppingCardVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
@ReadOnly
public class UpdateShoppingCardService extends AbstractService<ShoppingCardVo> {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(UpdateShoppingCardService.class);
    /**
     * 购物车Mapper
     */
    @Resource
    private PfShoppingCartMapper pfShoppingCartMapper;
    @Override
    public InterfaceResponse check(ShoppingCardVo vo) {
        if(vo.getGoodsId() == null){
            return error(1820,"商品id不能为空");
        }
        return null;
    }

    @Override
    public InterfaceResponse executor(ShoppingCardVo vo) {

        logger.info("更新购物车商品开始");

        Integer amount = vo.getAmount();
        if( amount == null || amount.compareTo(0) == 0){
            amount = 1;
        }
        PfShoppingCart entity = new PfShoppingCart();
        entity.setAmount(amount);
        Example example = new Example(PfShoppingCart.class);
        example.createCriteria().andEqualTo("userId",getUserId()).andEqualTo("goodsId",vo.getGoodsId());

        pfShoppingCartMapper.updateByExampleSelective(entity,example);
        logger.info("更新购物车商品结束");
        return success();
    }
}
