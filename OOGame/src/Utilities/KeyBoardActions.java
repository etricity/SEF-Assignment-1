package Utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import BaseGame.Game;

public class KeyBoardActions implements KeyListener{

	private Game game;
	
	public KeyBoardActions(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP)
		{
			game.getMessage().setText("up");
			game.getPlayer().setDirection('U');
		}
		else if(key == KeyEvent.VK_DOWN)
		{
			game.getMessage().setText("down");
			game.getPlayer().setDirection('D');
		}
		else if(key == KeyEvent.VK_LEFT)
		{
			game.getMessage().setText("LEFT");
			game.getPlayer().setDirection('L');
		}
		else if(key == KeyEvent.VK_RIGHT)
		{
			game.getMessage().setText("RIGHT");
			game.getPlayer().setDirection('R');
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
