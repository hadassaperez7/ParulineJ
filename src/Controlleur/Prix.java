package Controlleur;

public class Prix {
	
	private String nomProduit,nomFournisseur, referenceProduit;
	private int idProduit;
    private float prixFournisseur, prixPondere, margeMonetiare, coefficient,
    prixTotal;
    
    public Prix(int idProduit, String nomProduit, String nomFournisseur,
    	String referenceProduit,
		float prixFournisseur, float prixPondere, float margeMonetiare,float coefficient, float prixTotal)
    {
    	this.idProduit = idProduit;
    	this.nomProduit = nomProduit;
    	this.nomFournisseur = nomFournisseur;
    	this.referenceProduit = referenceProduit;
    	this.prixFournisseur = prixFournisseur;
    	this.prixPondere = prixPondere;
    	this.margeMonetiare = margeMonetiare;
    	this.coefficient = coefficient;
    	this.prixTotal = prixTotal;
    }

    public Prix (int idProduit, String referenceProduit, Float prixFournisseur, Float coefficient) {
    	this.idProduit = idProduit;
    	this.referenceProduit = referenceProduit;
    	this.prixFournisseur = prixFournisseur;
    	this.coefficient = coefficient;
	}



	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(String referenceProduit) {
		this.referenceProduit = referenceProduit;
	}

	public float getPrixFournisseur() {
		return prixFournisseur;
	}

	public void setPrixFournisseur(float prixFournisseur) {
		this.prixFournisseur = prixFournisseur;
	}

	public float getPrixPondere() {
		return prixPondere;
	}

	public void setPrixPondere(float prixPondere) {
		this.prixPondere = prixPondere;
	}

	public float getMargeMonetiare() {
		return margeMonetiare;
	}

	public void setMargeMonetiare(float margeMonetiare) {
		this.margeMonetiare = margeMonetiare;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient( float coefficient) {
		this.coefficient = coefficient;
	}

	public float  getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

}
