package com.yw.home.bankbook;

import java.util.List;

import com.yw.home.util.CommentPager;

public interface CommentDAO {
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception;

	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception;
}
