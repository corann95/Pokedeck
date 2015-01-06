/*
 * pokemon Ex card
 */

public class PokemonExCard extends PokemonCard{
	protected String pokemon_ex_rule;
	public PokemonExCard(String card_name, String card_type, 
			int collector_card_number,String pokemon_type,
			int hp,String pokemon_ex_rule) {
		
		super(card_name, card_type, collector_card_number,
				pokemon_type, hp);
		this.pokemon_ex_rule=pokemon_ex_rule;
	}
	
	public String toString() {
		return ("name:"+this.card_name+" type:"+this.card_type+" energy:"+this.pokemon_type+
				" collector_number:" + this.collector_card_number+" ex_rule:"+this.pokemon_ex_rule+
				" description:"+this.getDescription());
	}
}
