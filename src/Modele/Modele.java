package Modele;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import Controlleur.Accessoires;
import Controlleur.ClientPar;
import Controlleur.ClientPro;
import Controlleur.Fournisseur;
import Controlleur.Prix;
import org.apache.commons.codec.digest.DigestUtils;

public class Modele
{
	public static int verifConnexion (String login , String mdp)
	{
		mdp = DigestUtils.sha1Hex(mdp);

		ImageIcon logo = new ImageIcon(Modele.class.getResource("/Images/logo.png"));
		Image image = logo.getImage();
		Image newImage = image.getScaledInstance(100, 75, Image.SCALE_REPLICATE);
		
		logo = new ImageIcon(newImage);
		
		String requete = "CALL connexion('"+login+"', '"+mdp+"')";

		Bdd uneBdd = new Bdd ("localhost","paruline","root","");

		int idUser = 0;
	
	
		try
		{
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnection().createStatement();

			ResultSet unRes = unStat.executeQuery(requete);

			if (unRes.next()) {
				idUser = unRes.getInt("id_user");

				if (idUser == 1) {
					JOptionPane.showMessageDialog(null, "Bienvunue Administrateur, vous pouvez y acc�der", "Connect�", JOptionPane.INFORMATION_MESSAGE, logo);
				} else {
					JOptionPane.showMessageDialog(null, "Vous n'avez pas les droits pour y acc�der", "Droits insuffisant", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Au moins un des deux identifiants sont incorrects", "Erreur de Connexion", JOptionPane.ERROR_MESSAGE);
			}

			uneBdd.seDeConnecter();
			unStat.close();
			unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur " + requete);
		}

		return idUser;
		}


   public static void insertFournisseur(Fournisseur unFournisseur ) {  // qu'on puisse rajouter un client particulier
       Bdd uneBdd = new Bdd("localhost", "paruline ", "root", "");

       String checkVille = "CALL checkExistsCity('" + unFournisseur.getVille() + "','" + unFournisseur.getCp() + "');";
       try {
           uneBdd.seConnecter();
           Statement unStat = uneBdd.getMaConnection().createStatement();

           ResultSet unRes = unStat.executeQuery(checkVille);

           int nb = unRes.getInt("nb");

           if (nb == 0) {
               String ajoutVille = "CALL InsertCity('" + unFournisseur.getVille() + "', '" + unFournisseur.getCp() + "');";

               try {
                   Statement unStatAjout = uneBdd.getMaConnection().createStatement();

                   unStatAjout.executeQuery(ajoutVille);
                   unStatAjout.close();
               }
               catch (SQLException e) {
                   System.out.println("Erreur : " + ajoutVille);
               }
           }

           String id = "CALL GetCity('" + unFournisseur.getVille() + "', '" + unFournisseur.getCp() + "')";

           try {
               Statement unStatId = uneBdd.getMaConnection().createStatement();

               ResultSet unResId = unStatId.executeQuery(id);

               int id_city = unResId.getInt("id_city");



               String insertFournisseur = "INSERT INTO fournisseur(id_city, name_f, adresse_f, phoneFour) VALUES (" + id_city + ", '" + unFournisseur.getNom() + "', " +
                       "'" + unFournisseur.getAdresse() + "', '" + unFournisseur.getTelephone() + "')";

               try {
                   Statement unStatFourn = uneBdd.getMaConnection().createStatement();
                   unStatFourn.executeQuery(insertFournisseur);

                   unStatFourn.close();
               }
               catch (SQLException e) {
                   System.out.println("Erreur : " + insertFournisseur);
               }

               unResId.close();
               unStatId.close();
           }
           catch (SQLException e) {
               System.out.println("Erreur : " + id);
           }

           unRes.close();
           unStat.close();
           uneBdd.seDeConnecter();
       } catch (SQLException exp) {
           System.out.println("Erreur : " + checkVille);
       }
   }
   
   public static void insertAccessoires(Accessoires unAccessoire )  // qu'on puisse rajouter un client particulier
   {
	   String requete = "insert into accessories()  values ('"+unAccessoire .getNom()+"','" 
       +unAccessoire .getDescription()+"','"+unAccessoire .getStock()+"');";
	   Bdd uneBdd= new Bdd ("localhost","Paruline ","root","");
	   
	 //  String checkVille = "call checkExistsCity('" + unAccessoire.getVille() + "','" + unFournisseur.getCp() +"');";
	   
	   
			   try
	   {
				   uneBdd.seConnecter();
				   Statement unStat=uneBdd.getMaConnection().createStatement();
				   unStat.execute(requete);
				   unStat.close();
				   uneBdd.seDeConnecter();
				   }
	   catch (SQLException exp)
	   {
		   System.out.println("Erreur : "+requete);
	   }
   }
   
   public static ArrayList<ClientPar> selectAllClient()
   {
	   ArrayList<ClientPar>ClientsPar=new ArrayList<ClientPar>();
   
	   String requete ="CALL getCustomers(); " ; 
	   Bdd uneBdd = new Bdd ("localhost","Paruline","root","");
       try
		   {
					   uneBdd.seConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   while (unRes.next())
					   {
						   String telephonePar=unRes.getString("phone"); // je met le nom de la base 
						   String cpPar=unRes.getString("cp");
						   String nomPar =unRes.getString("lastname");
						   String prenomPar =unRes.getString("firstname");
						   String emailPar =unRes.getString("email");
						   String adressePar =unRes.getString("address");
						   String villePar =unRes.getString("city");
						   ClientPar unClientPar= new ClientPar(nomPar, prenomPar, emailPar,telephonePar,adressePar,cpPar,villePar);
						  
						   ClientsPar.add(unClientPar);
					   }
		   
       unStat.close();
       unRes.close(); 
       uneBdd.seDeConnecter();
   }
       

	catch (SQLException exp)
	{
		System.out.println("Erreur"+requete);
	}
	return ClientsPar; 
	}
   
   
   public static ArrayList<ClientPro> selectAllClientPro()
   {
	   ArrayList<ClientPro>ClientsPro=new ArrayList<ClientPro>();
   
	   String requete ="CALL getCustomersPro(); " ; 
	   Bdd uneBdd = new Bdd ("localhost","Paruline","root","");
       try
		   {
					   uneBdd.seConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   while (unRes.next())
					   {
						   String raison=unRes.getString("company");
						   String type=unRes.getString("type_comp");
						   String telephonePro=unRes.getString("phone"); // je met le nom de la base 
						   String cpPro=unRes.getString("cp");
						   String nomPro =unRes.getString("lastname_contact");
						   String prenomPro =unRes.getString("firstname_contact");
						   String emailPro =unRes.getString("email");
						   String adressePro =unRes.getString("address");
						   String villePro =unRes.getString("city");
						   ClientPro unClientPro = new ClientPro(raison, type,nomPro, prenomPro, emailPro,telephonePro,adressePro,cpPro,villePro);
						  
						   ClientsPro.add(unClientPro);
					   }
		   
       unStat.close();
       unRes.close(); 
       uneBdd.seDeConnecter();
   }
       

	catch (SQLException exp)
	{
		System.out.println("Erreur"+requete);
	}
	return ClientsPro; 
	}
   

   public static ArrayList<Fournisseur> selectAllFournisseur()
   {
	   ArrayList<Fournisseur>Fournisseur=new ArrayList<Fournisseur>();
   
	   String requete ="CALL getProviders(); " ; 
	   Bdd uneBdd = new Bdd ("localhost","paruline","root","");
       try
		   {
					   uneBdd.seConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   while (unRes.next())
					   {
						   int idFournisseur = unRes.getInt("id_fourniss");
						   String telephoneFournisseur=unRes.getString("phoneFour"); // je met le nom de la base 
						   String cpFournisseur=unRes.getString("cp");
						   String nomFournisseur =unRes.getString("name_f");
						   String adresseFournisseur =unRes.getString("adresse_f");
						   String villeFournisseur =unRes.getString("city");

						   Fournisseur unFournisseur = new Fournisseur(idFournisseur, nomFournisseur, adresseFournisseur, cpFournisseur, villeFournisseur, telephoneFournisseur);
						  
						   Fournisseur.add(unFournisseur);
					   }
		   
       unStat.close();
       unRes.close(); 
       uneBdd.seDeConnecter();
   }
       

	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
	return Fournisseur; 
}
   
   
   public static ArrayList<Accessoires> selectAllAccessoires()
   {
	   ArrayList<Accessoires> accessoires = new ArrayList<Accessoires>();
   
	   String requete ="SELECT P.id_products, P.name_product, description, stock FROM accessories A, products P " +
			   "WHERE A.id_products = P.id_products;";

	   Bdd uneBdd = new Bdd ("localhost","paruline","root","");

       try
		   {
		   	uneBdd.seConnecter();
		   	Statement unStat=uneBdd.getMaConnection().createStatement();
		   	ResultSet unRes=unStat.executeQuery(requete);

		   	while (unRes.next()) {
						   
		   		String nom = unRes.getString("name_product"); // je met le nom de la base
				String description = unRes.getString("description");
				int stock = unRes.getInt("stock");
				int idAccessoires = unRes.getInt("id_products");

				Accessoires unAccessoire = new Accessoires (nom, description, stock, idAccessoires);

				accessoires.add(unAccessoire);
		   	}
		   
       unStat.close();
       unRes.close(); 
       uneBdd.seDeConnecter();
   }
   catch (SQLException exp) {
		System.out.println("Erreur : " + requete);
	}
	return accessoires;
}

   public static ArrayList<Prix> selectAllPrix() {
	   ArrayList<Prix> Prix = new ArrayList<Prix>();
   
	   String requete ="CALL getPriceAccesso();";
	   Bdd uneBdd = new Bdd ("localhost","paruline","root","");

       try {
		   	uneBdd.seConnecter();
		   	Statement unStat=uneBdd.getMaConnection().createStatement();
		   	ResultSet unRes=unStat.executeQuery(requete);

		   	while (unRes.next())
			{
				String nomProduit = unRes.getString("name_product"); // je met le nom de la base
				String nomFournisseur = unRes.getString("name_f");
				String referenceProduit = unRes.getString("ref");
				int idProduit = unRes.getInt("id_products");
				float prixFournisseur = unRes.getFloat("prFournisseur");
				float prixPondere = unRes.getFloat("prPondere");
				float margeMonetaire = unRes.getFloat("margeMonetaire");
				float coefficient = unRes.getFloat("coeff");
				float prixTotal = unRes.getFloat("prTotalAccess");

				Prix unPrix= new Prix (idProduit, nomProduit, nomFournisseur, referenceProduit, prixFournisseur,
						prixPondere, margeMonetaire, coefficient, prixTotal);

				Prix.add(unPrix);
			}
		   
       unStat.close();
       unRes.close(); 
       uneBdd.seDeConnecter();
   }
   catch (SQLException exp) {
	   System.out.println("Erreur : " + requete);
   }

   	return Prix;
}


	public static void deleteFournisseur(Fournisseur unFournisseur) {
	   String requete = "DELETE FROM fournisseur WHERE id_fourniss=" + unFournisseur.getidFournisseur() + ";";

	   Bdd uneBdd= new Bdd ("localhost","paruline","root","");
	   try {
		   uneBdd.seConnecter();

		   Statement unStat=uneBdd.getMaConnection().createStatement();

		   unStat.execute(requete);

		   unStat.close();
		   uneBdd.seDeConnecter();
	   }
	   catch (SQLException exp) {
		   System.out.println("Erreur : "+requete);
	   }
	}

   public static void updateFournisseur (Fournisseur unFournisseur)
   {
	   String requete ="UPDATE fournisseur F, city Cit SET name_f ='" + unFournisseur.getNom() + "', adresse_f ='" + unFournisseur.getAdresse() + "', " +
	   		"cp ='" + unFournisseur.getCp() + "', city = '" + unFournisseur.getVille() + "', phoneFour ='"+unFournisseur.getTelephone()+"'" +
			   " WHERE id_fourniss = " + unFournisseur.getidFournisseur() +
			   " AND F.id_city = Cit.id_city;";

	   Bdd uneBdd= new Bdd ("localhost","paruline","root","");

	   try {
		   uneBdd.seConnecter();

		   Statement unStat = uneBdd.getMaConnection().createStatement();
		   unStat.execute(requete);

		   unStat.close();
		   uneBdd.seDeConnecter();
	   }
	   catch (SQLException exp) {
		   System.out.println("Erreur : "+requete);
	   }
   }
  
	public static void deleteAccessoires(Accessoires unAccessoire) {
		   String requete = "DELETE FROM accessories WHERE id_products = " + unAccessoire.getidAccessoire() + ";";

		   Bdd uneBdd= new Bdd ("localhost","paruline","root","");

		   try {
			   uneBdd.seConnecter();

			   Statement unStat=uneBdd.getMaConnection().createStatement();

			   unStat.execute(requete);

			   unStat.close();
			   uneBdd.seDeConnecter();
		   }
			catch (SQLException exp) {
			   System.out.println("Erreur : " + requete);
			}
	}
	public static void updateAccessoires (Accessoires unAccessoire) {
		   String requete = "UPDATE accessories A, products P SET name_product ='" + unAccessoire.getNom() + "', description ='" + unAccessoire.getDescription() + "', stock = " + unAccessoire.getStock() +
				   " WHERE A.id_products = " + unAccessoire.getidAccessoire() +
				   " AND A.id_products = P.id_products;";

		   Bdd uneBdd= new Bdd ("localhost","paruline","root","");

		   try {
				uneBdd.seConnecter();

				Statement unStat = uneBdd.getMaConnection().createStatement();
				unStat.execute(requete);

				unStat.close();
				uneBdd.seDeConnecter();
		   }
		   catch (SQLException exp) {
			   System.out.println("Erreur : " + requete);
		   }
	}

	public static void updatePrix (Prix unPrix) {
		   String requete ="call UpdatePriceAcc(" + unPrix.getIdProduit() + ", '" + unPrix.getReferenceProduit() + "'," + unPrix.getPrixFournisseur() + "," + unPrix.getCoefficient() + ");";


		   Bdd uneBdd= new Bdd ("localhost","Paruline","root","");

		   try
		{
			   uneBdd.seConnecter();

			   Statement unStat = uneBdd.getMaConnection().createStatement();
			   unStat.execute(requete);
			   unStat.close();
			   uneBdd.seDeConnecter();
			   }
			catch (SQLException exp)
			{
			   System.out.println("Erreur : " + requete);
			}
	}

}
   
	   