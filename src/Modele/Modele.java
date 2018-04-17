package Modele;

import java.io.UnsupportedEncodingException;
import java.rmi.dgc.Lease;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

//import Controlleur.Client;
import Controlleur.ClientPar;
//import Controlleur.Etat;
import modele.BDD;

public class Modele
{
	public static String sha1(String input) {
	    String sha1 = null;
	    try {
	        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
	        msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
	        sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
	    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
	       
	    }
	    return sha1;
	}
	
	public static String verifConnexion (String login , String mdp)
	{
		mdp = sha1(mdp);
		
		String requete="SELECT id_user, email, password, type FROM user WHERE email = '" + login + "' AND password = '" + mdp +"'";
		BDD uneBdd=new BDD ("localhost","paruline","root","");
	
	
		try
		{
		uneBdd.SeConnecter(); 
				Statement unStat= uneBdd.getMaConnection().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next())
				{
					int nb=unRes.getInt("nb"); 
					if (nb !=0) droits= unRes.getString("droits");
						
				}
				uneBdd.SeConnecter();
				unStat.close(); 
				unRes.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur"+requete);
		}
		return droits; 
		}
   public static void insertClientpar (ClientPar unClientPar)  // qu'on puisse rajouter un client particulier
   {
	   String requete = "insert into client  values (null, '"+unClientPar.getNom()+"','" +unClientPar.getAdresse()+"');";
	   BDD uneBdd= new BDD ("localhost","Paruline ","root","");
			   try
	   {
				   uneBdd.SeConnecter();
				   Statement unStat=uneBdd.getMaConnection().createStatement();
				   unStat.execute(requete);
				   unStat.close();
				   uneBdd.SeConnecter();
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
	   BDD uneBdd= new BDD ("localhost","Paruline","root","");
       try
		   {
					   uneBdd.SeConnecter();
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
       uneBdd.SeDeconnecter();	
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
	   BDD uneBdd= new BDD ("localhost","Paruline","root","");
	   try
       {
		   uneBdd.SeConnecter();
		   Statement unStat=uneBdd.getMaConnection().createStatement();
		   unStat.execute(requete);
		   unStat.close();
		   uneBdd.SeConnecter();
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
	   BDD uneBdd= new BDD ("localhost","Paruline","root","");
	   try
       {
		   uneBdd.SeConnecter();
		   Statement unStat=uneBdd.getMaConnection().createStatement();
		   unStat.execute(requete);
		   unStat.close();
		   uneBdd.SeDeconnecter();
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
	  BDD uneBdd= new BDD ("localhost","Paruline","root","");
      try
		   {
					   uneBdd.SeConnecter();
					   Statement unStat=uneBdd.getMaConnection().createStatement();
					   ResultSet unRes=unStat.executeQuery(requete); 
					   if (unRes.next())
					   {
						   int idClientPar=unRes.getInt("idclient");
						   leClientPar= new ClientPar (idClientPar, unClientPar.getNom(), unClientPar.getAdresse());
					   }
					   
		   
      unStat.close();
      unRes.close(); 
      uneBdd.SeDeconnecter();	
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
   
	   