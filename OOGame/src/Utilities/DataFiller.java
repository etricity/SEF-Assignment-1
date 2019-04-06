package Utilities;

import java.awt.*;

import javax.swing.*;

public class DataFiller {
	
	JLabel label;
	
	public void fillTable(String[][] data, Container p)
	{
		//Test Data		
				for(String[] a: data)
				{
					for(int i = 0; i < a.length; i++)
					{
						label = new JLabel(a[i], JLabel.CENTER);
						p.add(label);
						label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
					}
				}
	}

}
