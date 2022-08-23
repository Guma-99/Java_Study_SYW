package com.yw.home.board.notice;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yw.home.MyAbstractTest;
import com.yw.home.board.impl.BoardDTO;
import com.yw.home.board.notice.NoticeDAO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		assertEquals(0, ar.size());
	}
	
	@Test
	public void setAddTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Song");
		noticeDTO.setContents("Yong");
		noticeDTO.setWriter("Won");
		
		int result = noticeDAO.setAdd(noticeDTO);
		assertEquals(1, result);
	}

}
