package com.yw.home.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value="/bankaccount/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService service;
	
	@RequestMapping (value="add.do", method=RequestMethod.GET)
	public void setAccount() {
		System.out.println("AccountGet");

	}
	
	@RequestMapping (value="add.do", method=RequestMethod.POST)
	public ModelAndView setAccount(BankAccountDTO bankAccountDTO) {
		System.out.println("AccountPOST");
		ModelAndView modelAndView = new ModelAndView();
		int result = service.setAccount(bankAccountDTO);
		if(result>0) {
			System.out.println("추가 성공");
			modelAndView.setViewName("redirect:../");
			return modelAndView;
		} else {
			return modelAndView;
		}
	}
	
	

}
