package Controlleur;

public class ClientPar{
	
	private int idclient; 
	private String nom,adresse;
	
	public ClientPar ()
	{
		this.idclient=0; 
		this.nom="";
		this.adresse=""; 
		}
	public ClientPar(int idclient,String nom, String adresse)
	{
		this.idclient=idclient; 
		this.nom=nom;
		this.adresse=adresse; 
	}
	public ClientPar (String nom, String adresse)
	{
		this.idclient=0; 
		this.nom=nom;
		this.adresse=adresse; 
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
