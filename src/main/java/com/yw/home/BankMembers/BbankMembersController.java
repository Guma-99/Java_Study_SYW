package com.yw.home.BankMembers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yw.home.BankMembers.BankMembersService;
import com.yw.home.BankMembers.BankMembersDTO;

public class BbankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;

	@RequestMapping(value = "login.gm", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 Get 실행");

		return "member/login";
	}

	@RequestMapping(value = "login.gm", method = RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("로그인 Post 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);

		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);

		// "Redirect: 다시접속할URL주소(절대경로, 상대경로)"
		return "redirect:../";
	}

	@RequestMapping(value = "logout.gm", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "redirect:../";
	}
}
