import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String res;
		System.out.println("Bonjour");
		Machine m = new Machine();
		while(true){
			res="";
			String un="1";
			String deux="2";
			String trois="3";
			String quatre="4";
			String cinq="5";
			String six="6";
			
			int resINt =0;
			while(!res.equals(un) && !res.equals(deux) && !res.equals(trois) && !res.equals(quatre) && !res.equals(cinq) && !res.equals(six)){
				System.out.println("Que voulez vous faire ?");
				System.out.println("1. Acheter une boisson");
				System.out.println("2. Modifier une boisson");
				System.out.println("3. Ajouter une boisson");
				System.out.println("4. Supprimer une boisson");
				System.out.println("5. Ajouter Ingredients");
				System.out.println("6. Verifier Stock");
			
				res =sc.nextLine();
				System.out.println(res);
			}
			
			if(res.equals(un)){
				m.acheterBoisson();
			}
			if(res.equals(deux)){
				m.modifierUneBoisson();
			}
			if(res.equals(trois)){
				m.ajouterUneBoisson();
			}
			if(res.equals(quatre)){
				m.supprimerBoisson();
			}
			if(res.equals(cinq)){
				m.ajouterIngredient();
			}
			if(res.equals(six)){
				m.verifierStock();
			}
	}
	}

}
