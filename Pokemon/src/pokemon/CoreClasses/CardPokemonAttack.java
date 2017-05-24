package pokemon.CoreClasses;

public class CardPokemonAttack {

	int	m_attacktype1;
	int m_energyBasicCost;
	int m_colorless1;
	int m_colorless1Cost;
	int m_attacktype2;
	int m_energyAdvanceCost;
	int m_colorless2;
	int m_colorless2Cost;
	int m_ability1;
	int m_ability2;
	

	public CardPokemonAttack(int attacktype1, int energyBasicCost, int colorless1, int colorless1Cost, int ability1, int attacktype2, int energyAdvanceCost, int colorless2, int colorless2Cost, int ability2) {
		m_attacktype1 = attacktype1;
		m_energyBasicCost = energyBasicCost;
		m_colorless1 = colorless1;
		m_colorless1Cost = colorless1Cost;
		m_attacktype2 = attacktype2;
		m_energyAdvanceCost = energyAdvanceCost;
		m_colorless2 = colorless2;
		m_colorless2Cost = colorless2Cost;
		m_ability1 = ability1;
		m_ability2 = ability2;
		
	}

	public void attackBasic(CardPokemon attacking, CardPokemon target){

		int collectTypeEnergy = 0;
		int collectColorlessEnergy = 0;
		if(m_attacktype1 >= 0){
			for(int i = 0; i <= attacking.m_energyCards.size(); i++){
				if(attacking.m_energyCards.get(i).m_type == m_attacktype1){
					collectTypeEnergy = collectTypeEnergy + 10;
				}
			}
		}
		if(m_colorless1 >=0){
			for(int i = 0; i <= attacking.m_energyCards.size(); i++){
				if(attacking.m_energyCards.get(i).m_type != m_attacktype1){
					collectColorlessEnergy = collectColorlessEnergy + 10;
				}
			}
		}
		int a = collectTypeEnergy+collectColorlessEnergy;
		int b = m_energyBasicCost+m_colorless1Cost;
		if( a >= b ){
			switch(m_ability1) {

			case 1:
				attacking.m_abilityPokemon.ability1_ActCute();

			case 2:
				attacking.m_abilityPokemon.ability2_Scratch(target);

			case 3:
				attacking.m_abilityPokemon.ability3_QuickAttack(target);

			case 4:
				attacking.m_abilityPokemon.ability4_FlyingElekick(target);
					
			case 5:
				attacking.m_abilityPokemon.ability5_Nuzzle(target);
					
			case 6:
				attacking.m_abilityPokemon.ability6_QuickAttack(target);
					
			case 7:
					a.abilityTrainer.ability7_PokemonBall(this, g);
			
			case 8:
					a.abilityTrainer.ability8_Shauna();
					
			case 9:
					a.abilityTrainer.ability9_PokmonFanClub(this, g);
			
			case 10:
					a.abilityTrainer.ability10_Switch((CardPokemon) active, c);
				
			case 11:
					a.abilityTrainer.ability11_EnergySwitch(c, d, 20);
			
			case 12:
					a.abilityTrainer.ability12_RedCard();
			
			case 13:
					a.abilityTrainer.ability13_Wally();

			default:
					System.out.println("do nothing");

		}
			
			//hit(target,a);
		}
		else{
			System.out.println("Not enough energy");
		}
		
		

	}

	public void attackAdvance(CardPokemon attacking, CardPokemon target){

		int collectTypeEnergy = 0;
		int collectColorlessEnergy = 0;
		
		if(m_attacktype2 >= 0){
			for(int i = 0; i <= attacking.m_energyCards.size(); i++){
				if(attacking.m_energyCards.get(i).m_type == m_attacktype2){
					collectTypeEnergy = collectTypeEnergy + 10;
				}
			}
		}
		if(m_colorless2 >=0){
			for(int i = 0; i <= attacking.m_energyCards.size(); i++){
				if(attacking.m_energyCards.get(i).m_type != m_attacktype2){
					collectColorlessEnergy = collectColorlessEnergy + 10;
				}
			}
		}
		int a = collectTypeEnergy+collectColorlessEnergy;
		int b = m_energyBasicCost+m_colorless1Cost;
		if( a >= b ){
			hit(target,a);
		}
		else{
			System.out.println("Not enough energy");
		}

	}

	void hit(CardPokemon target, int damage){
		target.m_hp = target.m_hp - damage;
	}

}