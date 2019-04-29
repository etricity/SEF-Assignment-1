package guiElements;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

import Utilities.DataFiller;

public class PlayerScores extends JPanel {
	
	
	
	public PlayerScores()
	{
		this.setLayout(new GridLayout(4,2));
		this.setVisible(true);
		this.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
	}
	

}
