package Vue;

import java.awt.Color;

import javax.swing.JPanel;

public class VueClientPro extends JPanel
{
	
	public VueClientPro()
	{
		this.setBounds(20,70,720,380);
		this.setBackground(Color.yellow);
		this.setLayout(null); // pas de quadrillage
		
		this.setVisible(false);
	}

}