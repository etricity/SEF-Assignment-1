package Player_MonsterTypes;

import java.awt.Color;
import java.util.Random;

import BaseGame.Cell;
import BaseGame.Grid;
import Users_Save_Data.Achievement;
import Utilities.Delayer;

public class InvisibleMonster extends Monster {

	public InvisibleMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col);
		
		gridColor = Color.MAGENTA;
		name = "invisibleMonster";
		reward = new Achievement("All Seeing Being - Defeat Invisible Monster", 3);
	}

	@Override
	public boolean monsterMovement(Player player) {
		Boolean breakLoop = false;
		   Cell newMonsterCell = this.move();
	       if (newMonsterCell == player.getCell())
	       	breakLoop = true;
	       
        if(grid.distance(player.currentCell, this.currentCell) > 2)
        {
        	canView = false;
        }
        else
        {
        	canView = true;
        }
        
        Delayer.delay(300);
        bp.repaint();
         
         return breakLoop;
	}
	

}
