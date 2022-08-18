package com.yw.home.bankaccount;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAO {

		@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE="com.yw.home.bankaccount.BankAccountDAO.";
		
		public int setAccount(BankAccountDTO bankAccountDTO) {
			return sqlSession.insert(NAMESPACE+"setAccount", bankAccountDTO);
		}
}
