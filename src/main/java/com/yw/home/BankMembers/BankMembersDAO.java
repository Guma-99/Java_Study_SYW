package com.yw.home.BankMembers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.yw.home.BankMembers.BankMembersDTO;

public class BankMembersDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gm.start.bankMembers.BankMembersDAO.";

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getLogin", bankMembersDTO);

	}

}
