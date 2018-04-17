package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlleur.Main;


public class VueGenerale extends JFrame implements ActionListener
{
	private JButton btQuitter = new JButton("Quitter");
	private JPanel plMenu =new JPanel();
	private JButton btClientPar = new JButton("Client Particulier"); 
	private JButton btClientPro = new JButton("Client Proffessionnel"); 
	private JButton btAcc = new JButton("Accessoires"); 
	
// creations des 3 panels 
	private VueClientPar uneVueClientPar= new VueClientPar(); 
	private VueClientPro uneVueClientPro= new VueClientPro();
	private VueAcc uneVueAcc= new VueAcc(); 
	
	
	public  VueGenerale() 
	{
		this.setTitle("Paruline");
		this.setLayout(null); 
		this.setBounds(200,200,750,470); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		 
		
		//placer le bouton quitter 
		
		this.btQuitter.setBounds(300,410,100,20); 
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		//construction du panel menu 
		
		this.plMenu.setBounds(0,20,750,30);
		this.plMenu.setLayout(new GridLayout(1,3));
		this.plMenu.add(btClientPar);
		this.plMenu.add(btClientPro);
		this.plMenu.add(btAcc);
		this.add(this.plMenu);
		
		
		//rendre les 3 boutons excecutables 
		this.btClientPar.addActionListener(this);
		this.btClientPro.addActionListener(this);
		this.btAcc.addActionListener(this);
		
		// ajout des panels a la vue 
		this.plMenu.setBounds(0, 0,750, 20);
		this.plMenu.setLayout(new GridLayout());
		this.plMenu.add(this.uneVueClientPar); 
		this.plMenu.add(this.uneVueClientPro);
		this.plMenu.add(this.uneVueAcc);

		
		this.setVisible(true);
	
		
	}

	// cote visible 
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
			case "Quitter": this.dispose();
			                Main.rendreVisible(true);
			break; 
			
			case "Clients Particulier":
				this.uneVueClientPar.setVisible(true);
				this.uneVueClientPro.setVisible(false);
				this.uneVueAcc.setVisible(false);
				break; 
			
			case "Clients Proffessionel" : 
				this.uneVueClientPar.setVisible(false);
				this.uneVueClientPro.setVisible(false);
				this.uneVueAcc.setVisible(true);
				break;
				
			case "Accessoires":
				this.uneVueClientPar.setVisible(false);
				this.uneVueClientPro.setVisible(true);
				this.uneVueAcc.setVisible(false);
				break;
			
		}
		
		
	}
}