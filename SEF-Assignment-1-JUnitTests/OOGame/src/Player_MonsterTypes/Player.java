package Player_MonsterTypes;


import BaseGame.BoardPanel;
import BaseGame.Cell;
import BaseGame.Grid;

/*  This class encapsulates player position and direction  
 */
public abstract class Player extends Moveable {
   private boolean readyToStart = false;
   protected BoardPanel bp;
   
   public Player(Grid g, int row, int col) throws Exception
   {
	   super(g);
	   currentCell = grid.getCell(row, col);   
	   currentDirection = ' ';
   }
   public Cell move()
   {
       currentCell = grid.getCell(currentCell,currentDirection);	          
       return currentCell;

   }
   public int maxCellsPerMove()
   {
	   return 1;
   }
   public  int pointsRemaining()
   {
	   return -1;  // not implemented
   }
   public void setReady(boolean val)
   {
	   readyToStart = val;
   }
   public boolean isReady()
   {   return readyToStart;
   }
   
   public abstract boolean playerMovement(Monster monster);
   
   public void setBP(BoardPanel bp)
   {
	   this.bp = bp; 
   }
   
}