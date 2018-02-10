package com.pf.app.api.controller;

import com.pf.app.api.exception.OrderException;
import com.pf.app.api.exception.UserAccountException;
import com.pf.app.api.exception.UserVoucherException;
import com.pf.app.api.proxy.DefaultInterfaceResponse;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.proxy.RrpService;
import com.pf.app.api.service.GetVerificationCodeService;
import com.pf.app.api.service.LoginService;
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
    private static final Logger logger = LoggerFactory.getLogger(DealOrderController.class);
    /**
     *  URL处理服务类map
     */
    private Map<String,RrpService> commandMap = new HashMap<>();
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


    @PostConstruct
    public void init(){
        commandMap.put("get-code",getVerificationCodeService);//验证码
        commandMap.put("login",loginService);//登录或注册

    }


    @PostMapping("/api/{command}")
    public InterfaceResponse getCode(@PathVariable String command, HttpServletRequest request){
        RrpService service = commandMap.get(command);
        service.setRequest(request);
        VO vo = (VO)service.createVo();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(vo);
        binder.bind(request);

        try {
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
        }
    }
}
