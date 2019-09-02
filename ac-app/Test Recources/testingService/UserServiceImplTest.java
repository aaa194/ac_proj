package testingService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ac.service.UserServiceImpl;


public class UserServiceImplTest {
	

	@Test
	public void testGetUsers() {
		
		UserServiceImpl tester = new UserServiceImpl();
		assertNotNull("asdd" ,tester.getUsers());
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
