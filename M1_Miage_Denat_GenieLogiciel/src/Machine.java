import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Machine {
	private int stockSucre;
	private int stockLait;
	private int stockChocolat;
	private int stockCafe;
	private String etat;
	private final int NBBoisson= 3;
	private int nbBoissonActuel;
	private ArrayList<Boisson> listBoisson;
	private final String zero="0";
	private final String un="1";
	private final String deux="2";
	private final String trois="3";
	
	public Machine(){
		this.stockCafe=100;
		this.stockChocolat=100;
		this.stockLait=100;
		this.stockSucre=100;
		this.etat = "vide";
		this.nbBoissonActuel=0;
		this.listBoisson = new ArrayList<Boisson>();
	}
	
	public int getStockSucre() {
		return stockSucre;
	}

	public void setStockSucre(int stockSucre) {
		this.stockSucre = stockSucre;
	}

	public int getStockLait() {
		return stockLait;
	}

	public void setStockLait(int stockLait) {
		this.stockLait = stockLait;
	}

	public int getStockChocolat() {
		return stockChocolat;
	}

	public void setStockChocolat(int stockChocolat) {
		this.stockChocolat = stockChocolat;
	}

	public int getStockCafe() {
		return stockCafe;
	}

	public void setStockCafe(int stockCafe) {
		this.stockCafe = stockCafe;
	}

	public void acheterBoisson(){
		if(this.etat == "attente"){
			Scanner sc = new Scanner(System.in);
			System.out.println("Voici les boissons présentes : ");
			for(int i=0; i<this.listBoisson.size();i++){
				System.out.println(i+". "+this.listBoisson.get(i).getNom());
			}
			System.out.println("\n\n");
			if(!this.listBoisson.isEmpty()){
				System.out.println("Tape le numéro devant la boisson que tu veux : (allant de 0 à "+(this.listBoisson.size()-1)+")");
				int res=Integer.parseInt(sc.nextLine());
				while(res >= this.nbBoissonActuel || res < 0){
					System.out.println("Essaye encore, Tape le numéro devant la boisson que tu veux : (allant de 0 à "+(this.listBoisson.size()-1)+")");
					res=Integer.parseInt(sc.nextLine());
				}
				if(CheckQuantité()){
					System.out.println("Veuillez inserer : "+this.listBoisson.get(res).getPrix());
					int monnaie = sc.nextInt()-this.listBoisson.get(res).getPrix();
					System.out.println("Voila la monaiie !\n"+monnaie);
					
					
				}
				else{
					System.out.println("Quantité insuffisante, il faut remplir la machine");
				}
			}
			else{
				System.out.println("Pas de boisson, ajoute en avant");
			}
			
		}
		else{
			System.out.println("Pas de boisson, ajoute en avant");
		}
		System.out.println();
	}
	
	private boolean CheckQuantité() {	
		return true;
	}

	
	public void ajouterUneBoisson(){
		int resLait=0;
		int resSucre=0;
		int resChoco=0;
		int resCafe=0;
		
		if(this.nbBoissonActuel<this.NBBoisson){
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez précisez le nom de cette nouvelle boisson :");
			String resNom =sc.nextLine();
			while(existeDeja(resNom)){
				System.out.println("Désolé, ce nom de boisson existe déjà,\n veuillez en choisir un autre :");
				resNom =sc.nextLine();
			}
			System.out.println("\n\n");
			
			int total = 0;
			while(total<1){
				//Quantité sucre
				System.out.println("Veuillez a présent rentrer la quantité de sucre pour cette boisson : (Valeur allant de 0 à 3)");
				String resSucreS =sc.nextLine();
				while(!resSucreS.equals(zero) && !resSucreS.equals(un) && !resSucreS.equals(deux) && !resSucreS.equals(trois)){
					System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
					resSucreS=sc.nextLine();
				}
				System.out.println("\n\n");
				
				//Quantité café
				System.out.println("Veuillez a présent rentrer la quantité de café pour cette boisson : (Valeur allant de 0 à 3)");
				String resCafeS =sc.nextLine();
				while(!resCafeS.equals(zero) && !resCafeS.equals(un) && !resCafeS.equals(deux) && !resCafeS.equals(trois)){
					System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
					resCafeS=sc.nextLine();
				}
				System.out.println("\n\n");
				
				//Quantité chocolat
				System.out.println("Veuillez a présent rentrer la quantité de chocolat pour cette boisson : (Valeur allant de 0 à 3)");
				String resChocoS =sc.nextLine();
				while(!resChocoS.equals(zero) && !resChocoS.equals(un) && !resChocoS.equals(deux) && !resChocoS.equals(trois)){
					System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
					resChocoS = sc.nextLine();
				}
				System.out.println("\n\n");
				
				//Quantité lait
				System.out.println("Veuillez a présent rentrer la quantité de lait pour cette boisson : (Valeur allant de 0 à 3)");
				String resLaitS =sc.nextLine();
				while(!resLaitS.equals(zero) && !resLaitS.equals(un) && !resLaitS.equals(deux) && !resLaitS.equals(trois)){
					System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
					resLaitS = sc.nextLine();
				}
				System.out.println("\n\n");
			
			
			total = Integer.parseInt(resLaitS)+Integer.parseInt(resChocoS)+Integer.parseInt(resCafeS);
			if(total==0){
				System.out.println("attention !! les valeurs de votre boisson sont interdit \n\n");
			}
			
		}
			//prix
			System.out.println("Pour finir veuillez rentrer le nouveau prix entier de la boisson : ");
			int resPrix =sc.nextInt();
			System.out.println("\n\n");
			
			//ajout de la boisson dans la machine
			Boisson b = new Boisson(resNom,resPrix,resCafe,resLait,resChoco,resSucre);
			this.listBoisson.add(b);
			System.out.println("Ajout de la boisson dans la machine");
			
			//changement d'etat de la machine
			if(this.listBoisson.size() == 1){
				this.etat = "attente";
			}
			
			this.nbBoissonActuel++;
			System.out.println("\n\n");
			}
		else{
			System.out.println("Désolé, il y a déjà 3 boissons\n pour en rajouter une nouvelle veuillez en supprimer une autre \n merci.\n\n");
		}	
	}
	
	private boolean existeDeja(String res) {
		boolean trouve = false;
		for(int i = 0; i< this.listBoisson.size();i++){
			if(this.listBoisson.get(i).getNom().equals(res)){
				trouve = true;
			}
		}
		return trouve;
	}

	public void modifierUneBoisson(){
		int resLait=0;
		int resSucre=0;
		int resChoco=0;
		int resCafe=0;
			
	
		Scanner sc = new Scanner(System.in);
		
		if(!this.listBoisson.isEmpty()){
			System.out.println("Voici les boissons présentes : ");
			for(int i=0; i<this.listBoisson.size();i++){
				System.out.println(i+". "+this.listBoisson.get(i).getNom());
			}
			System.out.println("Veuillez rentrer le numéro devant la boisson que vous voulez modifier,\n si votre valeur entrée est incorrect, il y aura un retour Acceuil :");
			int resNb =Integer.parseInt(sc.nextLine());
			if(resNb <= this.nbBoissonActuel-1 && resNb >= 0){
				
				int total = 0;
				while(total<1){
					//Quantité sucre
					System.out.println("Veuillez a présent rentrer la quantité de sucre pour cette boisson : (Valeur allant de 0 à 3)");
					String resSucreS =sc.nextLine();
					while(!resSucreS.equals(zero) && !resSucreS.equals(un) && !resSucreS.equals(deux) && !resSucreS.equals(trois)){
						System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
						resSucreS = sc.nextLine();
					}
					System.out.println("\n\n");
					
					//Quantité café
					System.out.println("Veuillez a présent rentrer la quantité de café pour cette boisson : (Valeur allant de 0 à 3)");
					String resCafeS =sc.nextLine();
					while(!resCafeS.equals(zero) && !resCafeS.equals(un) && !resCafeS.equals(deux) && !resCafeS.equals(trois)){
						System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
						resCafeS = sc.nextLine();
					}
					System.out.println("\n\n");
					
					//Quantité chocolat
					System.out.println("Veuillez a présent rentrer la quantité de chocolat pour cette boisson : (Valeur allant de 0 à 3)");
					String resChocoS =sc.nextLine();
					while(!resChocoS.equals(zero) && !resChocoS.equals(un) && !resChocoS.equals(deux) && !resChocoS.equals(trois)){
						System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
						resChocoS = sc.nextLine();
					}
					System.out.println("\n\n");
					
					//Quantité lait
					System.out.println("Veuillez a présent rentrer la quantité de lait pour cette boisson : (Valeur allant de 0 à 3)");
					String resLaitS =sc.nextLine();
					while(!resLaitS.equals(zero) && !resLaitS.equals(un) && !resLaitS.equals(deux) && !resLaitS.equals(trois)){
						System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 3)");
						resLaitS = sc.nextLine();
					}
					System.out.println("\n\n");
				
				
					total = Integer.parseInt(resLaitS)+Integer.parseInt(resChocoS)+Integer.parseInt(resCafeS);
					if(total==0){
						System.out.println("attention !! les valeurs de votre boisson sont interdit \n\n");
					}
				}//fin while
			
				//prix
				System.out.println("Pour finir veuillez rentrer le nouveau prix entier de la boisson : ");
				int resPrix =sc.nextInt();
				System.out.println("\n\n");
				
				String resNom = this.listBoisson.get(resNb).getNom();
				this.listBoisson.remove(resNb);
				//ajout de la boisson dans la machine
				Boisson b = new Boisson(resNom,resPrix,resCafe,resLait,resChoco,resSucre);
				this.listBoisson.add(b);
				System.out.println("Modification de la boisson dans la machine");
			}
			else{
				System.out.println("Valeur Incorrecte");
			}
			
		}
		else{
			System.out.println("boisson vide veuillez rentrer une boisson avant\n\n");
		}
	}
	
	
	public void supprimerBoisson(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Voici les boissons présentes : ");
		for(int i=0; i<this.listBoisson.size();i++){
			System.out.println(i+". "+this.listBoisson.get(i).getNom());
		}
		if(!this.listBoisson.isEmpty()){
			System.out.println("Veuillez rentrer le numéro devant la boisson que vous voulez supprimer,\n si votre valeur entrée est incorrect, il y aura un retour Acceuil :");
			int resNb =Integer.parseInt(sc.nextLine());
			if(resNb <= this.nbBoissonActuel-1 && resNb >= 0){
				this.listBoisson.remove(this.listBoisson.get(resNb));
				this.nbBoissonActuel= this.nbBoissonActuel-1;
				System.out.println("Boisson supprimée");
				if(this.listBoisson.isEmpty()){
					this.etat="vide";
					System.out.println("et il n'y a plus de boisson dans la machine");
				}
			}
			else{
				System.out.println("valeur incorrect -> retour acceuil");
			}
			
		}
		else{
			System.out.println("Il n'y a pas de boisson a supprimer");
		}
		
		
		}
	
	public int ajouterIngredient(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Quels ingrédient voulez vous ajouter ?");
		System.out.println("Tapez 1 pour Sucre");
		System.out.println("Tapez 2 pour Cafe");
		System.out.println("Tapez 3 pour Chocolat");
		System.out.println("Tapez 4 pour Lait");
		System.out.println("Tapez 0 pour quitter le menu");
		String res = sc.nextLine();
		if(res.equals("0")){
			return 0;
		}
		else{
			while(!res.equals("1") && !res.equals("2") && !res.equals(3) && !res.equals("4")){
				System.out.println("Valeur incorrecte, veuillez recommencez : (Valeur allant de 0 à 4)");
				res = sc.nextLine();
				if(res == "0"){
					System.out.println("\n\n");
					return 0;
				}
				
			}
			String choix = "";
			switch (Integer.parseInt(res)){
			case 1:
				choix = "Sucre";
				this.stockSucre+=25;
				break;
			case 2:
				choix = "Cafe";
				this.stockCafe+=25;
				break;
			case 3:
				choix = "Chocolat";
				this.stockChocolat+=25;
				break;
			case 4:
				choix = "Lait";
				this.stockLait+=25;
				break;
			}
			System.out.println("Vous venez de remplir la machine de 25 unités de "+choix+"\n\n");
			return 1;
		}
		
	}
	
	public void verifierStock(){
		System.out.println("Stock :");
		System.out.println("- Sucre : "+this.stockSucre);
		System.out.println("- Cafe : "+this.stockCafe);
		System.out.println("- Lait : "+this.stockLait);
		System.out.println("- Chocolat : "+this.stockChocolat +"\n\n");
	}
	
	
}
