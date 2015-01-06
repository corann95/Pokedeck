/*
* Mega-evolution card
*/

public class PokemonExMegaCard extends PokemonExCard{
	
	private String mega_evolution_rule;
	
	public PokemonExMegaCard(String card_name, String card_type,
			int collector_card_number, String pokemon_type, int hp,
			String pokemon_ex_rule) {
		super(card_name, card_type, collector_card_number, pokemon_type, hp,
				pokemon_ex_rule);
		this.setMega_evolution_rule(null);
	}

	public String getMega_evolution_rule() {
		return mega_evolution_rule;
	}

	public void setMega_evolution_rule(String mega_evolution_rule) {
		this.mega_evolution_rule = mega_evolution_rule;
	}
	

	public String toString() {
		return ("name:"+this.card_name+" type:"+this.card_type+" collector_number:" +
	this.collector_card_number+" ex_rule:"+this.pokemon_ex_rule+" mega_rule:"+this.mega_evolution_rule+
	" description:"+this.getDescription());
	}
	
	

}
