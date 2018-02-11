package com.pf.app.api.controller;


import com.pf.app.api.exception.OrderException;
import com.pf.app.api.exception.UserAccountException;
import com.pf.app.api.exception.UserVoucherException;
import com.pf.app.api.proxy.DefaultInterfaceResponse;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.proxy.RrpService;
import com.pf.app.api.service.HotSearchListService;
import com.pf.app.api.util.Constant;
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
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/private")
public class PrivateController extends BaseController{

    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(PrivateController.class);
    /**
     *  URL处理服务类map
     */
    private Map<String,RrpService> commandMap = new HashMap<>();



    @PostConstruct
    public void init(){


    }

    @PostMapping("/api/{command}")
    public InterfaceResponse buyGold(@PathVariable String command, HttpServletRequest request){
        RrpService service = commandMap.get(command);
        if(service == null){
            return new DefaultInterfaceResponse().error(404, "接口不存在");
        }

        String userId = (String)request.getAttribute(Constant.USER_ID);

        service.setUserId(userId);
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