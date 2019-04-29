package Users_Save_Data;

import java.util.HashMap;

public class User {
	
	private String userName;
	private String password;
	private Achievement[] achievements = {null, null, null};
	private Score[] scores = {new Score(0,1), new Score(0,2), new Score(0,3)};
	
	public User(String userName, String password)
	{
		this.userName = userName; 
		this.password = password;
	}
	
	//Getters & Setters
	public String getUserName() {
		return userName;
	}
	public void setUsername(String username)
	{
		this.userName = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public Achievement[] getAchievements() {
		return achievements;
	}
	public void addAchievement(Achievement achievement)
	{
		achievements[achievement.getDifficulty() - 1] = achievement;
	}
	
	public Score[] getScores() {
		return scores;
	}
	
	public void updateScore(int difficulty, int score)
	{
		if(score > scores[difficulty - 1].getValue())
		{
			scores[difficulty - 1].setValue(score);
		}
	}


	public String toString()
	{
		// userName:password:score1:score2:score3:gotAchievemnt1:gotAchievemnt2:gotAchievement3
		return userName + ":" + password + ":" + userScoresToString() + userAchievementsToString() + ":";
	}

	public String userScoresToString()
	{	
		return scores[0].getValue() + ":" + scores[1].getValue() + ":" + scores[2].getValue();
	}
	
	public String userAchievementsToString()
	{
		String gotAchievements = "";
		for(Achievement ach : achievements)
		{
			if(!(ach == null))
			{
				gotAchievements += ":" + "true";
			}
			else
			{
				gotAchievements += ":" + "false";
			}
		}
		return gotAchievements;
	}

}
