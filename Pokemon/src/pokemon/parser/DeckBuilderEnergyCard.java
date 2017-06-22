package pokemon.parser;
import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardTrainer;

public class DeckBuilderEnergyCard extends DeckBuilderCard {

	public static final int ENERGY_WATER 	= 0;
	public static final int ENERGY_LIGHTING = 1;
	public static final int ENERGY_PSYCHIC 	= 2;
	public static final int ENERGY_FIGHTING = 3;
	public static final int ENERGY_COLORLESS = 4;
	
	int m_color;
	
	public DeckBuilderEnergyCard(int color) {
		
		m_color = color;
		
	}
	
	public int getColor() { return m_color; }

	public Card toPlayableCard() {
		
		System.out.println("Energy; init(" + m_color + ")");

		CardEnergy card = new CardEnergy();
		card.initEnergy(m_color);
		return card;
		
	}
	
}

