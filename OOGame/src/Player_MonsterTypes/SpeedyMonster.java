package Player_MonsterTypes;

import java.awt.Color;

import BaseGame.Cell;
import BaseGame.Grid;
import Users_Save_Data.Achievement;
import Utilities.Delayer;

public class SpeedyMonster extends Monster{

	public SpeedyMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col);
		
		gridColor = Color.green;
		name = "speedyMonster";
		reward = new Achievement("Super Sonic - Defeat Speedy Monster", 2);
	}

	@Override
	public boolean monsterMovement(Player player) {
		Boolean breakLoop = false;
		
		   Cell newMonsterCell = this.move();
	       if (newMonsterCell == player.getCell())
	       	breakLoop = true;
	       
	       Delayer.delay(150);
	       bp.repaint();
	       
	       newMonsterCell = this.move();
	       if (newMonsterCell == player.getCell())
	       	breakLoop = true;
	       
	       Delayer.delay(150);
	       bp.repaint();
	       
	       return breakLoop;
	}

}
