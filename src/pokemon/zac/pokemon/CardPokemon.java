package zac.pokemon;

import java.util.LinkedList;

public class CardPokemon extends Card{

	private static final int POKEMON_BASIC = 0;
	private static final int POKEMON_STAGEONE = 1;
	private static final int ACTION_ATTACK = 0;
	private static final int ACTION_RETREAT = 1;
	private static final int STATUS_EFFECT_NULL = 0;
	public static final int STATUS_EFFECT_PARALYZED = 1;
	public static final int STATUS_EFFECT_ASLEEP = 2;
	public static final int STATUS_EFFECT_STUCK = 3;
	public static final int STATUS_EFFECT_POISONED = 4;
	
	String 									m_name;
	int 									m_pokemonType;
	int 									m_hp;
	int										m_retreatCost;
	int										m_statusEffect;
	LinkedList<CardEnergy> 					m_energyCards;
	CardPokemonAttack						m_attack;
	boolean									m_active;
	String									m_evolve;
	
	public CardPokemon(String name, int pokemonType, int hp, int retreatCost, String evolve,  int energyType, int energyBasicCost,int energyAdvanceCost, int energyCostColorless) {
		
		super(Card.TYPE_POKEMON);
		
		m_name = name;
		m_pokemonType = pokemonType;
		m_hp = hp;
		m_retreatCost = retreatCost;
		m_energyCards = new LinkedList<CardEnergy>();
		m_attack = new CardPokemonAttack(energyType, energyBasicCost, energyAdvanceCost, energyCostColorless);
		m_evolve = evolve;
		
	}
	
	public void addEnergy(CardEnergy energy) {

	
		m_energyCards.add(energy);		
		
		
	}
	
	public void attackBasic(CardPokemon opponent){
		
		// Check if we can attack or not.
		if (!validateAction(ACTION_ATTACK)) {
			System.out.println("not able to attack");
		}
		else{
			m_attack.attackBasic(this, opponent);
		}
	}
	
	public void attackAdvance(CardPokemon opponent){
		
		// Check if we can attack or not.
		if (!validateAction(ACTION_ATTACK)) {
			System.out.println("not able to attack");
		}
		else{
			m_attack.attackAdvance(this, opponent);
		}
	}
	
	
	void retreat() {
		
		// Check if we can retreat or not.
		if (!validateAction(ACTION_RETREAT)) {
			
			System.out.println("Not able to retreat");
		}
		else{
			
			// Retreat.
			int accumulatedEnergy = m_energyCards.size() * 10;
			if(accumulatedEnergy >= m_retreatCost){
				for(int i = 0; i <= m_retreatCost/10; i++){
					m_energyCards.removeLast();
				}
				m_active = false;
				removeStatus();
				
			}
			else{
				System.out.println("Not enough energy to retreat");
			}
			
		}
	}
	
	boolean validateAction(int actionType) {
		
		switch(m_statusEffect) {
			
		case STATUS_EFFECT_PARALYZED:
				if (actionType == ACTION_ATTACK) { return false; }
				if (actionType == ACTION_RETREAT) { return false; }
				return true;
				
			case STATUS_EFFECT_ASLEEP:
				if (actionType == ACTION_ATTACK) { return false; }
				if (actionType == ACTION_RETREAT) { return false; }
				return true;
						
			case STATUS_EFFECT_STUCK:
				if (actionType == ACTION_RETREAT) { return false; }
				return true;
				
			case STATUS_EFFECT_POISONED:
				return true;
		
			default:
				return true;
				
		}
	}
		
	void removeStatus(){
		switch(m_statusEffect) {
			
		case STATUS_EFFECT_PARALYZED:
				m_statusEffect = 0;
					
			case STATUS_EFFECT_ASLEEP:
				m_statusEffect = 0;
							
			case STATUS_EFFECT_STUCK:
				m_statusEffect = 0;
					
			case STATUS_EFFECT_POISONED:
				m_statusEffect = 0;
			
			default:
				m_statusEffect = 0;
		}
	
	}
	
	
}
