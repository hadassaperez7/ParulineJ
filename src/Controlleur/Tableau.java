
package Controlleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	private Object[][] Donnees;    //matrice des donnes 
	private String [] Entete ; // entete de la table 
	
	
     public Tableau (Object [][] Donnees , String [] Entete)
     {
    	 this.Donnees = Donnees; 
    	 this.Entete = Entete; 
		
	}
	@Override
	public int getColumnCount() 
   { 
		// le nb de colonnes ds le tableau entete 
	
		return this.Entete.length;
	}
	
	
	@Override
	public int getRowCount()
	{
		
		// le nb de lignes de la matrice donnes 
		return this.Donnees.length;
		
	}
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		//prendre la valeur au croisement de la ligne / colonne 
		
		return this.Donnees [rowIndex][columnIndex];
	}
	
	public void add(Object ligne [])
	{
		
	//cette methode recoit une ligne et s'ajoute a la matrice donnes 
		
		Object newTable [] [] = new Object [this.Donnees.length+1][ this.Entete.length]; // 2 niveau dc 2 crochet
		for (int i = 0 ; i < this.Donnees.length;  i++)
		{
			newTable [i]= this.Donnees[i]; 
	}
	
		// on ajoute la ligne ds la nvl matrice 
	   newTable [this.Donnees.length]=ligne; 
	   //on recopie la nvl matrice ds donnees 
	   this.Donnees=newTable;
	   //on confirme les changements
	   this.fireTableDataChanged();
	}
	
	public void delete  (int rowIndex)
	{
		// cette methode supprime la ligne dt le num est rowindex
		//on cree dabord la matrice 
		Object newTable [] [] = new Object [this.Donnees.length -1] [ this.Entete.length]; // 2 niveau dc 2 crochet . je dimuniue ds la ligne pas la colonne 7
		int j=0;
		
		for (int i= 0 ; i < this.Donnees.length ; i++)
		{
			if ( rowIndex !=i)
			{
				newTable [j] = this.Donnees[i];
				j++;
			}
		}
 
	   this.Donnees=newTable;
	   //on confirme les changements
	   this.fireTableDataChanged();
	}
	
	public void update (int rowIndex, Object ligne[])
	{
		
		//cette methode permet de mettre a jour une ligne du tableau 
		
		Object newTable [] [] = new Object [this.Donnees.length][ this.Entete.length]; // 2 niveau dc 2 crochet
		
		for (int i = 0 ; i < this.Donnees.length;  i++) // je parcours ligne par ligne
		{
			if (rowIndex==1)
			{
				newTable[i]=ligne;
			}
			else 
			{
				newTable[i]=this.Donnees[i]; 
			}
		}
				
	   //on recopie la nvl matrice ds donnees 
	   this.Donnees=newTable;
	   //on confirme les changements
	   this.fireTableDataChanged();
	}
	public String getColumnName (int column)
	{
		return this.Entete[column];
	}

}