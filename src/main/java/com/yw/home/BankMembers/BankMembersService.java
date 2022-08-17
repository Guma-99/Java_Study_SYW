package com.yw.home.BankMembers;

import com.yw.home.BankMembers.BankMembersDTO;

public class BankMembersService {
	BankMembersDAO bankMembersDAO = new BankMembersDAO();
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
}
