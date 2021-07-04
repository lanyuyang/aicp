package com.iflytek.tr.nlp.common.handler;


import com.iflytek.tr.nlp.common.contants.ErrorCode;
import com.iflytek.tr.nlp.common.dto.Result;
import com.iflytek.tr.nlp.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
	

	/**
	 * BaseException异常报错
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = BaseException.class)
	public Object baseExceptionHandler(HttpServletRequest request, Exception exception) {
		return Result.fail(((BaseException) exception).getErrorCode(), exception.getMessage(), ((BaseException) exception).isSuccess());
	}
	
	/**
	 * Exception 异常捕获
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = BindException.class)
	public Object bindExceptionHandler(HttpServletRequest request, Exception ex) {
//		log.error("BindException",ex);
		StringBuffer result = new StringBuffer();
        BindException bindException = (BindException) ex;
        for (FieldError fieldErro : bindException.getBindingResult().getFieldErrors()) {
        	result.append("[").append(fieldErro.getDefaultMessage()).append("]");
        }
        return Result.fail(result.toString());
       
	}
	
	/**
	 * Exception 异常捕获
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Object methodArgumentNotValidExceptionHandler(HttpServletRequest request, Exception ex) {
//		log.error("MethodArgumentNotValidException",ex);
		StringBuffer result = new StringBuffer();
		MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
        for (FieldError fieldErro : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
        	result.append("[").append(fieldErro.getDefaultMessage()).append("]");
        }
        return Result.fail(result.toString());
	}

	/**
	 * Throwable 异常捕获
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Object allExceptionHandler(HttpServletRequest request, Exception exception) {
//		log.error("Throwable",exception);
		return Result.fail(ErrorCode.EXCEPTION.getCode(), ErrorCode.EXCEPTION.getMsg(), ErrorCode.EXCEPTION.isSuccess());
	}

}