package zac.pokemon;

public class CardPokemonAttack {
	
	int	m_energyType;
	int m_energyBasicCost;
	int m_energyAdvanceCost;
	int m_energyCostColorless;
	
	public CardPokemonAttack(int energyType, int energyBasicCost, int energyAdvanceCost, int energyCostColorless) {
		
		m_energyType = energyType;
		m_energyBasicCost = energyBasicCost;
		m_energyAdvanceCost = energyAdvanceCost;
		m_energyCostColorless = energyCostColorless;
		
	}
	
	public void attackBasic(CardPokemon attacking, CardPokemon target){
		
		int collectTypeEnergy = 0;
		for(int i = 0; i <= attacking.m_energyCards.size(); i++){
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
		int needEnergy = m_energyAdvanceCost +	m_energyCostColorless;
		
		for(int i = 0; i <= attacking.m_energyCards.size(); i++){
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
