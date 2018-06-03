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

import Controlleur.Accessoires;
import Controlleur.Tableau;
import Modele.Modele;

public class VueAccessoires extends JPanel implements ActionListener
{
	private JButton btSupprimer= new JButton("Supprimer");
	private JButton btModifier= new JButton("Modifier");
	
	
	
	private JTextField txtNom=new JTextField();
	private JTextField txtDescription= new JTextField();
	private JTextField txtStock=new JTextField();
	private JTextField txtidAccessoire= new JTextField();
	
	private Tableau unTableau;
	private JTable tableAccessoires; 
	
	public VueAccessoires()
	{
		this.setBounds(150,150,850,600);
		this.setBackground(Color.gray);
		this.setLayout(null); // pas de quadrillage
		
		JPanel unPanel = new JPanel();
		unPanel.setBounds(0,200,700,80); //tableau boutton 
		unPanel.setLayout(new GridLayout(2 ,4));   
		
		
		unPanel.add(new JLabel("Id Accessoire : "));
		unPanel.add(this.txtidAccessoire);
		this.txtidAccessoire.setEditable(false);
		unPanel.add(new JLabel("Nom : "));
		unPanel.add(this.txtNom);
		unPanel.add(new JLabel("Description : "));
		unPanel.add(this.txtDescription);
		unPanel.add(new JLabel("Stock : "));
		unPanel.add(this.txtStock);

		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(""));

		unPanel.add(this.btSupprimer);
		unPanel.add(this.btModifier);
		
		unPanel.setVisible(true);
		this.add(unPanel);
	
		// rendre les boutons cliquables 
		
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this); 
		
		//construction de la jtable 
	
		String entete[] = {
		"ID", "Nom" ,"Description", "Stock"
		};
		
		Object [] [] lesDonnees = remplirDonnees(); 
		
		//gestion de la JTable ac le tableau
		unTableau = new Tableau(lesDonnees, entete);

		this.tableAccessoires = new JTable(lesDonnees, entete);
		
		//ajouter l'evenement clic sur la table mouselistener
		
		
		this.tableAccessoires.addMouseListener(new MouseListener() 
		
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
				int ligne = tableAccessoires.getSelectedRow();

				txtidAccessoire.setText(tableAccessoires.getValueAt(ligne, 0).toString());
				txtNom.setText(tableAccessoires.getValueAt(ligne,1).toString());
				txtDescription.setText(tableAccessoires.getValueAt(ligne, 2).toString());
				txtStock.setText(tableAccessoires.getValueAt(ligne, 3).toString());
				
			}
		}); 
				
				
		JScrollPane uneScroll = new JScrollPane(tableAccessoires); 
		uneScroll.setBounds(0,5,700,100);   //hauteur du haut en bas ,largeur ,longeur du tableau m ,
		this.add(uneScroll);
		
		this.setVisible(false);
}

        private Object [] [] remplirDonnees()
    
        {
        	ArrayList<Accessoires> lesAccessoires = Modele.selectAllAccessoires(); // on recupere les Accessoires de la bdd

        	Object[][] lesDonnees=new Object[lesAccessoires.size()][4];// size le nb de clients de la bdd

        	int i= 0; 
        	for (Accessoires unAccessoire : lesAccessoires)
        	{
        		lesDonnees[i][0] = unAccessoire.getidAccessoire();
        		lesDonnees[i][1] = unAccessoire.getNom();
        	    lesDonnees[i][2] = unAccessoire.getDescription();
        		lesDonnees[i][3] = unAccessoire.getStock();
        		
        		i++;
        	}
        	return lesDonnees;
        }
         
        
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand())
		{
		
			case "Supprimer":
			{
				int  idAccessoire = Integer.parseInt(txtidAccessoire.getText())	;
				String nom = txtNom.getText();
				String description = txtDescription.getText();
				String istock = txtStock.getText();

				if(nom.equals("") || description.equals("") || istock.equals("")) {
					JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
				}
				else
					{
						int stock = Integer.parseInt(txtStock.getText());

						Accessoires unAccessoire=new Accessoires (nom, description, stock, idAccessoire);

						Modele.deleteAccessoires(unAccessoire);

						JOptionPane.showMessageDialog(this,"Suppression réussie");

						int rowIndex= this.tableAccessoires.getSelectedRow();
						unTableau.delete(rowIndex);

						txtidAccessoire.setText("");
						txtidAccessoire.setText("");
						txtNom.setText("");
						txtDescription.setText("");
						txtStock.setText("");
					}
			}
			break; 

			case "Modifier" : 
			{
				int  idAccessoire= Integer.parseInt(txtidAccessoire.getText())	;
				String nom =txtNom.getText();
				String description = txtDescription.getText();
				String istock = txtStock.getText();
				
				if(nom.equals("") || description.equals("") || istock.equals("")) {
					JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
				}
				else
				{
					int stock = Integer.parseInt(txtStock.getText());

					Accessoires unAccessoire = new Accessoires(nom, description, stock, idAccessoire);

					Modele.updateAccessoires(unAccessoire);
					JOptionPane.showMessageDialog(this,"mise à jour reussie");

					Object ligne[] = {
							unAccessoire.getidAccessoire(),
							unAccessoire.getNom(),
							unAccessoire.getDescription(),
							unAccessoire.getStock(),
					};

					int rowIndex = this.tableAccessoires.getSelectedRow();
					unTableau.update(rowIndex, ligne);

					txtidAccessoire.setText("");
					txtNom.setText("");
					txtDescription.setText("");
					txtStock.setText("");
				}
			break;
			}
		}
	}
}

	
		