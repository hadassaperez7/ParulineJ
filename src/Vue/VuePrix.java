package Vue;

import java.awt.Color;
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

import Controlleur.Prix;
import Controlleur.Tableau;
import Modele.Modele;


public class VuePrix extends JPanel implements ActionListener
{
   
	private JButton btModifier= new JButton("Modifier");
	private JTextField txtIdPrix = new JTextField();
	private JTextField txtReferenceProduit= new JTextField();
	private JTextField txtPrixFournisseur= new JTextField();
	private JTextField txtCoefficient= new JTextField();
	
	
	private Tableau unTableau; // modele de tableu pr gerer la JTable
	private JTable tablePrix;
 
	public VuePrix()
	{
		this.setBounds(150,150,850,600);
		this.setBackground(Color.gray);
		this.setLayout(null); // pas de quadrillage
	
	
		JPanel unPanel = new JPanel(); // panel tab modifier
		unPanel.setBounds(10,200,650,80);
		unPanel.setLayout(new GridLayout(3 ,3));
		

		unPanel.add(new JLabel("Id Produit : "));
		unPanel.add(this.txtIdPrix);
		this.txtIdPrix.setEditable(false);
		unPanel.add(new JLabel("Reference Produit : "));
		unPanel.add(this.txtReferenceProduit);
		unPanel.add(new JLabel("Prix Fournisseur : "));
		unPanel.add(this.txtPrixFournisseur);
		unPanel.add(new JLabel("Coefficient: "));
		unPanel.add(this.txtCoefficient);
		
	
		unPanel.add(this.btModifier);
		
		
		unPanel.setVisible(true);
		this.add(unPanel);
	

		// rendre les boutons cliquables 
		
		
		this.btModifier.addActionListener(this);
		
		//construction de la jtable 
	
		String entete[] =
		{
		"ID", "Nom Produit", "Nom Fournisseur" , "Reference Produit" , "Prix Fournisseur" , "Prix Pondéré", "Marge Monetaire" ,
		"Coefficient" , "Prix Total"
		};
		
		Object [] [] lesDonnees = remplirDonnees(); 
		
		//gestion de la JTable ac le tableau
		unTableau = new Tableau(lesDonnees, entete);
		this.tablePrix = new JTable(unTableau);

		
		
		//ajouter l'evenement clic sur la table mouselistener
		
		
		this.tablePrix.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = tablePrix.getSelectedRow();

				txtIdPrix.setText(tablePrix.getValueAt(ligne, 0).toString());
				txtReferenceProduit.setText(tablePrix.getValueAt(ligne, 3).toString());
				txtPrixFournisseur.setText(tablePrix.getValueAt(ligne, 4).toString());
				txtCoefficient.setText(tablePrix.getValueAt(ligne, 7).toString());
			}
		}); 
				
				
		JScrollPane uneScroll = new JScrollPane(tablePrix); 
		uneScroll.setBounds(0,5,750,110);   //hauteur du haut en bas ,largeur ,longeur du tableau m ,
		this.add(uneScroll);
		
		this.setVisible(true);
	}

        private Object [] [] remplirDonnees()
    
        {
        	ArrayList<Prix> lesPrix = Modele.selectAllPrix(); // on recupere les clients de la bdd
        	Object[][] lesDonnees = new Object[lesPrix.size()][9];// size le nb de clients de la bdd
        	int i= 0; 
        	for (Prix unPrix: lesPrix) {
				lesDonnees[i][0] = unPrix.getIdProduit();
				lesDonnees[i][1] = unPrix.getNomProduit();
				lesDonnees[i][2] = unPrix.getNomFournisseur();

				if (unPrix.getReferenceProduit() == null) {
					lesDonnees[i][3] = "AUCUNE RÉFÉRENCE";
				} else {
					lesDonnees[i][3] = unPrix.getReferenceProduit();
				}

        		lesDonnees[i][4] = unPrix.getPrixFournisseur();
        		lesDonnees[i][5] = unPrix.getPrixPondere();
        		lesDonnees[i][6] = unPrix.getMargeMonetiare();
        		lesDonnees[i][7] = unPrix.getCoefficient();
        		lesDonnees[i][8] = unPrix.getPrixTotal();

        		i++;
        		
        	}
        	System.out.println(lesPrix.size());
        			return lesDonnees; 
         }
        


	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand())
		{
		
			case "Modifier" : 
			{

				String iProduit = txtIdPrix.getText();
				String  iReferenceProduit = txtReferenceProduit.getText();
				String  iPrixFournisseur = txtPrixFournisseur.getText()	;
				String  iCoefficient=txtCoefficient.getText();
				
				if(iPrixFournisseur.equals("") || iCoefficient.equals("") || iReferenceProduit.equals(""))
				{
					JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
				}
				else
				{
					int idProduit = Integer.parseInt(iProduit);
					float prixFournisseur= Float.parseFloat( iPrixFournisseur);
					float coefficient = Float.parseFloat(iCoefficient);
					
					Prix unPrix= new Prix(idProduit, iReferenceProduit, prixFournisseur, coefficient);
					 
					
				Modele.updatePrix(unPrix);
				JOptionPane.showMessageDialog(this,"Mise à jour reussie");
				
			Object ligne[] = {
					unPrix.getIdProduit(),
					unPrix.getNomProduit(),
					unPrix.getNomFournisseur(),
					unPrix.getReferenceProduit(),
					unPrix.getPrixFournisseur(),
					unPrix.getPrixPondere(),
					unPrix.getMargeMonetiare(),
					unPrix.getCoefficient(),
					unPrix.getPrixTotal()
			};
				
				int rowIndex = this.tablePrix.getSelectedRow();
				unTableau.update(rowIndex, ligne);

				txtReferenceProduit.setText("");
				txtPrixFournisseur.setText("");
				txtCoefficient.setText("");
				txtIdPrix.setText("");
				}
			break ;
			}
		}
	}
}
		

