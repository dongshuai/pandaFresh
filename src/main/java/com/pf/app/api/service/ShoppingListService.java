package com.pf.app.api.service;


import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.mapper.PfGoodsMapper;
import com.pf.app.api.mapper.PfShoppingCartMapper;
import com.pf.app.api.model.PfGoods;
import com.pf.app.api.model.PfShoppingCart;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.vo.ShopingListVo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@ReadOnly
public class ShoppingListService extends AbstractService<ShopingListVo> {

    @Resource
    private PfShoppingCartMapper pfShoppingCartMapper;
    @Resource
    private PfGoodsMapper pfGoodsMapper;
    @Override
    public InterfaceResponse check(ShopingListVo baseVo) {
        return null;
    }

    @Override
    public InterfaceResponse executor(ShopingListVo baseVo) {
        long userId = getUserId();

        Example pfShoppingCartExample = new Example(PfShoppingCart.class);
        pfShoppingCartExample.createCriteria().andEqualTo("userId",userId);
        pfShoppingCartExample.orderBy("id").asc();

        List<PfShoppingCart> pfShoppingCartList = pfShoppingCartMapper.selectByExample(pfShoppingCartExample);
        List<Long> goodsIdList = new ArrayList<>(10);
        for(PfShoppingCart psc :pfShoppingCartList){
            goodsIdList.add(psc.getGoodsId());
        }

        Example realTimePfGoodExample = new Example(PfGoods.class);
        realTimePfGoodExample.createCriteria().andIn("id",goodsIdList).andEqualTo("deliveryType",new Byte("1"));
        List<PfGoods> realTimeGoodsList = pfGoodsMapper.selectByExample(realTimePfGoodExample);

        List<PfGoods> realTimeGoodsSortList = new ArrayList(5);
        List<PfGoods> preSaleGoodsSortList = new ArrayList(5);
        for(Long  goodId:goodsIdList){
            for(PfGoods pfGoods : realTimeGoodsList){
                if(goodId.compareTo(pfGoods.getId())==0 ){
                    realTimeGoodsSortList.add(pfGoods);
                }
            }

        }

        Example preSalePfGoodExample = new Example(PfGoods.class);
        preSalePfGoodExample.createCriteria().andIn("id",goodsIdList).andEqualTo("deliveryType",new Byte("2"));
        List<PfGoods> preSaleGoodsList = pfGoodsMapper.selectByExample(preSalePfGoodExample);

        for(Long  goodId:goodsIdList){
            for(PfGoods pfGoods : preSaleGoodsList){
                if(goodId.compareTo(pfGoods.getId())==0 ){
                    preSaleGoodsSortList.add(pfGoods);
                }
            }

        }
        Map<String,List<PfGoods>> shoppingCard = new HashMap<>(2);
        shoppingCard.put("realTimeGoodsSortList",realTimeGoodsSortList);
        shoppingCard.put("preSaleGoodsSortList",preSaleGoodsSortList);
        return success(shoppingCard);
    }
}
