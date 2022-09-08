package com.yw.home.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yw.home.board.impl.CommentDTO;
import com.yw.home.util.CommentPager;

@Service
public class BankBookService {
	
	//--------------------- Comment -------------------------------------------
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception{
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	// ------------------------------------------------------------------------
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBook(bankBookDTO);
	}
	

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	

	public List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int deleteBook(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.deleteBook(bankBookDTO);
	}
}
