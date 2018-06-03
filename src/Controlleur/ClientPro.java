package Controlleur;

public class ClientPro {
	
	 
	private String raison, type, nom, prenom , email ,adresse , ville,telephone,cp;
	
	/*public ClientPro ()
	{
	    this.raison="";
	    this.type="";
		this.nom="";
		this.prenom="";
		this.email="";
		this.telephone="";
		this.adresse="";
		this.cp="";
		this.ville="";
		
		}
	public ClientPro(String raison , String type,  String Telephone , String cp ,String nom, String prenom, String email ,String adresse , String ville)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.telephone=telephone;
		this.adresse=adresse;
		this.cp=cp;
		this.ville=ville; 
	}*/
	public ClientPro (String raison , String type , String  nom, String prenom, String email ,String telephone, String adresse ,String cp ,String ville)
	{
		this.raison = raison;
		this.type = type;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
}

		
