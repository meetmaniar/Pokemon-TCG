package pokemon.CoreClasses;

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


	public String 									m_name;
	public int 										m_pokemonType;
	public int 										m_hp;
	public int										m_retreatCost;
	public int										m_statusEffect;
	public LinkedList<CardEnergy> 					m_energyCards;
	public CardPokemonAttack						m_attack;
	public AbilityPokemon							m_abilityPokemon;
	public boolean									m_active;
	public String									m_evolve;
	public int 										m_energy;
	public int										m_adv_attack;

	public CardPokemon()
	{
		super(0);
		System.out.println("Poke Init Done");
		
	}
	
	
//	public CardPokemon(String name, int pokemonType, int hp, int retreatCost, String evolve,  int energyType, int energyBasicCost,int energyAdvanceCost, int energyCostColorless) {
//
//		super(Card.TYPE_POKEMON);
//
//		m_name = name;
//		m_pokemonType = pokemonType;
//		m_hp = hp;
//		m_retreatCost = retreatCost;
//		m_energyCards = new LinkedList<CardEnergy>();
//		m_attack = new CardPokemonAttack(energyType, energyBasicCost, energyAdvanceCost, energyCostColorless);
//		m_evolve = evolve;
//
//	}
	
	public void initPokemon(String name, int pokemonType, int energyType, int advanceEnergy, int HP , int retreatCost, int attacktype1, int energyBasicCost, int colorless1, int colorless1Cost, int ability1, int attacktype2, int energyAdvanceCost, int colorless2, int colorless2Cost, int ability2)
	{
		m_name=name;
		m_pokemonType = pokemonType;
		m_energy=energyType;
		m_adv_attack=advanceEnergy;
		m_hp=HP;
		m_retreatCost = retreatCost;
		m_energyCards = new LinkedList<CardEnergy>();
		m_attack = new CardPokemonAttack(attacktype1, energyBasicCost, colorless1, colorless1Cost, ability1, attacktype2, energyAdvanceCost, colorless2, colorless2Cost, ability2 );
		m_abilityPokemon = new AbilityPokemon();
		
		
	}

	public void addEnergy(CardEnergy energy) {

		m_energyCards.add(energy);
		m_energy = m_energy + 10;
	}

	public void attackBasic(Play p, CardPokemon opponent){

		// Check if we can attack or not.
		if (!validateAction(ACTION_ATTACK)) {
			System.out.println("not able to attack");
		}
		else{
			m_attack.attackBasic(p, this, opponent);
		}
	}

	public void attackAdvance(Play p, CardPokemon opponent){

		// Check if we can attack or not.
		if (!validateAction(ACTION_ATTACK)) {
			System.out.println("not able to attack");
		}
		else{
			m_attack.attackAdvance(p, this, opponent);
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
			if(accumulatedEnergy >= m_retreatCost * 10){
				for(int i = 0; i <= m_retreatCost; i++){
					m_energyCards.removeLast();
					m_energy = m_energy - 10;
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

	
	public void paralize(CardPokemon opponent){
		opponent.m_statusEffect = 1;
	}
	public void fallasleep(CardPokemon opponent){
		opponent.m_statusEffect = 2;
	}
	public void stuck(CardPokemon opponent){
		opponent.m_statusEffect = 3;
	}
	public void poison(CardPokemon opponent){
		opponent.m_hp = opponent.m_hp - 10;
	}
}


