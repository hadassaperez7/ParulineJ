package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlleur.Main;


public class VueGenerale extends JFrame implements ActionListener
{
	private JButton btDeconnecter = new JButton("Se déconnecter");
	private JPanel plMenu =new JPanel();
	private JButton btClientPar = new JButton("Clients Particuliers"); 
	private JButton btClientPro = new JButton("Clients Professionnels"); 
	private JButton btFourniss = new JButton("Fournisseurs");
	private JButton btAccessoires = new JButton("Accessoires"); 
	private JButton btPrix=new JButton ("Prix");
	
	
// creations des 3 panels 
	private VueClientPar uneVueClientPar = new VueClientPar();
	private VueClientPro uneVueClientPro = new VueClientPro();
	private VueFournisseur uneVueFournisseur = new VueFournisseur();
	private VueAccessoires uneVueAccessoires = new VueAccessoires();
	private VuePrix uneVuePrix = new VuePrix();
	
	
	public  VueGenerale() 
	{
		this.setTitle("Paruline");
		this.setLayout(null); 
		this.setBounds(200,200,950,700); 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		 
		
		//placer le bouton deconnexion
		
		this.btDeconnecter.setBounds(390,600,130,40);  // droit ,en bas ,longueur,lepaisseur 
		this.add(this.btDeconnecter);
		this.btDeconnecter.addActionListener(this);
		
		//construction du panel menu 
		
		this.plMenu.setBounds(50,20,830,30);
		this.plMenu.setLayout(new GridLayout());
		this.plMenu.add(btClientPar);
		this.plMenu.add(btClientPro);
		this.plMenu.add(btFourniss);
		this.plMenu.add(btAccessoires);
		this.plMenu.add(btPrix);
		this.add(plMenu);
		
		
		//rendre les 5 boutons excecutables 
		this.btClientPar.addActionListener(this);
		this.btClientPro.addActionListener(this);
		this.btFourniss.addActionListener(this);
		this.btAccessoires.addActionListener(this);
		this.btPrix.addActionListener(this);
		
		
		// ajout des panels a la vue 
		this.add(this.uneVueClientPar);
		this.add(this.uneVueClientPro);
		this.add(this.uneVueFournisseur);
	    this.add(this.uneVueAccessoires);
		this.add(this.uneVuePrix);
		
		
		this.setVisible(true);
		
	}

	// cote visible 
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
			case "Se d�connecter ": this.dispose();
			                Main.rendreVisible(true);
			break; 
			
			case "Clients Particuliers":
				this.uneVueClientPar.setVisible(true);
				this.uneVueClientPro.setVisible(false);
				this.uneVueFournisseur.setVisible(false);
				this.uneVueAccessoires.setVisible(false);
				this.uneVuePrix.setVisible(false);
				break; 
			
			case "Clients Professionnels" : 
				this.uneVueClientPar.setVisible(false);
				this.uneVueClientPro.setVisible(true);
				this.uneVueFournisseur.setVisible(false);
				this.uneVueAccessoires.setVisible(false);
				this.uneVuePrix.setVisible(false);
				break;
				
			case "Fournisseurs" :
			this.uneVueClientPar.setVisible(false);
			this.uneVueClientPro.setVisible(false);
			this.uneVueFournisseur.setVisible(true);
			this.uneVueAccessoires.setVisible(false);
			this.uneVuePrix.setVisible(false);
			break;
				
			case "Accessoires":
				this.uneVueClientPar.setVisible(false);
				this.uneVueClientPro.setVisible(false );
				this.uneVueFournisseur.setVisible(false);
				this.uneVueAccessoires.setVisible(true);
				this.uneVuePrix.setVisible(false);
				break;
				
			case "Prix":
				this.uneVueClientPar.setVisible(false);
				this.uneVueClientPro.setVisible(false);
				this.uneVueFournisseur.setVisible(false);
				this.uneVueAccessoires.setVisible(false);
				this.uneVuePrix.setVisible(true);
				break;
				

				
			
		}
		
		
	}
}