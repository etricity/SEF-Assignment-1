package Player_MonsterTypes;
/* This class encapsulates Monster position and direction
 * It also keeps a reference to the player it is tracking
 * The canView attribute can be used to limit monster visibility
 */

import java.awt.Color;

import BaseGame.BoardPanel;
import BaseGame.Cell;
import BaseGame.Grid;
import Users_Save_Data.Achievement;

public abstract class Monster extends Moveable {
	protected boolean canView = true;  // allows
	private Player player;
	protected BoardPanel bp;
	
	protected Achievement reward;
	
	public Monster(Grid g, Player p, int row, int col) throws Exception
	{
	   super(g);
	   player = p;
	   setCell(grid.getCell(row,col));
	}
	public Cell move()
	{
		currentDirection = grid.getBestDirection(currentCell, player.getCell());
        currentCell = (grid.getCell(getCell(),getDirection()));
        return currentCell;
	}
	public boolean viewable()  // can be used for hiding
	{
		return canView;
	}
	
	public Achievement getReward()
	{
		return reward;
	}
	
	public void updateMonster(Player player)
	{
		this.player = player;
	}
	
	public abstract boolean monsterMovement(Player player);
	
	   public void setBP(BoardPanel bp)
	   {
		   this.bp = bp; 
	   }
}