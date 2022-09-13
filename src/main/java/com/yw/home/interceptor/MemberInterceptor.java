package com.yw.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yw.home.BankMembers.BankMembersDAO;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private BankMembersDAO membersDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		
		System.out.println(membersDAO);
		
		if(obj != null) {
			System.out.println("로그인 함");
			return true;
		} else {
			System.out.println("로그인 안 함");
			response.sendRedirect("../../../../../member/login.do");
			return false;
		}
		
		
		//return super.preHandle(request, response, handler);
	}
	
}
