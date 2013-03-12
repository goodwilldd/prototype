package kr.pe.goodwilldd.core.controller;

import javax.servlet.http.HttpServletResponse;

import kr.pe.goodwilldd.core.exception.InsoftExceptionResolver;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Exception 처리 로직은 구상 중.
 * 
 * @author sylee
 *
 */
public interface CoreController {

	@ExceptionHandler(InsoftExceptionResolver.class)
	public @ResponseBody String handleException(Exception e, HttpServletResponse response);
}
