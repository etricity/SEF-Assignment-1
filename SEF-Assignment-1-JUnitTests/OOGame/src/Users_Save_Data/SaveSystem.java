package Users_Save_Data;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

import BaseGame.Game;

public class SaveSystem {
	
	/*Save Syntax
	* userName:password:score1:score2:score3:gotAchievemnt1:gotAchievemnt2:gotAchievement3
	* gotAchivement is boolean (0 is false, 1 is true)
	*/
	
	private Game game;
	
	public SaveSystem(Game game)
	{
		this.game = game;
	}
	
	public void saveData(Collection<User> users)
	{
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(new File("savedData.txt"));
			
			for(User u: users)
			{
				output.write(u.toString() + "\n");
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		output.close();
	}
	
	public void importData(String file) throws FileNotFoundException
	{
		Scanner input = null;
		User user;
			
		input = new Scanner(new FileInputStream(file));
		input.useDelimiter(":");
			while(input.hasNextLine())
			{
				user = new User("", "");
				user.setUsername(input.next());
				user.setPassword(input.next());
				user.updateScore(1, input.nextInt());
				user.updateScore(2, input.nextInt());
				user.updateScore(3, input.nextInt());
				
				String nextToken = input.next();
				if(nextToken.equals("true"))
				{
					user.addAchievement(new Achievement("Monster Slayer - Defeat Default Monster", 1));
				}
				
				nextToken = input.next();
				if(nextToken.equals("true"))
				{
					user.addAchievement(new Achievement("All Seeing Being - Defeat Invisible Monster", 2));
				}
				
				nextToken = input.next();
				if(nextToken.equals("true"))
				{
					user.addAchievement(new Achievement("Super Sonic - Defeat Speedy Monster", 3));
				}
				
				game.addUser(user);	
				input.nextLine();
				
			}
			
		
		input.close();
	}
}
