package com.yw.home.bankaccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yw.home.BankMembers.BankMembersDTO;

@Repository
public class BankAccountDAO {

		@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE="com.yw.home.bankaccount.BankAccountDAO.";
		
		public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception{
			return sqlSession.selectList(NAMESPACE + "getListByUserName", bankMembersDTO);
		}
		
		public int setAccount(BankAccountDTO bankAccountDTO) {
			return sqlSession.insert(NAMESPACE + "setAccount", bankAccountDTO);
		}
}
