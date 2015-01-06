

public class EnergyCard extends Card{
	private String energy_type;
	
	public EnergyCard(String card_name, String card_type, int collector_card_number,
			String energy_type) {
		super(card_name, card_type, collector_card_number);
		this.energy_type=energy_type;
	}

	@Override
	public String toString() {
		return ("name:"+this.card_name+" type:"+this.card_type+" energy_type:"+this.energy_type +
				" collector_number:" +this.collector_card_number+" description:"+this.getDescription());
	}
}
