package Users_Save_Data;

public class Achievement {
	
	private String description;
	private int difficulty;
	
	public Achievement(String description, int difficulty)
	{
		this.description = description;
		this.difficulty = difficulty;
	}
	
	//Getters

	public String getDescription() {
		return description;
	}

	public int getDifficulty() {
		return difficulty;
	}

}
