package com.fintecher.sims.rest;

import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.util.StringEditor;
import com.fintecher.sims.vo.UserModel;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: jwdstef
 * @Description: 基类
 * @Date 2017/5/31
 */
public class BaseController {

    @Autowired
    private ModelMapper modelMapper;

    protected static final String FAILURE = "failure";
    /**
     * 默认页为1
     */
    protected static final Integer PAGENUM = 1;
    protected static final String SUCCESS = "success";
    /**
     * 页码大小10
     */
    protected static final Integer PAGESIZE = 10;
    /**
     * ajax
     * 提示常量
     */
    protected static final String SUCCESS_LOAD_MESSAGE = "加载成功!";
    protected static final String FAILURE_LOAD_MESSAGE = "加载失败!";
    /**
     * 保存
     * 提示常量
     */
    protected static final String SUCCESS_SAVE_MESSAGE = "保存成功!";
    protected static final String FAILURE_SAVE_MESSAGE = "保存失败!";
    /**
     * 更新
     * 提示常量
     */
    protected static final String SUCCESS_UPDATE_MESSAGE = "更新成功!";
    protected static final String FAILURE_UPDATE_MESSAGE = "更新失败!";
    /**
     * 充值
     * 提示常量
     */
    protected static final String SUCCESS_CREDIT_MESSAGE = "充值成功!";
    protected static final String FAILURE_CREDIT_MESSAGE = "充值失败!";
    /**
     * 删除
     * 提示常量
     */
    static final String SUCCESS_DELETE_MESSAGE = "删除成功!";
    static final String FAILURE_DELETE_MESSAGE = "删除失败!";
    protected static final String WARNING_DELETE_MESSAGE = "已经删除!";
    /**
     * 禁用启用
     */
    protected static final String SUCCESS_ENABLE_TRUE = "启用成功!";
    protected static final String SUCCESS_ENABLE_FALSE = "禁用成功!";

    static final String NOT_LOGIN = "用户未登录，请重新登录";

    protected final transient Log log = LogFactory.get(this.getClass());
    @Autowired
    public RestTemplate restTemplate;

    public static String getSession(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        Object obj = request.getSession().getAttribute(key);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static void setSession(String key, Object value) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        request.getSession().setAttribute(key, value);
    }

    public static void removeSession(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        request.getSession().removeAttribute(key);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.registerCustomEditor(String.class, "password", new StringEditor(true));
    }

    UserModel getUserByToken(String token) {
        try {
            Map map = (Map) restTemplate.getForObject("http://service-manage/user/getUserByToken?authorization=" + token, Map.class).get("object");
            LinkedHashMap linkedHashMap = (LinkedHashMap) map.get("user");
            return modelMapper.map(linkedHashMap, UserModel.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralException(NOT_LOGIN);
        }
    }
}
