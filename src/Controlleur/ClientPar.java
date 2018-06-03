package Controlleur;

public class ClientPar{
	
	
	 
	private String nom, prenom , email ,adresse , ville,telephone,cp;
	
	/*public ClientPar ()
	{
		this.nom="";
		this.prenom="";
		this.email="";
		this.telephone="";
		this.adresse="";
		this.cp="";
		this.ville="";
		
		}
	public ClientPar(String Telephone , String cp ,String nom, String prenom, String email ,String adresse , String ville)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.telephone=telephone;
		this.adresse=adresse;
		this.cp=cp;
		this.ville=ville; 
	}*/
	public ClientPar (String nom, String prenom, String email ,String telephone, String adresse ,String cp ,String ville)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		telephone = telephone;
	}
	public String getcp() {
		return cp;
	}
	public void setcp(String cp) {
		cp= cp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		ville = ville;
	}
	
}
		
