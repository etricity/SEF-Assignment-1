package guiElements;

import javax.swing.*;

import BaseGame.Game;
import Player_MonsterTypes.DefaultMonster;
import Player_MonsterTypes.DefaultPlayer;
import Player_MonsterTypes.FreezePlayer;
import Player_MonsterTypes.InvisibleMonster;
import Player_MonsterTypes.SpeedyMonster;
import Player_MonsterTypes.SpeedyPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameModesPanel extends JPanel implements ActionListener{
	
	private Game game;

	
	private JLabel titleLabel = new JLabel("Game Modes");
	private JButton playerType1Button = new JButton("<html>Default<br>Player</html>");
	private JButton playerType2Button = new JButton("<html>Speedy<br>Player</html>");
	private JButton playerType3Button = new JButton("<html>Freeze<br>Player</html>");
	private JButton monsterType1Button = new JButton("<html>Default<br>Monster</html>");
	private JButton monsterType3Button = new JButton("<html>Invisible<br>Monster</html>");
	private JButton monsterType2Button = new JButton("<html>Speedy<br>Monster</html>");
	private JLabel playerSelected = new JLabel("Player Selected: ");
	private JLabel enemySelected = new JLabel("Enemy Selected: ");
	

	public GameModesPanel(Game game)
	{
		this.game = game;
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
		this.add(titleLabel, BorderLayout.NORTH);
		
		Container center = new Container();
		center.setLayout(new GridLayout(2,3, 10, 20));
		center.setVisible(true);
		
		center.add(playerType1Button);
		center.add(playerType2Button);
		center.add(playerType3Button);
		center.add(monsterType1Button);
		center.add(monsterType2Button);
		center.add(monsterType3Button);
		
		this.add(center, BorderLayout.CENTER);
		
		
		
		//TODO ActionListeners
		playerType1Button.addActionListener(this);
		playerType2Button.addActionListener(this);
		playerType3Button.addActionListener(this);
		monsterType1Button.addActionListener(this);
		monsterType2Button.addActionListener(this);
		monsterType3Button.addActionListener(this);
		
		Container south = new Container();
		south.setLayout(new GridLayout(4,1, 10, 10));
		south.setVisible(true);
		
		south.add(playerSelected);
		south.add(enemySelected);
		
		this.add(south, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton source = ((JButton)e.getSource());
		
		if(source.getText().equals("<html>Default<br>Player</html>"))
		{
			try {
				game.setPlayer(new DefaultPlayer(game.getGrid(), 0, 0));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			playerSelected.setText("Player Selected: Default Player selected.");
		}
		else if(source.getText().equals("<html>Freeze<br>Player</html>"))
		{
			try {
				game.setPlayer(new FreezePlayer(game.getGrid(), 0, 0));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			playerSelected.setText("Player Selected: Freeze Player selected.");
		}
		else if(source.getText().equals("<html>Speedy<br>Player</html>"))
		{
			try {
				game.setPlayer(new SpeedyPlayer(game.getGrid(), 0, 0));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			playerSelected.setText("Player Selected: Speedy Player selected.");
		}
		else if(source.getText().equals("<html>Default<br>Monster</html>"))
		{
			try {
				game.setMonster(new DefaultMonster(game.getGrid(), game.getPlayer(), 5, 5));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			enemySelected.setText("Enemy Selected: Default Monster Selected");
		}
		else if(source.getText().equals("<html>Invisible<br>Monster</html>"))
		{
			try {
				game.setMonster(new InvisibleMonster(game.getGrid(), game.getPlayer(), 5, 5));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			enemySelected.setText("Enemy Selected: Invisible Monster Selected");
		}
		else if(source.getText().equals("<html>Speedy<br>Monster</html>"))
		{
			try {
				game.setMonster(new SpeedyMonster(game.getGrid(), game.getPlayer(), 5, 5));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			enemySelected.setText("Enemy Selected: Speedy Monster Selected");
		}
		game.updateGameReferences();
	}

}
