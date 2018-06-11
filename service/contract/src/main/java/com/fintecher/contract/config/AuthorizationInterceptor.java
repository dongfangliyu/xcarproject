package com.fintecher.contract.config;

import com.fintecher.contract.config.annotation.Authorization;
import com.fintecher.contract.config.auth.TokenManager;
import com.fintecher.contract.config.auth.TokenModel;
import com.fintecher.contract.util.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: jwdstef
 * @Description: 自定义拦截器，判断此次请求是否有权限
 * @Date 2017/5/31
 */
@Component("authorizationInterceptor")
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private TokenManager tokenManager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //从header中得到token
        String authorization = request.getHeader(Constant.AUTHORIZATION);
        //验证token
        TokenModel model = tokenManager.getToken(authorization);
        if (tokenManager.checkToken(model)) {
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            request.setAttribute(Constant.CURRENT_USER_ID, model.getUserId());
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(Authorization.class) != null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
    }
}
