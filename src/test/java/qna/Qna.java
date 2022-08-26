package qna;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yw.home.MyAbstractTest;
import com.yw.home.board.qna.QnaDAO;
import com.yw.home.board.qna.QnaDTO;

public class Qna extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;

	@Test
	public void setReply() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("Yong");
		qnaDTO.setContents("Won");
		qnaDTO.setWriter("asdf");
		int result = qnaDAO.setReply(qnaDTO);
		assertEquals(1, result);
	}
}
