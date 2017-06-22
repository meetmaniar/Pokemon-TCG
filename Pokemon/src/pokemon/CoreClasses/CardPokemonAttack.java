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
			for(int i = 0; i < attacking.m_energyCards.size(); i++){
				if(attacking.m_energyCards.get(i).m_type == m_attacktype1){
					collectTypeEnergy = collectTypeEnergy + 10;
				}
			}
		}
		if(m_colorless1 >=0){
			for(int i = 0; i < attacking.m_energyCards.size(); i++){
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
				break;

			case 2:
				attacking.m_abilityPokemon.ability2_Scratch(target);	break;

			case 3:
				attacking.m_abilityPokemon.ability3_QuickAttack(target);	break;

			case 4:
				attacking.m_abilityPokemon.ability4_FlyingElekick(target);	break;
					
			case 5:
				attacking.m_abilityPokemon.ability5_Nuzzle(target);	break;
					
			case 6:
				attacking.m_abilityPokemon.ability6_QuickAttack(target);	break;
					
			case 7:
				attacking.m_abilityPokemon.ability7_CircleCircuit(p,target);	break;
			
			case 8:
				attacking.m_abilityPokemon.ability8_Thunderbolt(p, target);	break;
					
			case 9:
				attacking.m_abilityPokemon.ability9_RainSplash(target);	break;
				
			case 10:
				attacking.m_abilityPokemon.ability10_SoakingHorn(target);	break;
				
			case 11:
				attacking.m_abilityPokemon.ability11_RecklessCharge(p, target);	break;
				
			case 12:
				attacking.m_abilityPokemon.ability12_RecklessCharge(p, target);	break;
				
			case 13:
				attacking.m_abilityPokemon.ability13_Cut(target);	break;
				
			case 14:
				attacking.m_abilityPokemon.ability15_ClampCrush(target);	break;
				
			case 15:
				attacking.m_abilityPokemon.ability15_ClampCrush(target);	break;
			
			case 16:
				attacking.m_abilityPokemon.ability16_SpikeCannon(target);	break;
				
			case 17:
				attacking.m_abilityPokemon.ability17_SpiralDrain(p, target);	break;
				
			case 18:
				attacking.m_abilityPokemon.ability18_AuroraBeam(target);	break;
				
			case 19:
				attacking.m_abilityPokemon.ability19_WingAttack(target);	break;
				
			case 20:
				attacking.m_abilityPokemon.ability20_BraveBird(p, target);	break;
				
			case 21:
				attacking.m_abilityPokemon.ability21_Lunge(target);	break;
				
			case 22:
				attacking.m_abilityPokemon.ability22_Slash(target);	break;
				
			case 23:
				attacking.m_abilityPokemon.ability23_NyanPress(target);	break;
				
			case 24:
				attacking.m_abilityPokemon.ability24_RandomSpark(target);	break;
			
			case 25:
				attacking.m_abilityPokemon.ability25_Bite(target);	break;
				
			case 26:
				attacking.m_abilityPokemon.ability26_Bite(target);	break;
				
			case 27:
				attacking.m_abilityPokemon.ability27_KnucklePunch(target);	break;
				
			case 28:
				attacking.m_abilityPokemon.ability28_Electroslug(target);	break;
				
			case 29:
				attacking.m_abilityPokemon.ability29_KnucklePunch(target);	break;
				
			case 30:
				attacking.m_abilityPokemon.ability30_DestructiveBeam(target);	break;
				
			case 31:
				attacking.m_abilityPokemon.ability31_Tierno(p, g);	break;
				
			case 32:
				attacking.m_abilityPokemon.ability32_Potion(attacking);	break;
				
			case 33:
				attacking.m_abilityPokemon.ability33_MistyDetermination();	break;
				
			case 34:
				attacking.m_abilityPokemon.ability34_PokmonCenterLady(attacking, attacking); 	break;
				
			case 35:
				attacking.m_abilityPokemon.ability35_Clemont(p, g);	break;
				
			case 36:
				attacking.m_abilityPokemon.ability36_EarInfluence();	break;
				
			case 37:
				attacking.m_abilityPokemon.ability37_Psychic(target);	break;
				
			case 38:
				attacking.m_abilityPokemon.ability38_Hug(target);	break;
				
			case 39:
				attacking.m_abilityPokemon.ability39_Wish(p, g);	break;
				
			case 40:
				attacking.m_abilityPokemon.ability40_HeartSign(target);	break;
			
			case 41:
				attacking.m_abilityPokemon.ability41_ActTough(p, target);	break;
				
			case 42:
				attacking.m_abilityPokemon.ability42_ExhaustedTackle(p, target);	break;
			
			case 43:
				attacking.m_abilityPokemon.ability43_KnucklePunch(target);	break;
				
			case 44:
				attacking.m_abilityPokemon.ability44_DoubleStab(target);	break;
				
			case 45:
				attacking.m_abilityPokemon.ability45_DoduoDelivery(p, g);	break;
				
			case 46:
				attacking.m_abilityPokemon.ability46_FuryAttack(target);	break;
				
			case 47:
				attacking.m_abilityPokemon.ability47_Rollout(target);	break;
				
			case 48:
				attacking.m_abilityPokemon.ability48_Flail();	break;
				
			case 49:
				attacking.m_abilityPokemon.ability49_SkillDive(target);	break;
				
			case 50:
				attacking.m_abilityPokemon.ability50_PoisonRing(target);	break;
				
			case 51:
				attacking.m_abilityPokemon.ability51_SleepPoison(target);	break;
				
			case 52:
				attacking.m_abilityPokemon.ability52_Mine();	break;
				
			case 53:
				attacking.m_abilityPokemon.ability53_MudSlap(target);	break;
				
			case 54:
				attacking.m_abilityPokemon.ability54_Earthquake(p, target);	break;
			
			case 55:
				attacking.m_abilityPokemon.ability55_RockTumble(target);	break;
				
			case 56:
				attacking.m_abilityPokemon.ability56_Scratch(target);	break;
				
			case 57:
				attacking.m_abilityPokemon.ability57_SpacingOut(p);	break;
				
			case 59:
				attacking.m_abilityPokemon.ability59_StretchKick(target);	break;
				
			case 60:
				attacking.m_abilityPokemon.ability60_SpiralKick(target);	break;
				
			case 61:
				attacking.m_abilityPokemon.ability61_BulletPunch(target);	break;
				
			case 62:
				attacking.m_abilityPokemon.ability62_MachCross(target);	break;
				
			case 63:
				attacking.m_abilityPokemon.ability63_Beatdown(target);	break;
				
			case 64:
				attacking.m_abilityPokemon.ability64_Twinkle(target);	break;
				
			case 65:
				attacking.m_abilityPokemon.ability65_FakeOut(target);	break;
				
			case 66:
				attacking.m_abilityPokemon.ability66_Ambush(target);	break;
				
			case 67:
				attacking.m_abilityPokemon.ability67_FloralCrown(attacking);	break;
				
			case 68:
				attacking.m_abilityPokemon.ability68_PokemonBall(p, g);	break;
				
			case 69:
				attacking.m_abilityPokemon.ability69_Shauna(p, g);	break;
				
			case 70:
				attacking.m_abilityPokemon.ability70_PokmonFanClub(p, g);	break;
				
			case 71:
				attacking.m_abilityPokemon.ability71_Switch(attacking, (CardPokemon) p.bench[1]); 	break;
				
			case 72:
				attacking.m_abilityPokemon.ability72_EnergySwitch(attacking, (CardPokemon) p.bench[1], 1);	break;
				
			case 73:
				attacking.m_abilityPokemon.ability73_RedCard(p, g);	break;
				
			case 74:
				attacking.m_abilityPokemon.ability74_Wally(p, g);	break;

			default:
					System.out.println("do nothing");	

			}
		}
		else{
			System.out.println("Not enough energy");
		}
		
		

	}

	public void attackAdvance(Play p, GameEngine g, CardPokemon attacking, CardPokemon target){

		int collectTypeEnergy = 0;
		int collectColorlessEnergy = 0;
		
		if(m_attacktype2 >= 0){
			for(int i = 0; i < attacking.m_energyCards.size(); i++){
				if(attacking.m_energyCards.get(i).m_type == m_attacktype2){
					collectTypeEnergy = collectTypeEnergy + 10;
				}
			}
		}
		if(m_colorless2 >=0){
			for(int i = 0; i < attacking.m_energyCards.size(); i++){
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
				break;

			case 2:
				attacking.m_abilityPokemon.ability2_Scratch(target);	break;

			case 3:
				attacking.m_abilityPokemon.ability3_QuickAttack(target);	break;

			case 4:
				attacking.m_abilityPokemon.ability4_FlyingElekick(target);	break;
					
			case 5:
				attacking.m_abilityPokemon.ability5_Nuzzle(target);	break;
					
			case 6:
				attacking.m_abilityPokemon.ability6_QuickAttack(target);	break;
					
			case 7:
				attacking.m_abilityPokemon.ability7_CircleCircuit(p,target);	break;
			
			case 8:
				attacking.m_abilityPokemon.ability8_Thunderbolt(p, target);	break;
					
			case 9:
				attacking.m_abilityPokemon.ability9_RainSplash(target);	break;
				
			case 10:
				attacking.m_abilityPokemon.ability10_SoakingHorn(target);	break;
				
			case 11:
				attacking.m_abilityPokemon.ability11_RecklessCharge(p, target);	break;
				
			case 12:
				attacking.m_abilityPokemon.ability12_RecklessCharge(p, target);	break;
				
			case 13:
				attacking.m_abilityPokemon.ability13_Cut(target);	break;
				
			case 14:
				attacking.m_abilityPokemon.ability15_ClampCrush(target);	break;
				
			case 15:
				attacking.m_abilityPokemon.ability15_ClampCrush(target);	break;
			
			case 16:
				attacking.m_abilityPokemon.ability16_SpikeCannon(target);	break;
				
			case 17:
				attacking.m_abilityPokemon.ability17_SpiralDrain(p, target);	break;
				
			case 18:
				attacking.m_abilityPokemon.ability18_AuroraBeam(target);	break;
				
			case 19:
				attacking.m_abilityPokemon.ability19_WingAttack(target);	break;
				
			case 20:
				attacking.m_abilityPokemon.ability20_BraveBird(p, target);	break;
				
			case 21:
				attacking.m_abilityPokemon.ability21_Lunge(target);	break;
				
			case 22:
				attacking.m_abilityPokemon.ability22_Slash(target);	break;
				
			case 23:
				attacking.m_abilityPokemon.ability23_NyanPress(target);	break;
				
			case 24:
				attacking.m_abilityPokemon.ability24_RandomSpark(target);	break;
			
			case 25:
				attacking.m_abilityPokemon.ability25_Bite(target);	break;
				
			case 26:
				attacking.m_abilityPokemon.ability26_Bite(target);	break;
				
			case 27:
				attacking.m_abilityPokemon.ability27_KnucklePunch(target);	break;
				
			case 28:
				attacking.m_abilityPokemon.ability28_Electroslug(target);	break;
				
			case 29:
				attacking.m_abilityPokemon.ability29_KnucklePunch(target);	break;
				
			case 30:
				attacking.m_abilityPokemon.ability30_DestructiveBeam(target);	break;
				
			case 31:
				attacking.m_abilityPokemon.ability31_Tierno(p, g);	break;
				
			case 32:
				attacking.m_abilityPokemon.ability32_Potion(attacking);	break;
				
			case 33:
				attacking.m_abilityPokemon.ability33_MistyDetermination();	break;
				
			case 34:
				attacking.m_abilityPokemon.ability34_PokmonCenterLady(attacking, attacking); 	break;
				
			case 35:
				attacking.m_abilityPokemon.ability35_Clemont(p, g);	break;
				
			case 36:
				attacking.m_abilityPokemon.ability36_EarInfluence();	break;
				
			case 37:
				attacking.m_abilityPokemon.ability37_Psychic(target);	break;
				
			case 38:
				attacking.m_abilityPokemon.ability38_Hug(target);	break;
				
			case 39:
				attacking.m_abilityPokemon.ability39_Wish(p, g);	break;
				
			case 40:
				attacking.m_abilityPokemon.ability40_HeartSign(target);	break;
			
			case 41:
				attacking.m_abilityPokemon.ability41_ActTough(p, target);	break;
				
			case 42:
				attacking.m_abilityPokemon.ability42_ExhaustedTackle(p, target);	break;
			
			case 43:
				attacking.m_abilityPokemon.ability43_KnucklePunch(target);	break;
				
			case 44:
				attacking.m_abilityPokemon.ability44_DoubleStab(target);	break;
				
			case 45:
				attacking.m_abilityPokemon.ability45_DoduoDelivery(p, g);	break;
				
			case 46:
				attacking.m_abilityPokemon.ability46_FuryAttack(target);	break;
				
			case 47:
				attacking.m_abilityPokemon.ability47_Rollout(target);	break;
				
			case 48:
				attacking.m_abilityPokemon.ability48_Flail();	break;
				
			case 49:
				attacking.m_abilityPokemon.ability49_SkillDive(target);	break;
				
			case 50:
				attacking.m_abilityPokemon.ability50_PoisonRing(target);	break;
				
			case 51:
				attacking.m_abilityPokemon.ability51_SleepPoison(target);	break;
				
			case 52:
				attacking.m_abilityPokemon.ability52_Mine();	break;
				
			case 53:
				attacking.m_abilityPokemon.ability53_MudSlap(target);	break;
				
			case 54:
				attacking.m_abilityPokemon.ability54_Earthquake(p, target);	break;
			
			case 55:
				attacking.m_abilityPokemon.ability55_RockTumble(target);	break;
				
			case 56:
				attacking.m_abilityPokemon.ability56_Scratch(target);	break;
				
			case 57:
				attacking.m_abilityPokemon.ability57_SpacingOut(p);	break;
				
			case 59:
				attacking.m_abilityPokemon.ability59_StretchKick(target);	break;
				
			case 60:
				attacking.m_abilityPokemon.ability60_SpiralKick(target);	break;
				
			case 61:
				attacking.m_abilityPokemon.ability61_BulletPunch(target);	break;
				
			case 62:
				attacking.m_abilityPokemon.ability62_MachCross(target);	break;
				
			case 63:
				attacking.m_abilityPokemon.ability63_Beatdown(target);	break;
				
			case 64:
				attacking.m_abilityPokemon.ability64_Twinkle(target);	break;
				
			case 65:
				attacking.m_abilityPokemon.ability65_FakeOut(target);	break;
				
			case 66:
				attacking.m_abilityPokemon.ability66_Ambush(target);	break;
				
			case 67:
				attacking.m_abilityPokemon.ability67_FloralCrown(attacking);	break;
				
			case 68:
				attacking.m_abilityPokemon.ability68_PokemonBall(p, g);	break;
				
			case 69:
				attacking.m_abilityPokemon.ability69_Shauna(p, g);	break;
				
			case 70:
				attacking.m_abilityPokemon.ability70_PokmonFanClub(p, g);	break;
				
			case 71:
				attacking.m_abilityPokemon.ability71_Switch(attacking, (CardPokemon) p.bench[1]); 	break;
				
			case 72:
				attacking.m_abilityPokemon.ability72_EnergySwitch(attacking, (CardPokemon) p.bench[1], 1);	break;
				
			case 73:
				attacking.m_abilityPokemon.ability73_RedCard(p, g);	break;
				
			case 74:
				attacking.m_abilityPokemon.ability74_Wally(p, g);	break;

			default:
					System.out.println("do nothing");	

			}
			
		}
		else{
			System.out.println("Not enough energy");
		}

	}

}