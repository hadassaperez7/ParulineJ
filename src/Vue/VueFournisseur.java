package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controlleur.Fournisseur;
import Controlleur.Tableau;
import Modele.Modele;

public class VueFournisseur extends JPanel implements ActionListener
{
	
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btModifier = new JButton("Modifier");
	
	private  JTextField txtIdF = new JTextField();
	private JTextField txtNom = new JTextField();
    private JTextField txtAdresse =new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtTelephone = new JTextField();

	
	
	private Tableau unTableau; // modele de tableu pr gerer la JTable
	private JTable tableFournisseur;
 
	public VueFournisseur()
	{
		this.setBounds(150,150,850,600);
		this.setBackground(Color.gray);
		this.setLayout(null); // pas de quadrillage
	
		JPanel unPanel = new JPanel();
		unPanel.setBounds(0,200,700,80); //tableau boutton 
		unPanel.setLayout(new GridLayout(2 ,4));   
		

		unPanel.add(new JLabel("Id Fournisseur : "));
		unPanel.add(this.txtIdF);
		this.txtIdF.setEditable(false);
		unPanel.add(new JLabel("Nom : "));
		unPanel.add(this.txtNom);
		unPanel.add(new JLabel("Adresse : "));
		unPanel.add(this.txtAdresse);
		unPanel.add(new JLabel("Cp : "));
		unPanel.add(this.txtCp);
		unPanel.add(new JLabel("Ville : "));
		unPanel.add(this.txtVille);
		unPanel.add(new JLabel("Telephone : "));
		unPanel.add(this.txtTelephone);

		unPanel.add(new JLabel(""));

		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btModifier);
		
		unPanel.setVisible(true);
		this.add(unPanel);
	
		// rendre les boutons cliquables 
		
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this); 
		
		//construction de la jtable 
	
		String entete[]= 
		{
		"ID", "Nom" ,"Adresse", "Code postale" , "Ville", "Telephone" ,
		};
		
		Object [] [] lesDonnees = remplirDonnees(); 
		
		//gestion de la JTable ac le tableau
		unTableau = new Tableau(lesDonnees, entete);
		this.tableFournisseur = new JTable(lesDonnees, entete);
		
		//ajouter l'evenement clic sur la table mouselistener
		
		
		this.tableFournisseur.addMouseListener(new MouseListener() 
		
		{
			public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
			public void mouseClicked(MouseEvent e) {
				int ligne = tableFournisseur.getSelectedRow();

				txtIdF.setText(tableFournisseur.getValueAt(ligne, 0).toString());
				txtNom.setText(tableFournisseur.getValueAt(ligne,1).toString());
				txtAdresse.setText(tableFournisseur.getValueAt(ligne, 2).toString());
				txtCp.setText(tableFournisseur.getValueAt(ligne, 3).toString());
				txtVille.setText(tableFournisseur.getValueAt(ligne, 4).toString());
				txtTelephone.setText(tableFournisseur.getValueAt(ligne, 5).toString());
			}
		}); 
				
				
		JScrollPane uneScroll = new JScrollPane(tableFournisseur); 
		uneScroll.setBounds(0,5,700,100);   //hauteur du haut en bas ,largeur ,longeur du tableau m ,
		this.add(uneScroll);
		
		this.setVisible(false);
}

        private Object [] [] remplirDonnees()
    
        {
        	ArrayList<Fournisseur> lesFournisseur = Modele.selectAllFournisseur(); // on recupere les clients de la bdd
        	Object[][] lesDonnees = new Object[lesFournisseur.size()][6];// size le nb de clients de la bdd

        	int i= 0; 
        	for (Fournisseur unFournisseur : lesFournisseur)
        	{
        		lesDonnees[i][0] = unFournisseur.getidFournisseur();
        		lesDonnees[i][1] = unFournisseur.getNom();
        	    lesDonnees[i][2] = unFournisseur.getAdresse();
        		lesDonnees[i][3] = unFournisseur.getCp();
        		lesDonnees[i][4] = unFournisseur.getVille();
        		if (unFournisseur.getTelephone() == null) {
        			lesDonnees[i][5] = "0000000000";
				}
				else {
					lesDonnees[i][5] = unFournisseur.getTelephone();
				}
        		
        		i++;
        		
        	}

        	return lesDonnees;
        }
         
        
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand())
		{
		case "Ajouter":
		{
			String nom = this.txtNom.getText();
			String adresse = this.txtAdresse.getText();
			String cp = this.txtCp.getText();
			String ville = this.txtVille.getText();
			String telephone = this.txtTelephone.getText();
		
			//insertion ds la base de données table fournisseurs
			// on cree une istance de la classe client  ( si on oublie de rajouter un truc ) 
		
			if(nom.equals("") || adresse.equals("") || cp.equals("") || ville.equals("") || telephone.equals("")) {
				JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
			}
			else
				{
					Fournisseur unFournisseur = new Fournisseur(nom, adresse, cp, ville, telephone);

					Modele.insertFournisseur(unFournisseur);
					JOptionPane.showMessageDialog(this, "Client inseré avec succès");

					//mise a jour de a Jtable
					//Fournisseur leFournisseur = Modele.insertFournisseur(unFournisseur);

					Object ligne[]= {
							unFournisseur.getidFournisseur(),
							unFournisseur.getNom(),
							unFournisseur.getAdresse(),
							unFournisseur.getCp(),
							unFournisseur.getVille(),
							unFournisseur.getTelephone()
					};
			// [] un ensemble
					// rapel de la methode pr ajouter cette ligne ds la table

			unTableau.add(ligne);

			this.txtIdF.setText("");
			this.txtNom.setText("");
			this.txtAdresse.setText("");
			this.txtCp.setText("");
			this.txtVille.setText("");
			this.txtTelephone.setText("");
		}
		}
		break;


			case "Supprimer":
			{
				String iidFournisseur = txtIdF.getText();
				String nom = txtNom.getText();
				String adresse = txtAdresse.getText();
				String cp =txtNom.getText();
				String ville = txtAdresse.getText();
				String telephone =txtNom.getText();

				if(nom.equals("") || adresse.equals("") || cp.equals("")|| ville.equals("")|| telephone.equals("")) {
					JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
				}
				else
					{
						int idFournisseur = Integer.parseInt(iidFournisseur);

						Fournisseur unFournisseur = new Fournisseur (idFournisseur, nom, adresse, cp, ville, telephone);

						Modele.deleteFournisseur(unFournisseur);
						JOptionPane.showMessageDialog(this,"Suppression réussie");

						int rowIndex= this.tableFournisseur.getSelectedRow();
						unTableau.delete(rowIndex);

						txtIdF.setText("");
						txtNom.setText("");
						txtAdresse.setText("");
						txtCp.setText("");
						txtVille.setText("");
						txtTelephone.setText("");
					}
			}
			break; 

			case "Modifier" : 
			{
				String iidFournisseur = txtIdF.getText();
				String nom = txtNom.getText();
				String adresse = txtAdresse.getText();
				String cp = txtCp.getText();
				String ville = txtVille.getText();
				String telephone = txtTelephone.getText();
				
				if(nom.equals("") || adresse.equals("") || cp.equals("")|| ville.equals("")|| telephone.equals("")) {
					JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
				}
				else {
					int idFournisseur = Integer.parseInt(iidFournisseur);

					Fournisseur unFournisseur= new Fournisseur(idFournisseur, nom, adresse, cp, ville, telephone);

					Modele.updateFournisseur(unFournisseur);
					JOptionPane.showMessageDialog(this,"Mise à jour réussie");

					Object ligne[] = {
							unFournisseur.getidFournisseur(),
							unFournisseur.getidFournisseur(),
							unFournisseur.getNom(),
							unFournisseur.getAdresse(),
							unFournisseur.getCp(),
							unFournisseur.getVille(),
							unFournisseur.getTelephone(),
					};
				
				int rowIndex = this.tableFournisseur.getSelectedRow();
				unTableau.update(rowIndex, ligne);

				txtIdF.setText("");
				txtNom.setText("");
				txtAdresse.setText("");
				txtCp.setText("");
				txtVille.setText("");
				txtTelephone.setText("");
				}
			break ; 
			}
		}
	}
}

	
		
	

