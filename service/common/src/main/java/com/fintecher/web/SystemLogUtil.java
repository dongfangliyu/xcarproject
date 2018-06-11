package com.fintecher.web;


import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author : sunyanping
 * @Description :
 * @Date : 2017/6/27.
 */
public class SystemLogUtil {

    private static final String X_USER_TOKEN = "X-UserToken";
    private final static String EXCEPTION = "exception";

    public static Map<String, Object> saveSystemLog(JoinPoint joinPoint, String type, Throwable e, ThreadLocal<Long> startTime) {
        //sysMap用来存放返回的参数
        Map<String, Object> sysMap = new HashMap<>();
        // 获取到请求的参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取Header中“X-UserToken”的值
//        String token = request.getHeader(X_USER_TOKEN);
//        if (Objects.isNull(token) || StringUtils.isBlank(token)) {
//            return sysMap;
//        }
        // 获取到请求地址
        String remoteAddr = getAddr(request);
        // 请求执行时间
        Long exeTime = System.currentTimeMillis() - startTime.get();
        try {
            String targetName = joinPoint.getTarget().getClass().getName(); // 获取到切入点名称（类全名）
            String methodName = joinPoint.getSignature().getName(); // 方法名
            Object[] arguments = joinPoint.getArgs(); // 方法参数
            Class targetClass = null;
            try {
                targetClass = Class.forName(targetName);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            Method[] methods = targetClass.getMethods(); // 获取到所有公有方法
            String remark = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazz = method.getParameterTypes();
                    if (clazz.length == arguments.length) { // 方法名和参数数量相同认为是同一个方法
                        remark = method.getAnnotation(ApiOperation.class).value();
                        break;
                    }
                }
            }
            if (EXCEPTION.equals(type)) {
                remark += e.getClass().getName() + e.getMessage();
            }
            String method = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
            sysMap.put("type", type);
            sysMap.put("creatTime", new Date());
            sysMap.put("remark", remark);
            sysMap.put("exeTime", exeTime);
            sysMap.put("reqIp", remoteAddr);
            sysMap.put("methods", method);
            sysMap.put("params", Arrays.toString(arguments));
//            sysMap.put("token", token);
            return sysMap;
        } catch (Exception e1) {
            e1.getStackTrace();
        }
        return sysMap;
    }
    private static String getAddr(HttpServletRequest request){
        String ip=request.getHeader("x-forwarded-for");
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
            }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
            }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
            }
        return ip;
        }
}
