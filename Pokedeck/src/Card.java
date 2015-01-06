
import java.io.Serializable;


public abstract class Card implements Serializable{
	String card_name;
	protected String card_type;
	private String description;
	protected int collector_card_number;
	
	public Card (String card_name, String card_type,
			int collector_card_number ){
		
			this.card_name=card_name;
			this.card_type=card_type;
			this.collector_card_number=collector_card_number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract String toString();

}