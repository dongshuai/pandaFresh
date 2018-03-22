package com.pf.app.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.pf.app.api.util.Constant;
import com.pf.app.api.util.JsonUtils;
import com.pf.app.api.util.JwtUtil;
import com.pf.app.api.util.VerificationExpUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义拦截器1
 *
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年1月7日
 */
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        if (StringUtils.isEmpty(token)) {
            response.getWriter().write(errorMsg());
            return false;
        }
        Claims claims = JwtUtil.parseJWT(token);
        if (null == claims) {
            logger.debug("claims 为空");
            response.getWriter().write(errorMsg());
            return false;
        }
        String str = claims.getSubject();
        Map<String, Object> tt = JSONObject.parseObject(str, Map.class);
        Long uid = (Long)tt.get(Constant.ID_COLUMN);
        Date expTime = new Date(new Long(tt.get(Constant.NEW_TIMES).toString()));

        if (VerificationExpUtil.isExp(expTime)) {
            logger.debug("token超时");
            response.getWriter().write(errorMsg());
            return false;
        }

        String uname = (String)tt.get(Constant.NAME_COLUMN);

        request.setAttribute(Constant.USER_ID, uid);

        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

    private String errorMsg() {
        Map<String, Object> result = new HashMap<>(5);
        result.put("code", Constant.RESCODE_NOAUTH);
        result.put("msg", "登录过期，请重新登录!");
        String ss = JsonUtils.toJSONString(result);
        return ss;
    }

}