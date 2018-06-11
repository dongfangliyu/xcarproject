package com.fintecher.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jwdstef
 * @Description: 权限验证过滤器
 * @Date 2017/12/14
 */
public class AuthFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    /**
     * 过滤器类型
     * pre 事前
     * routing 路由请求时候调用
     * error 发生错误时候调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否过来
     * 0 不过滤
     * 1 过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 拦截的具体操作
     * 验证token
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        if (StringUtils.contains(request.getRequestURL().toString(), "/api/companyController")
                || StringUtils.containsIgnoreCase(request.getRequestURL().toString(), "getAllCompany")
                || StringUtils.containsIgnoreCase(request.getRequestURL().toString(), "fileUploadController/view")) {
            return null;
        }
        if (StringUtils.contains(request.getRequestURL().toString(), "login/login")
                || StringUtils.contains(request.getRequestURL().toString(), "login/developLogin")
                || StringUtils.contains(request.getRequestURL().toString(), "swagger")
                || StringUtils.contains(request.getRequestURL().toString(), "api-docs")
                || StringUtils.containsIgnoreCase(request.getRequestURL().toString(), "HashCode")
                || StringUtils.containsIgnoreCase(request.getRequestURL().toString(), "resourceController")
                || StringUtils.containsIgnoreCase(request.getRequestURL().toString(), "dataDictController")) {
            return null;
        }

        //从header中得到token
        String token = request.getHeader("authorization");
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity("http://service-manage/login/checkToken?token=" + token, Boolean.class);
        if (!responseEntity.hasBody()) {
            throw new RuntimeException("token验证异常");
        }
        boolean flag = responseEntity.getBody().booleanValue();
        if (!flag) {
            //认证失败
            logger.error("token验证失败");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            return null;
        }
        logger.info("token验证成功");
        return null;
    }
}
