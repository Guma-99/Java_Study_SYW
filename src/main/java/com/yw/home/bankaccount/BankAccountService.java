package com.yw.home.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAccount(BankAccountDTO bankAccountDTO) {
		return bankAccountDAO.setAccount(bankAccountDTO);
	}

}
