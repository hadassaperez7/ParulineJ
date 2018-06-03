package Controlleur;

public class Fournisseur {

private String nom, prenom , email ,adresse , ville,telephone,cp;
private int idFournisseur;
	
	
	
	public Fournisseur (int idFournisseur, String nom, String adresse, String cp, String ville, String telephone)
	{
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
	}

	public Fournisseur (String nom, String adresse, String cp, String ville, String telephone) {
		this.idFournisseur = 0;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
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
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		adresse = adresse;
	}

	public String getCp() {
		return cp;
	}
	public void setcp(String cp) {
		cp= cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String Telephone) {
		telephone = telephone;
	}
	public int getidFournisseur() {
		return idFournisseur;
	}
	public void setidFournisseur(int idFournisseur) {
		idFournisseur = idFournisseur;
	}

	
}
		
