package BaseGame;

public class Freeze{

	private int freezeTime;
	private static boolean freezeCheck = false;
	
	
	public static void main(String[] args) {
	
		//Need to set up as a DO WHILE method, but still trying to figure out the process of how it will change the monsters movespeed to 0 for 5 ingame ticks
		//e.g. do while freezeCheck = true... monsterMove = 0... for x time... then set freezecheck to false and reset monster speed.
		if (freezeCheck == false) {
			
			Monster.maxCellsPerMove(0);
			freezeCheck = true;
		}
		
		else {
			return 1;
			freezeCheck = false;
			Player.energyCheck = --2;
			
		}
		

	}

}
