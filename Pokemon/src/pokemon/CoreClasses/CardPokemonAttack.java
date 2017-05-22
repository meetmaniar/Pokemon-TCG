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
	

	public CardPokemonAttack(int attacktype1, int energyBasicCost, int colorless1, int colorless1Cost, int attacktype2, int energyAdvanceCost, int colorless2, int colorless2Cost) {
		m_attacktype1 = attacktype1;
		m_energyBasicCost = energyBasicCost;
		m_colorless1 = colorless1;
		m_colorless1Cost = colorless1Cost;
		m_attacktype2 = attacktype2;
		m_energyAdvanceCost = energyAdvanceCost;
		m_colorless2 = colorless2;
		m_colorless2Cost = colorless2Cost;
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
			hit(target,a);
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