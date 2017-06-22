package pokemon.parser;

import java.util.LinkedList;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardPokemon;

public class DeckBuilderPokemonCard extends DeckBuilderCard {
	
	public class DeckBuilderPokemonCardAttack {
		
		private int m_attackColor;
		private int m_attackCost;
		
		private int m_colorless;
		private int m_colorlessCost;
		
		private int m_abilityId;
		
		public DeckBuilderPokemonCardAttack() {
			m_attackColor = -1;
			m_attackCost = 0;
			
			m_abilityId = 0;
			
			m_colorless = -1;
			m_colorlessCost = 0;
		}
		
		public int getColor() { return m_attackColor; }
		public int getCost() { return m_attackCost; }
		public int getAbilityId() { return m_abilityId; }
		public int getColorlessCost() { return m_colorlessCost; }
		public int getColorless() { return m_colorless; }
		
		public void setColorless(int cost) { m_colorless = 1; m_colorlessCost = cost; }
		public void setEnergy(int energyType, int cost) { m_attackColor = energyType; m_attackCost = cost; }
		public void setkAbilityId(int abilityId) { m_abilityId = abilityId; }
		
	}

	private String m_name;
	private String m_evolved;
	private int	   m_color;
	private int	   m_hp;
	
	private int	   m_retreatColor;
	private int	   m_retreatCost;
	
	private LinkedList<DeckBuilderPokemonCardAttack> m_attacks;
	
	public DeckBuilderPokemonCard() {
		
		m_attacks = new LinkedList<DeckBuilderPokemonCardAttack>();
	}
	
	public void addPokemonInformation(String name, String evolved, int color, int hp) {
		
		m_name = name;
		m_evolved = evolved;
		m_color = color;
		m_hp = hp;
		
	}
	
	public void addPokemonRetreatInformation(int retreatColor, int retreatCost) {
		
		m_retreatColor = retreatColor;
		m_retreatCost = retreatCost;
	}
	
	
	public String getName() { return m_name; }
	public String getEvolved() { return m_evolved; }
	public int 	  getColor() { return m_color; }
	public int 	  getHp() { return m_hp; }
	
	public int getRetreatColor() { return m_retreatColor; }
	public int getRetreatCost() { return m_retreatCost; }
	public LinkedList<DeckBuilderPokemonCardAttack> getAttacks() { return m_attacks; }
	
	public Card toPlayableCard() {
			

		String name = m_name;
		int pokemonType;
		if (m_evolved == null) { pokemonType = 0; } else { pokemonType = 1; };
		int energyType = m_color;
		int advanceEnergy = 0; // TODO!
		int HP = m_hp;
		
		int attacktype1 = m_attacks.get(0).getColor();
		int energyBasicCost = m_attacks.get(0).getCost();
		int colorless1 = m_attacks.get(0).getColorless();
		int colorless1Cost = m_attacks.get(0).getColorlessCost();
		int ability1 = m_attacks.get(0).getAbilityId();
		
		int attacktype2 = -1;
		int energyAdvanceCost = 0;
		int colorless2 = -1;
		int colorless2Cost = 0;
		int ability2 = 0;
		
		if (m_attacks.size() > 1) {
			attacktype2 = m_attacks.get(1).getColor();
			energyAdvanceCost = m_attacks.get(1).getCost();
			colorless2 = m_attacks.get(1).getColorless();
			colorless2Cost = m_attacks.get(1).getColorlessCost();
			ability2 = m_attacks.get(1).getAbilityId();
		}
		
		int retreatCost = m_retreatCost;
		
		
		System.out.println("Pokemon; init(" + name + ", " + pokemonType + ", " + energyType + ", " + HP + ", " + retreatCost  + ", " + attacktype1 + ", " + energyBasicCost + ", " + colorless1 + ", " + colorless1Cost + ", " + ability1 + ", " + attacktype2 + ", " + energyAdvanceCost + ", " + colorless2 + ", " + colorless2Cost + ", " + ability2 + ")");
		
		CardPokemon card = new CardPokemon();
		
		card.initPokemon(name, pokemonType, energyType, advanceEnergy, HP, retreatCost, attacktype1, energyBasicCost, colorless1, colorless1Cost, ability1, attacktype2, energyAdvanceCost, colorless2, colorless2Cost, ability2);
		

		
		return card;
		
	}
	
	public void newAttack() {
		
		m_attacks.add(new DeckBuilderPokemonCardAttack());
	}
	
	public void setAttackColorless(int cost) {
		
		m_attacks.getLast().setColorless(cost);
	}
	
	public void setAttackEnergy(int energyType, int cost) {
		
		m_attacks.getLast().setEnergy(energyType, cost);
		
	}
	
	public void setAttackAbilityId(int abilityId) {
		
		m_attacks.getLast().setkAbilityId(abilityId);
		
	}
	
	public void print() {
		
		
		System.out.println(m_name);
		System.out.println("\tEvolved: " + m_evolved);
		System.out.println("\tPokemonType: " + m_color + " (" + DeckBuilder.toColorString(m_color) + ")");
		System.out.println("\tHP: " + m_hp);
		System.out.println("\tRetreatColor: " + m_retreatColor + " (" + DeckBuilder.toColorString(m_retreatColor) + ")");
		System.out.println("\tRetreatCost: " + m_retreatCost);
		for (int i = 0; i < m_attacks.size(); i++) {
			
			DeckBuilderPokemonCardAttack currentAttack = m_attacks.get(i);
			
			System.out.println("\tAttack_" + (i+1));
			System.out.println("\t\tAttackType: " + currentAttack.getColor() + " (" + DeckBuilder.toColorString(currentAttack.getColor()) + ")");
			System.out.println("\t\tEnergyCost: " + currentAttack.getCost());
			System.out.println("\t\thasColorless:  " + currentAttack.getColorless());
			System.out.println("\t\tColorlessCost: " + currentAttack.getColorlessCost());
			System.out.println("\t\tAbilityId: " + currentAttack.getAbilityId());
			
		}
		
		
	}
		
}

