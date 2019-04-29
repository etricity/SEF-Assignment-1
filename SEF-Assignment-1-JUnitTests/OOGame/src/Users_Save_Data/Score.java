package Users_Save_Data;

public class Score {
	
	private int value;
	private int difficulty;
	
	public Score(int value, int difficulty)
	{
		this.value = value;
		this.difficulty = difficulty;
	}
	
	public int getValue()
	{
		return value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public int getDifficulty()
	{
		return difficulty; 
	}

}
