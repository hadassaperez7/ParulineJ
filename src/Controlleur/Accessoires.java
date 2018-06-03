package Controlleur;

public class Accessoires {
	
	private String nom, description;
	private int idAccessoire, stock;
	
	public Accessoires (String nom, String description,int  stock, int idAccessoire)
	{
		this.nom = nom;
		this.description = description;
		this.stock = stock;
		this.idAccessoire = idAccessoire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getidAccessoire() {
		return idAccessoire;
		}
	public void setidAccessoire (int idAccessoire){
			idAccessoire=idAccessoire;
		}
}

