package Player_MonsterTypes;

import java.awt.Color;

import BaseGame.Cell;
import BaseGame.Grid;
import Utilities.Delayer;

public class FreezePlayer extends Player {

	public FreezePlayer(Grid g, int row, int col) throws Exception {
		super(g, row, col);
		gridColor = Color.blue;
		name = "freezePlayer";
	}

	@Override
	public boolean playerMovement(Monster monster) {
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
