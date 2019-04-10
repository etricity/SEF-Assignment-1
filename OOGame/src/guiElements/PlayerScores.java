package guiElements;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

import Utilities.DataFiller;

public class PlayerScores extends JPanel {
	
	private JLabel col1 = new JLabel("Score",  JLabel.CENTER);
	private JLabel col2 = new JLabel("Difficulty",  JLabel.CENTER);
	
	public PlayerScores()
	{
		this.setLayout(new GridLayout(4,2));
		this.setVisible(true);
		col1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		col2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(col1);
		this.add(col2);
		this.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
	}
	

}
