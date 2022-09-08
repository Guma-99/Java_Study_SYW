import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yw.home.MyAbstractTest;
import com.yw.home.bankbook.BankBookCommentDAO;
import com.yw.home.bankbook.BankBookCommentDTO;
import com.yw.home.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void getCommentListTest() throws Exception {
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(4888L);
		commentPager.setPage(1L);
		commentPager.getRowNum();
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
	}
}
