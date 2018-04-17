package Modele;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

//import Controlleur.Client;
import Controlleur.ClientPar;
//import Controlleur.Etat;
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
					JOptionPane.showMessageDialog(null, "Bienvunue Administrateur, vous pouvez y accéder", "Connecté", JOptionPane.INFORMATION_MESSAGE, logo);
				} else {
					JOptionPane.showMessageDialog(null, "Vous n'avez pas les droits pour y accéder", "Droits insuffisant", JOptionPane.WARNING_MESSAGE);
				}
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


   public static void insertClientpar (ClientPar unClientPar)  // qu'on puisse rajouter un client particulier
   {
	   String requete = "insert into client  values (null, '"+unClientPar.getNom()+"','" +unClientPar.getAdresse()+"');";
	   Bdd uneBdd= new Bdd ("localhost","Paruline ","root","");
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
   
	   String requete ="select * from client ; " ; 
	   Bdd uneBdd = new Bdd ("localhost","Paruline","root","");
       try
		   {
					   uneBdd.seConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   while (unRes.next())
					   {
						   int idClientPar=unRes.getInt("idclientPar");
						   String NomClientPar =unRes.getString("nom");
						   String adresse =unRes.getString("adresse");
						   ClientPar unClientPar= new ClientPar(idClientPar,NomClientPar ,adresse); 
						  
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
   public static void deleteClient (ClientPar unClientPar )
   {
	   String requete = "delete from client where idclient="   +unClientPar.getIdclient()  +";";
	   Bdd uneBdd= new Bdd ("localhost","Paruline","root","");
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
   public static void updateClient (ClientPar unClientPar)
   {
	   String requete ="update client set nom ='"+unClientPar.getNom() +"', adresse ='"+unClientPar.getAdresse()+"'where idclient="
	   		+ "" + unClientPar.getIdclient() +";";

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
		   System.out.println("Erreur : "+requete);
		}
   }
   
   public static ClientPar selectWhere (ClientPar unClientPar)
   {
	   String requete = "select *from client where" +" nom = '"+unClientPar.getNom()+"' and adresse = '"+ unClientPar.getAdresse()+"';";
	   ClientPar leClientPar=null; 
	  Bdd uneBdd= new Bdd ("localhost","Paruline","root","");
      try
		   {
					   uneBdd.seConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   if (unRes.next())
					   {
						   int idClientPar=unRes.getInt("idclient");
						   leClientPar= new ClientPar (idClientPar, unClientPar.getNom(), unClientPar.getAdresse());
					   }
					   
		   
      unStat.close();
      unRes.close(); 
      uneBdd.seDeConnecter();
  }

	catch (SQLException exp)
	{
		System.out.println("Erreur"+requete);
	}
	return unClientPar; 
	}
   
   
   /*public static ArrayList<Etat> selectEtat()
   {
	   ArrayList<Etat>lesEtats=new ArrayList<Etat>();
   
	   String requete ="select * from etat; " ; 
	   BDD uneBdd= new BDD ("localhost","intervention","root","");
       try
		   {
					   uneBdd.SeConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   while (unRes.next())
					   {
						   String nomC =unRes.getString("nomClient");
						   String nomT =unRes.getString("nomTechniciens");
						   String description =unRes.getString("description");
						   String dateInter =unRes.getString("dateInter");
						   Etat unEtat= new Etat(nomC,nomT,description,dateInter); 
						  
						   lesEtats.add(unEtat);
					   }
		   
       unStat.close();
       unRes.close(); 
       uneBdd.SeDeconnecter();	
   }

	catch (SQLException exp)
	{
		System.out.println("Erreur"+requete);
	}
	return lesEtats; 
	}*/
			  
   }
   
	   