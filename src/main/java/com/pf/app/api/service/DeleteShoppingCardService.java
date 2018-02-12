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
public class DeleteShoppingCardService extends AbstractService<ShoppingCardVo> {
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(DeleteShoppingCardService.class);

    /**
     * 购物车mapper
     */
    @Resource
    private PfShoppingCartMapper pfShoppingCartMapper;
    @Override
    public InterfaceResponse check(ShoppingCardVo vo) {

        if (vo.getGoodsId() == null){
            return error(1810,"商品id不能为空");
        }
        return null;
    }

    @Override
    public InterfaceResponse executor(ShoppingCardVo vo) {

        PfShoppingCart pfShoppingCart = new PfShoppingCart();
        pfShoppingCart.setUserId(getUserId());
        pfShoppingCart.setGoodsId(vo.getGoodsId());
        pfShoppingCartMapper.delete(pfShoppingCart);
        return success();
    }
}
