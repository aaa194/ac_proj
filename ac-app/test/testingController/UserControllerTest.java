package testingController;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ac.controller.UserController;
import com.ac.service.UserService;


//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@Autowired
    private UserService userService;
	
	@Autowired
    private UserController userController;
    
	private MockMvc mockMvc;
	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
//	}
	
	@Test
	public void testListUsers() throws Exception {
		MvcResult mock = this.mockMvc.perform(get("/user/list")).andExpect(status().isOk()).andReturn();
		String result = mock.getResponse().getContentAsString();
		assertNotNull(result);
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
