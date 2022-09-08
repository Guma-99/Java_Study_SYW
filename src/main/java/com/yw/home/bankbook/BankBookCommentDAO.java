package com.yw.home.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yw.home.board.impl.CommentDTO;
import com.yw.home.util.CommentPager;

@Repository
public class BankBookCommentDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.yw.home.bankbook.BankBookCommentDAO.";
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setCommentUpdate", bankBookCommentDTO);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setCommentDelete", bankBookCommentDTO);
	}
	
	public Long getCommentListTotalCount(CommentPager commentPager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCommentListTotalCount", commentPager);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
	}
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);
	}
}
