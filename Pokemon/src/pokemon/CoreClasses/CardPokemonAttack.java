package pokemon.CoreClasses;

import pokemon.GameEngine;

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

	public void attackBasic(Play p, GameEngine g,  CardPokemon attacking, CardPokemon target){

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
				attacking.m_abilityPokemon.ability7_CircleCircuit(p,target);
			
			case 8:
				attacking.m_abilityPokemon.ability8_Thunderbolt(p, target);
					
			case 9:
				attacking.m_abilityPokemon.ability9_RainSplash(target);
				
			case 10:
				attacking.m_abilityPokemon.ability10_SoakingHorn(target);
				
			case 11:
				attacking.m_abilityPokemon.ability11_RecklessCharge(p, target);
				
			case 12:
				attacking.m_abilityPokemon.ability12_RecklessCharge(p, target);
				
			case 13:
				attacking.m_abilityPokemon.ability13_Cut(target);
				
			case 14:
				attacking.m_abilityPokemon.ability15_ClampCrush(target);
				
			case 15:
				attacking.m_abilityPokemon.ability15_ClampCrush(target);
			
			case 16:
				attacking.m_abilityPokemon.ability16_SpikeCannon(target);
				
			case 17:
				attacking.m_abilityPokemon.ability17_SpiralDrain(p, target);
				
			case 18:
				attacking.m_abilityPokemon.ability18_AuroraBeam(target);
				
			case 19:
				attacking.m_abilityPokemon.ability19_WingAttack(target);
				
			case 20:
				attacking.m_abilityPokemon.ability20_BraveBird(p, target);
				
			case 21:
				attacking.m_abilityPokemon.ability21_Lunge(target);
				
			case 22:
				attacking.m_abilityPokemon.ability22_Slash(target);
				
			case 23:
				attacking.m_abilityPokemon.ability23_NyanPress(target);
				
			case 24:
				attacking.m_abilityPokemon.ability24_RandomSpark(target);
			
			case 25:
				attacking.m_abilityPokemon.ability25_Bite(target);
				
			case 26:
				attacking.m_abilityPokemon.ability26_Bite(target);
				
			case 27:
				attacking.m_abilityPokemon.ability27_KnucklePunch(target);
				
			case 28:
				attacking.m_abilityPokemon.ability28_Electroslug(target);
				
			case 29:
				attacking.m_abilityPokemon.ability29_KnucklePunch(target);
				
			case 30:
				attacking.m_abilityPokemon.ability30_DestructiveBeam(target);
				
			case 31:
				attacking.m_abilityPokemon.ability31_Tierno(p, g);
				
			case 32:
				attacking.m_abilityPokemon.ability32_Potion(attacking);
				
			case 33:
				attacking.m_abilityPokemon.ability33_MistyDetermination();
				
			case 34:
				attacking.m_abilityPokemon.ability34_PokmonCenterLady(attacking, attacking);
				
			case 35:
				attacking.m_abilityPokemon.ability35_Clemont(p, g);
				
			case 36:
				attacking.m_abilityPokemon.ability36_EarInfluence();
				
			case 37:
				attacking.m_abilityPokemon.ability37_Psychic(target);
				
			case 38:
				attacking.m_abilityPokemon.ability38_Hug(target);
				
			case 39:
				attacking.m_abilityPokemon.ability39_Wish(p, g);
				
			case 40:
				attacking.m_abilityPokemon.ability40_HeartSign(target);
			
			case 41:
				attacking.m_abilityPokemon.ability41_ActTough(p, target);
				
			case 42:
				attacking.m_abilityPokemon.ability42_ExhaustedTackle(p, target);
			
			case 43:
				attacking.m_abilityPokemon.ability43_KnucklePunch(target);
				
			case 44:
				attacking.m_abilityPokemon.ability44_DoubleStab(target);
				
			case 45:
				attacking.m_abilityPokemon.ability45_DoduoDelivery(p, g);
				
			case 46:
				attacking.m_abilityPokemon.ability46_FuryAttack(target);
				
			case 47:
				attacking.m_abilityPokemon.ability47_Rollout(target);
				
			case 48:
				attacking.m_abilityPokemon.ability48_Flail();
				
			case 49:
				attacking.m_abilityPokemon.ability49_SkillDive(target);
				
			case 50:
				attacking.m_abilityPokemon.ability50_PoisonRing(target);
				
			case 51:
				attacking.m_abilityPokemon.ability51_SleepPoison(target);
				
			case 52:
				attacking.m_abilityPokemon.ability52_Mine();
				
			case 53:
				attacking.m_abilityPokemon.ability53_MudSlap(target);
			

			default:
					System.out.println("do nothing");

		}
			
			//hit(target,a);
		}
		else{
			System.out.println("Not enough energy");
		}
		
		

	}

	public void attackAdvance(Play p, CardPokemon attacking, CardPokemon target){

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
			switch(m_ability2) {

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
				attacking.m_abilityPokemon.ability7_CircleCircuit(p,target);
			
			case 8:
				attacking.m_abilityPokemon.ability8_Thunderbolt(p, target);
					
			case 9:
				attacking.m_abilityPokemon.ability9_RainSplash(target);

			default:
					System.out.println("do nothing");

		}
			
		}
		else{
			System.out.println("Not enough energy");
		}

	}

}