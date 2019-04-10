package guiElements;

import javax.swing.*;
import java.awt.*;

public class GameModesPanel extends JPanel{
	
	private JLabel titleLabel = new JLabel("Game Modes");
	private JButton playerType1Button = new JButton("<html>Default<br>Player</html>");
	private JButton playerType2Button = new JButton("<html>Teleporter<br>Player</html>");
	private JButton playerType3Button = new JButton("<html>Freeze<br>Player</html>");
	private JButton enemyType1Button = new JButton("<html>Default<br>Monster</html>");
	private JButton enemyType2Button = new JButton("<html>Invisible<br>Monster</html>");
	private JButton enemyType3Button = new JButton("<html>Speedy<br>Monster</html>");
	private JLabel playerSelected = new JLabel("Player Selected: ");
	private JLabel enemySelected = new JLabel("Enemy Selected: ");

	public GameModesPanel()
	{
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
		this.add(titleLabel, BorderLayout.NORTH);
		
		Container center = new Container();
		center.setLayout(new GridLayout(2,3, 10, 20));
		center.setVisible(true);
		
		center.add(playerType1Button);
		center.add(playerType2Button);
		center.add(playerType3Button);
		center.add(enemyType1Button);
		center.add(enemyType2Button);
		center.add(enemyType3Button);
		
		this.add(center, BorderLayout.CENTER);
		
		Container south = new Container();
		south.setLayout(new GridLayout(3,1, 10, 20));
		south.setVisible(true);
		
		south.add(playerSelected);
		south.add(enemySelected);
		
		this.add(south, BorderLayout.SOUTH);
		
	}

}
