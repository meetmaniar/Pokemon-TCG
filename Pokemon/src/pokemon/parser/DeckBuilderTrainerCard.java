package pokemon.parser;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardTrainer;

public class DeckBuilderTrainerCard extends DeckBuilderCard {

	
	public static final int TRAINER_STADIUM = 0;
	public static final int TRAINER_SUPPORT = 1;
	public static final int TRAINER_ITEM 	= 2;

	private String 	m_name;
	private int 	m_trainerType;
	private int 	m_abilityId;
	
	public DeckBuilderTrainerCard(String name, int trainerType, int abilityId) {
		
		m_name = name;
		m_trainerType = trainerType;
		m_abilityId = abilityId;
		
	}
	
	public String getName() { return m_name; }
	public int getTrainerType() { return m_trainerType; }
	public int getAbilityId() { return m_abilityId; }
	
	public Card toPlayableCard() {
		
		CardTrainer card = new CardTrainer();
		card.initTrainer(m_name, m_trainerType, m_abilityId);
		
		System.out.println("Trainer; init(" + m_name + ", " + m_trainerType + ", " + m_abilityId + ")");
		
		return card;
	}
	
}

