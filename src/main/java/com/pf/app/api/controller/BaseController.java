package com.pf.app.api.controller;

import com.pf.app.api.util.edit.BigDecimalEditor;
import com.pf.app.api.util.edit.IntegerEditor;
import com.pf.app.api.util.edit.LongEditor;
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
}
