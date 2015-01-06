

import java.io.IOException;
import java.util.Scanner;
/*
 * Human Machine Interface
 */

public class Menu {
	
	private Pokedeck pokedeck;
	
	public Menu(Pokedeck pokedeck) {
		this.pokedeck=pokedeck;
	}
	public void showMenu(){
		System.out.println("Menu| Saisissez un chiffre pour lancer une des actions associéés:");
		System.out.println(" 1 - Ajouter une carte");
		System.out.println(" 2 - Ajouter la description d'une carte");
		System.out.println(" 3 - Supprimer une carte");
		System.out.println(" 4 - Consulter la collection de cartes");
		System.out.println(" 5 - Rechercher une carte par nom");
		System.out.println(" 6 - Rechercher des cartes par type");
		System.out.println(" 7 - Sauvegarder la collection de cartes");
		System.out.println(" 8 - Quitter le programme \n");
	}
	/*
	 * Main menu, show options
	 */
	public void executePokedeck (){
		String input;
		Scanner sc = new Scanner(System.in);
		do{	
			showMenu();
			System.out.print("Saisir le chiffre: ");
			input = sc.nextLine(); 

			switch(input){
				
				case "1":
					addCard();
					break;
				case "2":
					addDescription();
					break;
				case "3":
					removeCard();
					break;
				case "4":
					consultCollection();
					break;
				case "5":
					searchCardByName();
					break;
				case "6":
					searchCardByType();
					break;
				case "7":
					try {
						save();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "8":
					System.out.println("Fin du programme !");
					break;
			}
		}while(!input.equals("8"));
	System.out.println("fin");
	}
	/*
	 * submenu for adding a card
	 */
	private void addCard() {
		Scanner s = new Scanner(System.in);
		System.out.println("Ajout| Choisissez un chiffre pour le type de carte: 1-pokemon, 2-energy, 3-trainer, 4-pokemon_ex, 5-pokemon_ex_mega");
		String type_card=s.nextLine(); 
		System.out.println("Ajout| Entrez le nom de la carte :");
		String name=s.nextLine(); 
		System.out.println("Ajout| Entrez le numero de collection:");
		String number=s.nextLine(); 
		int number_int=Integer.parseInt(number); 
		String sub_type;
		if(!type_card.equals("3")){
			System.out.println("Ajout| Entrez le chiffre pour le type d'energy pokemon: 1-grass, 2-water, 3-fire, 4-lightning, 5-psychic, 6-fighting, 7-darkness, 8-metal, 9-fairy, 10-dragon, 11-colorless");
			sub_type =s.nextLine();
			sub_type=returnEnergyByNum(sub_type);
		}
		else{
			System.out.println("Ajout| Choisissez un chiffre pour le type de trainer card: 1-item, 2-supporter, 3-stadium");
			sub_type =s.nextLine();
			sub_type=returnTypeTrainerByNum(sub_type);
		}
		type_card=returnTypeCardByNum(type_card);
		pokedeck.addAndCreateCard(type_card, name, number_int, sub_type, "", 0);
		System.out.println("La carte a bien été enregistrée.");
	}
	/*param: num -> numero of type's choice   
	 * return a string of the Card's type according to the numero
	 */
	private String returnTypeCardByNum(String num){
		switch(num){
			case "1":
				return "pokemon";
			case "2":
				return "energy";
			case "3":
				return "trainer";
			case "4":
				return "pokemon_ex";
			case "5":
				return "pokemon_ex_mega";
			default:
				return "Error: Numero Type Card";	
		}
	}
	/*param: num -> numero of type's choice   
	 * return a string of the energy's type according to the numero
	 */
	private String returnEnergyByNum(String num){
		switch(num){
			case "1":
				return "grass";
			case "2":
				return "water";
			case "3":
				return "fire";
			case "4":
				return "lightning";
			case "5":
				return "psychic";
			case "6":
				return "fighting";
			case "7":
				return "darkness";
			case "8":
				return "metal";
			case "9":
				return "fairy";
			case "10":
				return "dragon";
			case "11":
				return "colorless";
			default:
				return "Error: Numero Energy";	
		}
	}
	/*param: num -> numero of type's choice   
	 * return a string of the trainer's type according to the numero
	 */
	private String returnTypeTrainerByNum(String num){
		switch(num){
			case "1":
				return "item";
			case "2":
				return "supporter";
			case "3":
				return "trainer";
			default:
				return "Error: Type Trainer";	
		}
	}
	/*  
	 * submenu for adding a description (text) to a card
	 */
	private void addDescription() {
		Scanner s = new Scanner(System.in);
		System.out.println("Description| Entrez le nom de la carte que vous voulez décrire:");
		String name=s.nextLine(); 
		System.out.println("Description| Entrez la description:");
		String description=s.nextLine(); 
		pokedeck.addCardDescription(name, description);
	}
	
	private void removeCard() {
		Scanner s = new Scanner(System.in);
		System.out.println("Suppression| Entrez le nom de la carte que vous voulez supprimmer:");
		String name=s.nextLine(); 		
		
		pokedeck.removeCard(name);
		
	}
	
	/*
	 private void updateCard(){
		Scanner s = new Scanner(System.in);
		System.out.println("MAJ type| Entrez le nom de la carte que vous voulez mettre à jour:");
		String name=s.nextLine(); 
		System.out.println("MAJ type| Entrez le nouveau nom:");
	}
	*/
	
	/*   
	 * show all cards
	 */
	private void consultCollection() {
		pokedeck.consultCollection();
	}
	
	/*param: type_or_name= string "card_name" or "card_type"
	 * value_type_name= string, card name that we want search
	 * show cards associating to the value in input
	 */
	private void searchCardByAttribute(String type_Or_name,String value_type_name) {
		pokedeck.searchCardByAttribute(type_Or_name, value_type_name);
	}
	/*
	 * show cards associating to the name in input
	 */
	private void searchCardByName(){
		System.out.println("Rechercher| Entrez le nom de la carte que vous voulez consulter");
		Scanner s = new Scanner(System.in);
		String value_name=s.nextLine();
		searchCardByAttribute("card_name",value_name);
	}
	/*
	 * show cards associating to the type in input
	 */
	private void searchCardByType(){
		System.out.println("Rechercher| Entrez le nom du type que vous voulez consulter: 1-pokemon, 2-energy, 3-trainer, 4-pokemon_ex, 5-pokemon_ex_mega");
		Scanner s = new Scanner(System.in);
		String value_type=s.nextLine();
		value_type=returnTypeCardByNum(value_type);
		searchCardByAttribute("card_type",value_type);
	}
	/*
	 * save the collection in a file
	 */
	private void save() throws IOException {
		pokedeck.save();
	}
	
	
}
