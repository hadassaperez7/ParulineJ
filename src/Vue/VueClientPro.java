package Vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controlleur.ClientPar;
import Controlleur.ClientPro;
import Controlleur.Tableau;
import Modele.Modele;

public class VueClientPro extends JPanel
{
		
			private Tableau unTableau; // modele de tableu pr gerer la JTable
			private JTable tableClientPro;
		 


			public VueClientPro()
			{
				this.setBounds(150,150,850,600);
				this.setBackground(Color.gray);
				this.setLayout(null); // pas de quadrillage
			
				
				
				
				//construction de la jtable 
			
				String entete[]= 
				{
				"Raison social" , "Type société" , "Nom", "Prénom" , "Email" , "Téléphone" , "Adresse", "Code postal" , "Ville"
				};
				
				Object [] [] lesDonnees = remplirDonnees(); 
				
				//gestion de la JTable ac le tableau
				unTableau = new Tableau(lesDonnees, entete);
				this.tableClientPro = new JTable(unTableau);
				
						
				JScrollPane uneScroll = new JScrollPane(tableClientPro); 
				uneScroll.setBounds(0,5,730,100);   //hauteur du haut en bas ,largeur ,longeur du tableau m ,
				this.add(uneScroll);
				
				this.setVisible(true);
			}

		        private Object [] [] remplirDonnees()
		    
		        {
		        	ArrayList<ClientPro> lesClientsPro=Modele.selectAllClientPro(); // on recupere les clients de la bdd 
		        	Object[][] lesDonnees=new Object[lesClientsPro.size()][9];// size le nb de clients de la bdd
		        	int i= 0; 
		        	for (ClientPro unClientPro : lesClientsPro)
		        	{
		        		lesDonnees[i][0] = unClientPro.getRaison();
		        		lesDonnees[i][1] = unClientPro.getType();
		        		lesDonnees[i][2] = unClientPro.getNom();
		        		lesDonnees[i][3] = unClientPro.getPrenom();
		        		lesDonnees[i][4] = unClientPro.getEmail();
		        		lesDonnees[i][5] = unClientPro.getTelephone();
		        		lesDonnees[i][6] = unClientPro.getAdresse();
		        		lesDonnees[i][7] = unClientPro.getCp();
		        		lesDonnees[i][8] = unClientPro.getVille();
		        		
		        		i++;
		        		
		        	}
		        	System.out.println(lesClientsPro.size());
		        			return lesDonnees; 
		         }
}
		       