
package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlleur.Main;
import Modele.Modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	
	private JPanel unPanel= new JPanel(); 
	private JButton btAnnuler= new JButton ("annuler"); 
	private JButton btSeConnecter= new JButton ("Se Connecter"); 
	private JTextField textLogin= new  JTextField ();//saisie du texte 
    private JPasswordField pwMdp = new JPasswordField(); 
	
	
	public  VueConnexion() {
		this.setTitle("Paruline");
		this.setBounds(700,200,500,400); // position par rapport a l'ecran gauche , dehauteur , longeur , larguer 
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.blue);
		
		//Construction du panel 
		this.unPanel.setBounds (50,180,400,150); 
		this.unPanel.setLayout(new GridLayout(3,2)); 
		this.unPanel.setBackground ( Color.yellow); 
		
		this.unPanel.add(new JLabel ("Login:")); 
		this.unPanel.add(this.textLogin);
		this.unPanel.add(new JLabel ("mdp:")); 
		this.unPanel.add(this.pwMdp); 
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeConnecter);
		
		this.unPanel.setVisible(true);
		
		this.add(this.unPanel);

		//ajout du logo 
		ImageIcon logo= new ImageIcon(VueConnexion.class.getResource("/Images/logo.png")); 
		Image image = logo.getImage();
		Image newImage = image.getScaledInstance(300, 200, Image.SCALE_REPLICATE);
		logo = new ImageIcon(newImage);
		
		JLabel lbLogo= new JLabel(logo); 
		lbLogo.setBounds(50,0,400,200); 
		this.add(lbLogo);
		
		//Pr changer le logo de l'application
		
		ImageIcon web= new ImageIcon(VueConnexion.class.getResource("/Images/logo.png"));
		this.setIconImage(web.getImage()); 
		
		
		//rendre les bouttons exceutable 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		//rendre le bouton entree applicable 
		this.textLogin.addKeyListener(this);
	    this.pwMdp.addKeyListener(this);
	    
		
		
		this.setVisible(true); // rendre visible la fenetre principale
		
	}
	
	public void traitement()
	{
		String login=this.textLogin.getText();
		String mdp = new String (this.pwMdp.getPassword());


		if (login.isEmpty() || mdp.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs.", "Informations incomplètes", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			int idUser = Modele.verifConnexion(login, mdp);

			if (idUser == 1) {
				Main.rendreVisible(false);
				new VueGenerale();
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Annuler": 
			this.textLogin.setText("");
			this.pwMdp.setText("");
			break ; 
			
		case "Se Connecter": 
			traitement(); 
			break; 
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyChar()== KeyEvent.VK_ENTER) //test de la touche entree du clavier 
		{
			traitement();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
