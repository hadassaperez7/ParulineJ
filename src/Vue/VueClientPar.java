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


public class VueClientPar extends JPanel implements ActionListener
{
	private JButton btAjouter= new JButton("Ajouter");
	private JButton btSupprimer= new JButton("Supprimer");
	private JButton btEditer= new JButton("Editer");
	private JTable tableClients; 
	
	private JTextField txtNom= new JTextField();
	private JTextField txtadresse=new JTextField();
	private JTextField txtIdclient= new JTextField(); 
	
	
	private Tableau unTableau; // modele de tableu pr gerer la JTable
 


	public VueClientPar()
	{
		this.setBounds(20,70,720,380);
		this.setBackground(Color.magenta);
		this.setLayout(null); // pas de quadrillage
	
		
		
		JPanel unPanel = new JPanel();
		unPanel.setBounds(20,200,700,100);
		unPanel.setLayout(new GridLayout(2,4));   
		
		
		// pr changer la taille du contenu des boutons Fonf f = new Fonf ( Font.dialog ,font.bold, 2000) par ex
		unPanel.add(new JLabel(""));
		unPanel.add(new JLabel(" Id client:"));
		unPanel.add(txtIdclient);
		unPanel.add(new JLabel(""));
		this.txtIdclient.setEditable(false);
		
		
		
		unPanel.add(new JLabel("Nom : "));
		unPanel.add(this.txtNom);
		unPanel.add(new JLabel("Adresse : "));
		unPanel.add(this.txtadresse);
		
		unPanel.add(this.btAjouter);
		unPanel.add(this.btSupprimer);
		unPanel.add(this.btEditer);
		unPanel.add(new JLabel(""));
		
		unPanel.setVisible(true);;
		this.add(unPanel);
	
		
		
		// rendre les boutons cliquables 
		
		this.btAjouter.addActionListener(this);
		this.btEditer.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		
		//construction de la jtable 
	
		String entete[]= 
		{
		"id client", "Nom du client" , "Adresse du client"
		};
		
		Object [] [] lesDonnees =remplirDonnees(); 
		
		//gestion de la JTable ac le tableau
		unTableau=new Tableau(lesDonnees, entete);
		this.tableClients=new JTable(unTableau);

		
		
		//ajouter l'evenement clic sur la table mouselistener
		
		
		this.tableClients.addMouseListener(new MouseListener() {
			
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
				int ligne = tableClients.getSelectedRow(); 
				txtIdclient.setText(tableClients.getValueAt(ligne,0).toString());
				txtNom.setText(tableClients.getValueAt(ligne, 1).toString());
				txtadresse.setText(tableClients.getValueAt(ligne, 2).toString());
			}
		}); 
				
				
		
		JScrollPane uneScroll = new JScrollPane(tableClients); 
		uneScroll.setBounds(50,20,500,150);
		this.add(uneScroll);
		
		this.setVisible(false);
	}

        private Object [] [] remplirDonnees()
    
        {
        	ArrayList<ClientPar> lesClients=Modele.selectAllClient(); // on recupere les clients de la bdd 
        	Object[][] lesDonnees=new Object[lesClients.size()][3];// size le nb de clients de la bdd
        	int i= 0; 
        	for (ClientPar unClientPar : lesClients)
        	{
        		lesDonnees[i][0] = unClientPar.getIdclient()+"";
        		lesDonnees[i][1] = unClientPar.getNom();
        		lesDonnees[i][2] = unClientPar.getAdresse();
        		
        		i++;
        		
        	}
        	System.out.println(lesClients.size());
        			return lesDonnees; 
         }

	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand())
		{
		case "Ajouter":
		{
			String nom=this.txtNom.getText();
			String adresse = this.txtadresse.getText();
			//insertion ds la base de données table clients
			// on cree une istance de la classe client  ( si on oublie de rajouter un truc ) 
		if(nom.equals("") || adresse.equals(""))  //si le nom et mpp vide 
		{
			JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
		}
		else 
		{
			ClientPar unClient=new ClientPar(nom, adresse);
			Modele.insertClientpar(unClient);
			JOptionPane.showMessageDialog(this, "client inseré avec succes");
			//mise a jour de a Jtable 
			ClientPar leClient= Modele.selectWhere(unClient);			
			Object ligne[]= {
					unClient.getIdclient(),unClient.getNom(), unClient.getAdresse()
					};
			// [] un ensemble
					// rapel de la methode pr ajouter cette ligne ds la table
			unTableau.add(ligne);
			this.txtadresse.setText("");
			this.txtNom.setText("");
		}
		}
			break ; 
		
			case "Supprimer":
			{ 
			String nom =txtNom.getText();
			String adresse = txtadresse.getText();
			
			if(txtIdclient.getText().equals("")|| nom.equals("") || adresse.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
			}
			else  
			{
			int idclient = Integer.parseInt(txtIdclient.getText())	;
			ClientPar unClient=new ClientPar (idclient,nom,adresse);
			Modele.deleteClient(unClient);
			JOptionPane.showMessageDialog(this,"suppression reussie"); 
			int rowIndex= this.tableClients.getSelectedRow();
			unTableau.delete(rowIndex);
			
			txtIdclient.setText("");
			txtNom.setText("");
			txtadresse.setText("");
			}
			break; 
			}
			case "Editer" : 
			{
				int  idClient = Integer.parseInt(txtIdclient.getText())	;
				String nom =txtNom.getText();
				String adresse = txtadresse.getText();
			
				
				if(txtIdclient.getText().equals("")|| nom.equals("") || adresse.equals(""))
				{
					JOptionPane.showMessageDialog(this,"Veuillez remplir les champs");
				}
				else
				{
					int idclient=Integer.parseInt(txtIdclient.getText());
					
					ClientPar unClient= new ClientPar(idClient, nom, adresse); 
					
				Modele.updateClient(unClient);
				JOptionPane.showMessageDialog(this,"mise à jour reussie");
				
				Object ligne[] = {
						unClient.getIdclient(), unClient.getNom(), unClient.getAdresse()
						         };
				
				int rowIndex = this.tableClients.getSelectedRow();
				unTableau.update(rowIndex, ligne);
				
				txtIdclient.setText("");
				txtNom.setText("");
				txtadresse.setText("");
				}
			break ; 
			}
			}
			
		}
		
	
}
