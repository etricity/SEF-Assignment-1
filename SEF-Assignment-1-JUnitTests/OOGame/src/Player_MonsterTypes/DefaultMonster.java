package Player_MonsterTypes;

import java.awt.Color;

import BaseGame.Cell;
import BaseGame.Grid;
import Users_Save_Data.Achievement;
import Utilities.Delayer;

public class DefaultMonster extends Monster{

	public DefaultMonster(Grid grid, Player p, int row, int col) throws Exception {
		super(grid, p, row, col);
		
		gridColor = Color.BLACK;
		name = "defaultMonster";
		reward = new Achievement("Monster Slayer - Defeat Default Monster", 1);
	}
	
	   public boolean monsterMovement(Player player)
	   {
		   Boolean breakLoop = false;
		   Cell newMonsterCell = this.move();
	       if (newMonsterCell == player.getCell())
	       	breakLoop = true;
	       
	       Delayer.delay(300);
	       bp.repaint();
	       
	       return breakLoop;
	   }

}
