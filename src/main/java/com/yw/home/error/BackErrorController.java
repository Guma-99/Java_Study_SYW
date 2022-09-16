package com.yw.home.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice // 예외처리 전문 컨트롤러
public class BackErrorController {
	
	//ExceptionHandler method만 모임
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Null");
		mv.setViewName("errors/error_404");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(Exception e) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("예외처리");
		mv.setViewName("errors/error_404");
		return mv;
	}
	

}
