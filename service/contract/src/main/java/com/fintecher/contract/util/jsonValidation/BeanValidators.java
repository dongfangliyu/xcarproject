package com.fintecher.contract.util.jsonValidation;


import com.fintecher.contract.util.ContractCode;
import com.fintecher.contract.vo.JsonModel;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

public class BeanValidators {  
	
	private Logger logger = LoggerFactory.getLogger(BeanValidators.class);
	
	/** 
     * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException, 而不是返回constraintViolations. 
     */  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void validateWithException(JSONObject jsonFrom, Class clazzTo , Class<?>... groups)
            throws ConstraintViolationException {
    	Object objTemp = JSONObject.toBean(jsonFrom, clazzTo);
    	
    	Validator validator = Validation.buildDefaultValidatorFactory()
	            .getValidator();
        Set constraintViolations = validator.validate(objTemp, groups);
        if (!constraintViolations.isEmpty()) {
//            throw new ConstraintViolationException(constraintViolations);
        	String jsonMsg = JsonUtil.map2json(BeanValidators.extractPropertyAndMessage(constraintViolations));
//        	throw new BusinessException(jsonMsg);
        }
    }
	
	/** 
     * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException, 而不是返回constraintViolations. 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void validateWithException(Object object, Class<?>... groups)
            throws ConstraintViolationException {
    	Validator validator = Validation.buildDefaultValidatorFactory()
	            .getValidator();
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
//            throw new ConstraintViolationException(constraintViolations);
            String jsonMsg = JsonUtil.map2json(BeanValidators.extractPropertyAndMessage(constraintViolations));
//        	throw new WebApplicationException(jsonMsg,Response.status(Status.BAD_REQUEST).entity(jsonMsg).build());
//        	throw new WebApplicationException(jsonMsg,Response.status(Status.BAD_REQUEST).build());
//        	throw new BusinessException(jsonMsg);
        }
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static JsonModel validate(Object object, Class<?>... groups)
            throws ConstraintViolationException {
    	JsonModel jm = new JsonModel();
		jm.setCode(ContractCode.SUCC00002.getCode());
		jm.setInfo(ContractCode.SUCC00002.getInfo());
		
    	Validator validator = Validation.buildDefaultValidatorFactory()
	            .getValidator();
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            String jsonMsg = JsonUtil.map2json(BeanValidators.extractPropertyAndMessage(constraintViolations));
        	jm.setCode(ContractCode.EXCE00001.getCode());
    		jm.setInfo(jsonMsg);
        }
        return jm;
    }
	
    /** 
     * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException, 而不是返回constraintViolations. 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void validateWithException(Validator validator, Object object, Class<?>... groups)
            throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
  
    /** 
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>中为List<message>. 
     */  
    public static List<String> extractMessage(ConstraintViolationException e) {
        return extractMessage(e.getConstraintViolations());  
    }  
  
    /** 
     * 辅助方法, 转换Set<ConstraintViolation>为List<message> 
     */  
    public static List<String> extractMessage(Set<? extends ConstraintViolation> constraintViolations) {
        List<String> errorMessages = new ArrayList<String>();  
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getMessage());  
        }  
        return errorMessages;  
    }  
  
    /** 
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为Map<property, message>. 
     */  
    public static Map<String, String> extractPropertyAndMessage(ConstraintViolationException e) {
        return extractPropertyAndMessage(e.getConstraintViolations());  
    }  
  
    /** 
     * 辅助方法, 转换Set<ConstraintViolation>为Map<property, message>. 
     */  
    public static Map<String, String> extractPropertyAndMessage(Set<? extends ConstraintViolation> constraintViolations) {
        Map<String, String> errorMessages = new HashMap<String, String>();  
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.put(violation.getPropertyPath().toString(), violation.getPropertyPath().toString()+"-"+violation.getMessage());  
        }  
        return errorMessages;
    }  
  
    /** 
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<propertyPath message>. 
     */  
    public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), " ");  
    }  
  
    /** 
     * 辅助方法, 转换Set<ConstraintViolations>为List<propertyPath message>. 
     */  
    public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations) {
        return extractPropertyAndMessageAsList(constraintViolations, " ");  
    }  
  
    /** 
     * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<propertyPath + separator + message>. 
     */  
    public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);  
    }  
  
    /** 
     * 辅助方法, 转换Set<ConstraintViolation>为List<propertyPath + separator + message>. 
     */  
    public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations,
            String separator) {  
        List<String> errorMessages = new ArrayList<String>();  
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getPropertyPath() + separator + violation.getMessage());  
        }  
        return errorMessages;  
    }  
}