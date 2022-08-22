package com.yw.home.BankMembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yw.home.bankaccount.BankAccountDAO;
import com.yw.home.bankaccount.BankAccountDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankAccountDAO bankAccountDAO;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.setJoin(bankMembersDTO);
	}

	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}

	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		map.put("list", ar);
		map.put("dto", bankMembersDTO);
		
		return map;
	}
	
}
