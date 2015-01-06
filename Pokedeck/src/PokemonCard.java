

public class PokemonCard extends Card{
	public String pokemon_type;
	private int stage;
	private int hp;
	private String evolves_from_pokemon;
	private String[] listAttack = new String[2];
	
	
	public PokemonCard(String card_name, String card_type, 
			int collector_card_number,String pokemon_type,int hp){
		
		super(card_name, card_type, collector_card_number);
		this.card_type=card_type;
		this.pokemon_type=pokemon_type;
		this.hp=hp;
	}
	
	public String toString() {
		return ("name:"+this.card_name+" type:"+this.card_type+" energy:"+this.pokemon_type+
				" collector_number:" + this.collector_card_number+" description:"+this.getDescription());
	}
}
