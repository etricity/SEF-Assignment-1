package guiElements;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

import Utilities.DataFiller;

public class LeaderBoard extends JPanel {
	
	private JLabel col1 = new JLabel("Player", JLabel.CENTER);
	private JLabel col2 = new JLabel("Score",  JLabel.CENTER);
	private JLabel col3 = new JLabel("Difficulty",  JLabel.CENTER);
	private DataFiller df = new DataFiller();
	private String[][] data = new String[][] {{"","",""}, {"","",""}, {"","",""}, {"","",""}, {"", "", ""}};
	
	public LeaderBoard()
	{
		this.setLayout(new GridLayout(6,3));
		this.setVisible(true);
		col1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		col2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		col3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(col1);
		this.add(col2);
		this.add(col3);
		this.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
		df.fillTable(data, this);
		
	}
	
	
	//Getters & Setters
	public String[][] getData()
	{
		return data;
	}
	public void setData(String[][] data)
	{
		this.data = data;
	}

}
