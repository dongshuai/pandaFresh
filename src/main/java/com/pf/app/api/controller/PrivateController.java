package com.pf.app.api.controller;


import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.exception.OrderException;
import com.pf.app.api.exception.UserAccountException;
import com.pf.app.api.exception.UserVoucherException;
import com.pf.app.api.proxy.DefaultInterfaceResponse;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.proxy.RrpService;
import com.pf.app.api.service.AddShoppingCardService;
import com.pf.app.api.service.AddUserAddrService;
import com.pf.app.api.service.AddrListService;
import com.pf.app.api.service.DeleteShoppingCardService;
import com.pf.app.api.service.HotSearchListService;
import com.pf.app.api.service.MessageListService;
import com.pf.app.api.service.QueryBalanceService;
import com.pf.app.api.service.RedBagListService;
import com.pf.app.api.service.ShoppingListService;
import com.pf.app.api.service.UpdateShoppingCardService;
import com.pf.app.api.service.VoucherListService;
import com.pf.app.api.util.Constant;
import com.pf.app.api.vo.VO;
import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/private")
public class PrivateController extends BaseController {

    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(PrivateController.class);
    /**
     * URL处理服务类map
     */
    private Map<String, RrpService> commandMap = new HashMap<>();

    /**
     * 消息列表服务
     */
    @Resource
    private MessageListService messageListService;
    /**
     * 新增用户地址
     */
    @Resource
    private AddUserAddrService addUserAddrService;

    /**
     * 用户地址列表
     */
    @Resource
    private AddrListService addrListService;

    /**
     * 购物车
     */
    @Resource
    private ShoppingListService shoppingListService;
    /**
     * 删除购物车商品列表
     */
    @Resource
    private DeleteShoppingCardService deleteShoppingCardService;
    /**
     * 添加购物车商品
     */
    @Resource
    private AddShoppingCardService addShoppingCardService;

    /**
     * 更改购车商品数量
     */
    @Resource
    private UpdateShoppingCardService updateShoppingCardService;
    /**
     * 红包记录列表
     */
    @Resource
    private RedBagListService redBagListService;
    /**
     * 用户查询越信息
     */
    @Resource
    private QueryBalanceService queryBalanceService;

    /**
     * 优惠券列表
     */
    @Resource
    private VoucherListService voucherListService;

    @PostConstruct
    public void init() {
        commandMap.put("msg-list", messageListService);//消息列表
        commandMap.put("add-addr", addUserAddrService);//新增用户地址
        commandMap.put("addr-list", addrListService);//收货地址列表
        commandMap.put("shopping-list", shoppingListService);//购物车商品列表
        commandMap.put("add-shopping-card", addShoppingCardService);//添加商品到购物车
        commandMap.put("delete-shopping-card",deleteShoppingCardService);//删除购物车商品
        commandMap.put("update-shopping-card",updateShoppingCardService);//更改购车商品数量
        commandMap.put("redbag-list",redBagListService);//红包列表
        commandMap.put("query-balance",queryBalanceService);//用户查询余额
        commandMap.put("voucher-list",voucherListService);//优惠券列表
    }

    @PostMapping("/api/{command}")
    public InterfaceResponse buyGold(@PathVariable String command, HttpServletRequest request) {
        RrpService service = commandMap.get(command);
        if (service == null) {
            return new DefaultInterfaceResponse().error(404, "接口不存在");
        }

        Long userId = (Long) request.getAttribute(Constant.USER_ID);

        service.setUserId(userId);
        VO vo = (VO) service.createVo();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(vo);
        binder.bind(request);

        return doResponse(service, vo);

        /*try {
            return service.execute(vo);
        } catch (OrderException e) {
            return new DefaultInterfaceResponse().error(6001, e.getMessage());
        } catch (UserAccountException e) {
            return new DefaultInterfaceResponse().error(1010, e.getMessage());
        } catch (UserVoucherException e){
            return new DefaultInterfaceResponse().error(1020, e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("mainController异常："+e);
            return new DefaultInterfaceResponse().error("system error : [ {} ]", e.getMessage());
        }*/
    }

}
