package Users_Save_Data;

public class User {
	
	private String userName;
	private String password;
	private Achievement[] achievements = {null, null, null};
	private Save[] saves;
	
	public User(String userName, String password)
	{
		this.userName = userName; 
		this.password = password;
	}
	
	//Getters & Setters
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Achievement[] getAchievements() {
		return achievements;
	}

	public Save[] getSaves() {
		return saves;
	}

	public void updateAchievement(Achievement achievement)
	{
		switch(achievement.getDifficulty())
		{
			case 1: 
			{
				achievements[0] = achievement;
			}
			case 2: 
			{
				achievements[1] = achievement;
			}
			case 3: 
			{
				achievements[3] = achievement;
			}
		}
	}
	
	

}
