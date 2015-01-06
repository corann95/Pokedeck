

public class TrainerCard extends Card{
	//textbox = description
	private String trainer_type;
	private String trainer_rule;
	
	public TrainerCard(String card_name, String card_type, 
			int collector_card_number,String trainer_type,
			String trainer_rule) {
		
		super(card_name, card_type, collector_card_number);
		this.trainer_type=trainer_type;
		this.trainer_rule=trainer_rule;
	}
	
	@Override
	public String toString() {
		return ("name:"+this.card_name+" type:"+this.card_type+" collector_number:" +
	this.collector_card_number+" trainer_type:"+this.trainer_type+" rule:"+this.trainer_rule+
	" description:"+this.getDescription());
	}
}
