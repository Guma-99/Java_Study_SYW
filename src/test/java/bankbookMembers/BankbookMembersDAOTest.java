package bankbookMembers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yw.home.MyAbstractTest;
import com.yw.home.BankMembers.BankMembersDAO;
import com.yw.home.BankMembers.BankMembersDTO;

public class BankbookMembersDAOTest extends MyAbstractTest{

	@Autowired
	private BankMembersDAO bankMembersDAO;

	@Test
	public void getMyPageTest() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("id1");
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getEmail());
		assertNotNull(bankMembersDTO);

	}

}
