package Player_MonsterTypes;

import java.awt.Color;

import BaseGame.Cell;
import BaseGame.Grid;
import Utilities.Delayer;

public class DefaultPlayer extends Player{

	public DefaultPlayer(Grid grid, int row, int col) throws Exception {
		super(grid, row, col);
		gridColor = Color.red;
		   name = "defaultPlayer";
	}
	
	   public boolean playerMovement(Monster monster)
	   {
		   Boolean breakLoop = false;
			 Cell newPlayerCell = this.move();
	         if (newPlayerCell == monster.getCell())
	        	breakLoop = true;
	         this.setDirection(' ');   // reset to no direction 
	         
	         Delayer.delay(300);
	         bp.repaint();
	          
	          return breakLoop;
	   }
}
