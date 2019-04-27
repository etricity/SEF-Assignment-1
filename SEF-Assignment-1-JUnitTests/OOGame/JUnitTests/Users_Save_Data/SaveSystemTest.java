package Users_Save_Data;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

import BaseGame.Game;



public class SaveSystemTest {
	
	Game game;
	SaveSystem ss;
	PrintWriter pw;
	
	@Before
	public void before() throws Exception
	{
		game = new Game();
		ss = new SaveSystem(game);
	}
	
	@After
	//Ensures the JUnitTestFil has the correct data for testSaveData (JUnitTestFile gets altered in testSaveData())
	public void after()
	{
		try {
			pw = new PrintWriter("JUnitTestFile");
			
			pw.write("Isaiah:etricity:0:0:0:false:false:false:\n"
					+ "Clark:superman:0:0:0:false:false:false:\n"
					+ "Bruce:batman:0:0:0:false:false:false:");
			
		} catch (FileNotFoundException e) {
			
		}
		pw.close();
	}
	
	
	@Test
	public void testSaveData() {
		
		//user.ToString = Isaiah:etricity:0:345:0:false:true:false:
		User user = new User("Isaiah", "etricity");
		user.addAchievement(game.getAchievementMedium());
		user.updateScore(2, 345);
		
		//Writes test data to JUnitTestFile
		try {
			pw = new PrintWriter("JUnitTestFile");
			
			pw.write(user.toString());
			
		} catch (FileNotFoundException e) {
			
		}
		pw.close();
		
		//Tests if what was written to JUnitTestFile (user.ToString is correct)
		assertEquals(user.toString(), "Isaiah:etricity:0:345:0:false:true:false:");
	}

	@Test
	public void testImportData() throws Exception {
		ss.importData("JUnitTestFile");
		assertEquals(game.getUser("Isaiah").toString(), "Isaiah:etricity:0:0:0:false:false:false:");
		assertEquals(game.getUser("Clark").toString(), "Clark:superman:0:0:0:false:false:false:");
		assertEquals(game.getUser("Bruce").toString(), "Bruce:batman:0:0:0:false:false:false:");
	}
	//TODO FileNotFound
	
	@Test (expected = FileNotFoundException.class)
	public void testFileNotFound() throws FileNotFoundException 
	{
		ss.importData("FileDoesntExist");
	}
}
