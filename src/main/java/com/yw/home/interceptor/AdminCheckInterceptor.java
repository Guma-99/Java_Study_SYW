package com.yw.home.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yw.home.BankMembers.BankMembersDTO;
import com.yw.home.BankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 1. 
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		boolean check = false;
		
		for(RoleDTO roleDTO:bankMembersDTO.getRoleDTOs()) {
			roleDTO.getRoleNum();
			System.out.println(roleDTO.getRoleName());
			
			if(roleDTO.getRoleName().equals("admin")) {
				check = true;
				break;
			}
		}
		
		// 2. admin이 아닐 때
		if(!check) {
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return check; 
	}
}
