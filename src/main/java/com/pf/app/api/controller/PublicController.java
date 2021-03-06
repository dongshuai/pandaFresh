package com.pf.app.api.controller;

import com.pf.app.api.annotation.ReadOnly;
import com.pf.app.api.exception.OrderException;
import com.pf.app.api.exception.UserAccountException;
import com.pf.app.api.exception.UserVoucherException;
import com.pf.app.api.proxy.DefaultInterfaceResponse;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.proxy.RrpService;
import com.pf.app.api.service.CategoryListService;
import com.pf.app.api.service.GetVerificationCodeService;
import com.pf.app.api.service.GoodsListService;
import com.pf.app.api.service.HotSearchListService;
import com.pf.app.api.service.LoginService;
import com.pf.app.api.service.ThirdPartyBindService;
import com.pf.app.api.service.ThirdPartyLoginService;
import com.pf.app.api.vo.VO;
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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public")
public class PublicController extends BaseController {

    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(PrivateController.class);
    /**
     * URL处理服务类map
     */
    private Map<String, RrpService> commandMap = new HashMap<>();
    /**
     * 获取验证码
     */
    @Resource
    private GetVerificationCodeService getVerificationCodeService;

    /**
     * 登录和注册接口
     */
    @Resource
    private LoginService loginService;
    /**
     * 热词搜索列表
     */
    @Resource
    private HotSearchListService hotSearchListService;

    /**
     * 商品列表服务类
     */
    @Resource
    private GoodsListService goodsListService;
    /**
     * 商品类别服务类
     */
    @Resource
    private CategoryListService categoryListService;

    /**
     * 第三方登录
     */
    @Resource
    private ThirdPartyLoginService thirdPartyLoginService;
    /**
     * 第三方用户绑定
     */
    @Resource
    private ThirdPartyBindService thirdPartyBindService;

    @PostConstruct
    public void init() {
        commandMap.put("get-code", getVerificationCodeService);//验证码
        commandMap.put("login", loginService);//登录或注册
        commandMap.put("hot-word-list", hotSearchListService);//热门查询前十条
        commandMap.put("goods-list", goodsListService);//商品列表
        commandMap.put("category-list", categoryListService);//分类列表
        commandMap.put("third-party-login",thirdPartyLoginService);//第三方用户登录
        commandMap.put("third-party-bind",thirdPartyBindService);//第三方用户绑定
    }


    @PostMapping("/api/{command}")
    public InterfaceResponse getCode(@PathVariable String command, HttpServletRequest request) {
        RrpService service = commandMap.get(command);
        if (service == null) {
            return new DefaultInterfaceResponse().error(404, "接口不存在");
        }
        VO vo = (VO) service.createVo();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(vo);
        binder.bind(request);
        return doResponse(service, vo);
    }
}
