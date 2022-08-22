package bankAccount;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yw.home.MyAbstractTest;
import com.yw.home.BankMembers.BankMembersDTO;
import com.yw.home.bankaccount.BankAccountDAO;
import com.yw.home.bankaccount.BankAccountDTO;

public class BankAccountDAOTest extends MyAbstractTest {
	@Autowired
	private BankAccountDAO bankAccountDAO;

	@Test
	public void getListTest() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("id1");
		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		assertNotEquals(0, ar.size());
	}
}
