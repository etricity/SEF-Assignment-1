package Users_Save_Data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User user = new User("", "");

	@Test
	public void testSetUsername() {	
		user.setUsername("etricity");
		assertEquals(user.getUserName(), "etricity");	
	}

	@Test
	public void testSetPassword() {
		user.setPassword("password");
		assertEquals(user.getPassword(), "password");	
	}

	@Test
	public void testAddAchievement() {
		user.addAchievement(new Achievement("Easy Achievement", 1));
		user.addAchievement(new Achievement("Medium Achievement", 2));
		user.addAchievement(new Achievement("Hard Aachievement", 3));
		assertNotNull(user.getAchievements()[0]);
		assertNotNull(user.getAchievements()[1]);
		assertNotNull(user.getAchievements()[2]);	
	}

	@Test
	public void testUpdateScore() {
		user.updateScore(1, 30);
		user.updateScore(2, 100);
		user.updateScore(3, 457);
		assertEquals(user.getScores()[0].getValue(), 30);
		assertEquals(user.getScores()[1].getValue(), 100);
		assertEquals(user.getScores()[2].getValue(), 457);
	}

}
