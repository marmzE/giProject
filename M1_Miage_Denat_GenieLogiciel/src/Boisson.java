
public class Boisson {
	private String nom;
	private int prix;
	private int nbUnit�Caf�;
	private int nbUnit�Lait;
	private int nbUnit�Sucre;
	private int nbUniteChoco;
	
	
	public Boisson(String n,int p,int nbc,int nbl,int nbch,int nbs){
		this.nom = n;
		this.prix = p;
		this.nbUniteChoco = nbch;
		this.nbUnit�Caf� = nbc;
		this.nbUnit�Lait = nbl;
		this.nbUnit�Sucre = nbs;
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


	public int getNbUnit�Caf�() {
		return nbUnit�Caf�;
	}


	public void setNbUnit�Caf�(int nbUnit�Caf�) {
		this.nbUnit�Caf� = nbUnit�Caf�;
	}


	public int getNbUnit�Lait() {
		return nbUnit�Lait;
	}


	public void setNbUnit�Lait(int nbUnit�Lait) {
		this.nbUnit�Lait = nbUnit�Lait;
	}


	public int getNbUnit�Sucre() {
		return nbUnit�Sucre;
	}


	public void setNbUnit�Sucre(int nbUnit�Sucre) {
		this.nbUnit�Sucre = nbUnit�Sucre;
	}


	public int getNbUniteChoco() {
		return nbUniteChoco;
	}


	public void setNbUniteChoco(int nbUniteChoco) {
		this.nbUniteChoco = nbUniteChoco;
	}

}
