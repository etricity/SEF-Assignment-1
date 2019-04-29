package Player_MonsterTypes;

import java.awt.Color;

import BaseGame.Cell;
import BaseGame.Grid;
import Utilities.Delayer;

public class SpeedyPlayer extends Player{

	public SpeedyPlayer(Grid g, int row, int col) throws Exception {
		super(g, row, col);
		gridColor = Color.yellow;
		name = "speedyMonster";
		
	}

	@Override
	public boolean playerMovement(Monster monster) {
		 Boolean breakLoop = false;
		 Cell newPlayerCell = this.move();
         if (newPlayerCell == monster.getCell())
        	breakLoop = true;
         this.setDirection(' ');   // reset to no direction 
         
         Delayer.delay(150);
         bp.repaint();
         
         newPlayerCell = this.move();
         if (newPlayerCell == monster.getCell())
        	breakLoop = true;
         this.setDirection(' ');   // reset to no direction 
         
         Delayer.delay(150);
         bp.repaint();
         
          return breakLoop;
	}

}
