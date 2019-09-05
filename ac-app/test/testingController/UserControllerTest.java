package testingController;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.ac.controller.UserController;
import com.ac.service.UserServiceImpl;

//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@Autowired
    private UserServiceImpl userService;
	
	@Autowired
    private UserController userController;
    
	private MockMvc mockMvc;
	
	
	@Test
	public void testListUsers() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testShowFormForAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoginUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowFormForUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSignUpPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSignUpUser() {
		fail("Not yet implemented");
	}

}
