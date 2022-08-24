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
	public void getCountTest() throws Exception{
		long count = noticeDAO.getCount();
		assertEquals(303L, count);
	}

	@Test
	public void getListTest() throws Exception {
//		List<BoardDTO> ar = noticeDAO.getList();
//		assertEquals(1, ar.size());
	}

// @Test
	public void setAddTest() throws Exception {

		for (int i = 0; i < 100; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();

			noticeDTO.setTitle("Song" + i);
			noticeDTO.setContents("Yong" + i);
			noticeDTO.setWriter("Won" + i);

			int result = noticeDAO.setAdd(noticeDTO);

			if (i % 10 == 0) {
				Thread.sleep(500);
			}
		}
		System.out.println("finish-!");
	}

}
