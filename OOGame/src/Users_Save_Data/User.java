package Users_Save_Data;

public class User {
	
	private String userName;
	private char[] password;
	private Achievement[] achievements;
	private Save[] saves;
	
	public User(String userName, char[] password)
	{
		this.userName = userName; 
		this.password = password;
	}
	
	//Getters & Setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public Achievement[] getAchievements() {
		return achievements;
	}
	public void setAchievements(Achievement[] achievements) {
		this.achievements = achievements;
	}
	public Save[] getSaves() {
		return saves;
	}
	public void setSaves(Save[] saves) {
		this.saves = saves;
	}  
	
	

}
