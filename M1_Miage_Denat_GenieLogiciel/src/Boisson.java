
public class Boisson {
	private String nom;
	private int prix;
	private int nbUnitéCafé;
	private int nbUnitéLait;
	private int nbUnitéSucre;
	private int nbUniteChoco;
	
	
	public Boisson(String n,int p,int nbc,int nbl,int nbch,int nbs){
		this.nom = n;
		this.prix = p;
		this.nbUniteChoco = nbch;
		this.nbUnitéCafé = nbc;
		this.nbUnitéLait = nbl;
		this.nbUnitéSucre = nbs;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getNbUnitéCafé() {
		return nbUnitéCafé;
	}


	public void setNbUnitéCafé(int nbUnitéCafé) {
		this.nbUnitéCafé = nbUnitéCafé;
	}


	public int getNbUnitéLait() {
		return nbUnitéLait;
	}


	public void setNbUnitéLait(int nbUnitéLait) {
		this.nbUnitéLait = nbUnitéLait;
	}


	public int getNbUnitéSucre() {
		return nbUnitéSucre;
	}


	public void setNbUnitéSucre(int nbUnitéSucre) {
		this.nbUnitéSucre = nbUnitéSucre;
	}


	public int getNbUniteChoco() {
		return nbUniteChoco;
	}


	public void setNbUniteChoco(int nbUniteChoco) {
		this.nbUniteChoco = nbUniteChoco;
	}

}
