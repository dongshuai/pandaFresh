package com.pf.app.api.controller;

import com.pf.app.api.exception.OrderException;
import com.pf.app.api.exception.UserAccountException;
import com.pf.app.api.exception.UserVoucherException;
import com.pf.app.api.proxy.DefaultInterfaceResponse;
import com.pf.app.api.proxy.InterfaceResponse;
import com.pf.app.api.proxy.RrpService;
import com.pf.app.api.util.edit.BigDecimalEditor;
import com.pf.app.api.util.edit.IntegerEditor;
import com.pf.app.api.util.edit.LongEditor;
import com.pf.app.api.vo.VO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

;

public class BaseController {

    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        BigDecimalEditor bigDecimalEditor = new BigDecimalEditor();
        binder.registerCustomEditor(BigDecimal.class, bigDecimalEditor);
        binder.registerCustomEditor(Long.class,new LongEditor());
        binder.registerCustomEditor(Integer.class, new IntegerEditor());

    }

    protected InterfaceResponse doResponse( RrpService service,VO vo ){
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
