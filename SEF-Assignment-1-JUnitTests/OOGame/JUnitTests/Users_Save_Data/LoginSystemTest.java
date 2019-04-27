package Users_Save_Data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BaseGame.Game;

public class LoginSystemTest {

	Game game;
	LoginSystem ls;
	
	@Before
	public  void setUpBeforeClass() throws Exception {
		
		game = new Game();
		ls = new LoginSystem(game);
	}


	@Test
	public void testEmptyUsernamePassword() {
		assertFalse(ls.signUp("", "password"));
		assertFalse(ls.signUp("username", ""));
	}
	
	@Test
	public void testUserAlreadyInSystem() {
		
		assertTrue(ls.signUp("username", "password"));
		assertFalse(ls.signUp("username", "random_password"));
	}
	
	@Test
	public void testIncorrectUsername()
	{
		ls.signUp("clark", "kent");
		assertFalse(ls.logIn("superman", "kent"));
	}
	
	@Test
	public void testIncorrectPassword()
	{
		ls.signUp("clark", "kent");
		assertFalse(ls.logIn("clark", "superman"));
	}
}
