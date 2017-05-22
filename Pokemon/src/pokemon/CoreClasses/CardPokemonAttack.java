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
		for(int i = 0; i <= attacking.m_energyCards.size(); i++){
			int m_energyType=0;
			if(attacking.m_energyCards.get(i).m_type == m_energyType){
				collectTypeEnergy = collectTypeEnergy + 10;
			}
		}
		if(collectTypeEnergy >= m_energyBasicCost){
			hit(target,m_energyBasicCost);
		}
		else{
			System.out.println("Not enough energy");
		}

	}

	public void attackAdvance(CardPokemon attacking, CardPokemon target){

		int collectTypeEnergy = 0;
		int collectColorlessEnergy = 0;
		int currentEnergy = 0;
		int m_energyCostColorless = 0;
		int needEnergy = m_energyAdvanceCost +	m_energyCostColorless;

		for(int i = 0; i <= attacking.m_energyCards.size(); i++){
			int m_energyType = 0;
			if(attacking.m_energyCards.get(i).m_type == m_energyType){
				collectTypeEnergy = collectTypeEnergy + 10;
			}
			else{
				collectColorlessEnergy = collectColorlessEnergy + 10;
			}
		}

		currentEnergy = collectTypeEnergy + collectColorlessEnergy;

		if(currentEnergy >= needEnergy){
			hit(target,needEnergy);
		}
		else{
			System.out.println("Not enough energy");
		}

	}

	void hit(CardPokemon target, int damage){
		target.m_hp = target.m_hp - damage;
	}

}