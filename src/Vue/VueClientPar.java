package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.print.attribute.standard.JobStateReason;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controlleur.ClientPar;
import Controlleur.Tableau;
import Modele.Modele;


public class VueClientPar extends JPanel
{

	
	private Tableau unTableau; // modele de tableu pr gerer la JTable
	private JTable tableClientPar;
 


	public VueClientPar()
	{
		this.setBounds(150,150,850,600);
		this.setBackground(Color.gray);
		this.setLayout(null); // pas de quadrillage
	
	
	
		//construction de la jtable 
	
		String entete[]= 
		{
		"Nom", "Prénom" , "Email" , "Téléphone" , "Adresse", "Code postal" , "Ville"
		};
		
		Object [] [] lesDonnees = remplirDonnees(); 
		
		//gestion de la JTable ac le tableau
		unTableau = new Tableau(lesDonnees, entete);
		this.tableClientPar = new JTable(unTableau);

		
		JScrollPane uneScroll = new JScrollPane(tableClientPar); 
		uneScroll.setBounds(40,5,620,100);   //hauteur du haut en bas ,largeur ,longeur du tableau m ,
		this.add(uneScroll);
		
		this.setVisible(true);
	}

        private Object [] [] remplirDonnees()
    
        {
        	ArrayList<ClientPar> lesClientsPar=Modele.selectAllClient(); // on recupere les clients de la bdd 
        	Object[][] lesDonnees=new Object[lesClientsPar.size()][7];// size le nb de clients de la bdd
        	int i= 0; 
        	for (ClientPar unClientPar : lesClientsPar)
        	{
        		lesDonnees[i][0] = unClientPar.getNom();
        		lesDonnees[i][1] = unClientPar.getPrenom();
        		lesDonnees[i][2] = unClientPar.getEmail();
        		lesDonnees[i][3] = unClientPar.getTelephone();
        		lesDonnees[i][4] = unClientPar.getAdresse();
        		lesDonnees[i][5] = unClientPar.getcp();
        		lesDonnees[i][6] = unClientPar.getVille();
        		
        		i++;
        		
        	}
        	System.out.println(lesClientsPar.size());
        			return lesDonnees; 
         }
  	
}
