package testingService;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ac.dao.UserDAOImpl;
import com.ac.service.UserServiceImpl;


public class UserServiceImplTest {
	

	@Test
	@Autowired
	public void testGetUsers() {
		
		UserServiceImpl tester = new UserServiceImpl();
		
		UserDAOImpl tester2 = new UserDAOImpl();
		
		assertNotNull("asdd" ,tester2.getUsers());
	}

	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByEmail() {
		fail("Not yet implemented");
	}

}
