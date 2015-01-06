
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Pokedeck implements Serializable{
	private ArrayList<Card> cards_list;
	
	public Pokedeck (){
		this.cards_list= new ArrayList<Card>();
		initialize();
	}
	/*param: card_type, card_name, collector_card_name = properties of the card
	 * function for create a card and add it to the collection
	 */
	public void addAndCreateCard(String card_type,String card_name,int collector_card_number,
			String type_name, String rule, int hp ){
		System.out.println("create card");
		Card card =null;
		card = returnCardByType(card_type, card_name, collector_card_number,type_name,
				rule, hp);
		System.out.println(card);
		this.cards_list.add(card);
	}
	/*
	 * Function for testing and debug easily, initialize the collection with some cards
	 */
	public void initialize(){
		Card carda = new PokemonCard("pokemonTest", "pokemon", 1,"fire",3);
		Card cardb = new TrainerCard("trainerTest", "trainer", 2,"item","");
		Card cardc = new EnergyCard("energyTest","energy", 4,"1");
		this.cards_list.add(carda);
		this.cards_list.add(cardb);
		this.cards_list.add(cardc);

	}
	/*param: card_name = name of the card, description = text description
	 * Function for adding a description (text) to the card
	 */
	public void addCardDescription(String card_name, String description){
		
		for(Card card: this.cards_list)
	    {
	     	if (card.card_name.equals(card_name)){
	     		card.setDescription(description);
	     		System.out.println(card.card_name+" "+card.getDescription());
	     	}
	    }
	}
	
	public void removeCard(String card_name){
		for(Card card: this.cards_list)
	    {
	     	if (card.card_name.equals(card_name)){
	     		System.out.println(card.card_name);
	     		this.cards_list.remove(card);
	     	}
	    }
	}
	//not used
	public void updateCard(String card_name,String changed_name,String type, String description){
		
		for(Card card: this.cards_list)
		{
			if (card.card_name.equals(card_name)){ 
				System.out.println(card.card_name);
				card.card_name=changed_name;
				card.card_type=type;
				card.setDescription(description);
			}
		}
	}
	/*
	 * show all cards
	 */
	public void consultCollection(){
		System.out.println("Liste de cartes:");
		for(Card card: this.cards_list)
		{		
			System.out.println(card.toString());
			System.out.println("----");		
		}
	}
	/*param: type_or_name= string "card_name" or "card_type"
	 * value_type_name= string, card name that we want search
	 * show cards associating to the value in input
	 */
	public void searchCardByAttribute(String type_Or_name, String value_type_name){
		System.out.println("Voici la carte:");
			switch(type_Or_name){
				case "card_name":
					for(Card card: this.cards_list)
					{	
						if (card.card_name.equals(value_type_name)){ 
							System.out.println(card.toString());
						}
					}
					break;
				
				case "card_type":
					for(Card card: this.cards_list)
					{System.out.println(value_type_name);
						if (card.card_type.equals(value_type_name)){ 
							System.out.println(card.toString());
						}
					}
					break;
					
				default :
					System.out.println("Error: type or name");
					break;
		}
	}
	/*
	 * save the collection in a file
	 */
	public void save() throws IOException{
		//System.out.println(this);
		Pokedeck p = this;
		FileOutputStream fos = new FileOutputStream("pokedeck.serial");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(p); 
		oos.flush();
		System.out.println("Le pokedeck est sauvegarder dans le fichier pokedeck.serial");
	}
	/*
	 * return a card object according type, the card's properties are initialized by inputs
	 */
	public Card returnCardByType(String card_type,String card_name,int collector_card_number,
			String type_name, String rule, int hp){	

		Card card = null;
		switch(card_type){

			case "pokemon":
				card = new PokemonCard(card_name, card_type, collector_card_number,
						type_name, hp);
				break;

			case "energy":
				card = new EnergyCard(card_name, card_type, collector_card_number,
						type_name);
				break;

			case "trainer":
				card = new TrainerCard(card_name, card_type, collector_card_number,
						type_name, rule);
				break;

			case "pokemon_ex":
				card = new PokemonExCard(card_name, card_type,collector_card_number, 
						type_name, hp, rule);
				break;

			case "pokemon_ex_mega":
				card = new PokemonExMegaCard(card_name, card_type,collector_card_number, 
						type_name, hp, rule);
				break;

			default:
				System.out.println("Error: Card's type ");
				break;
		}
		return card;
	}
	

}
