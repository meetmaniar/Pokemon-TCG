package pokemon.CoreClasses;

import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;

public class AbilityTrainer {
	
	
	//draw 3 cards
	public void ability1_Tierno(Play p){
		p.drawOneCard();
		p.drawOneCard();
		p.drawOneCard();
	}
	
	//heal
	public void ability2_Potion(CardPokemon c){
		c.m_hp = c.m_hp + 30;
	}
	
	public void ability3_MistyDetermination(){
		System.out.println("not developed");
	}
	
	// heal and destat
	public void ability4_PokmonCenterLady(CardPokemon a, CardPokemon b){
		a.m_hp = a.m_hp + 60;
		b.removeStatus();
	}
	
	//search
	public void ability5_Clemont(Play p, GameEngine g){
//		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < p.hand.length; j ++){
//				if(p.hand[j] == null){
//					p.hand[j] = p.search(g, 1);
//					break;
//				}
//			}
//		}	
		System.out.println("not developed");
	}
	
	public void ability6_FloralCrown(){
		System.out.println("not developed");
	}
	
	public void ability7_PokemonBall(Play p, GameEngine g){
//		//flip a coin
//		int i = ThreadLocalRandom.current().nextInt(0,2);
//		if(i == 1){
//			for(int j = 0; j < p.hand.length; j ++){
//				if(p.hand[j] == null){
//					p.hand[j] = p.search(g, 0);
//					break;
//				}
//			}
//		}
		System.out.println("not developed");
	}
	
	public void ability8_Shauna(){
		System.out.println("not developed");
	}
	
	public void ability9_PokmonFanClub(Play p, GameEngine g){
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < p.hand.length; j ++){
//				if(p.hand[j] == null){
//					p.hand[j] = p.search(g, 0);
//					break;
//				}
//			}
//		}	
		System.out.println("not developed");
	}
	
	public void ability10_Switch(CardPokemon active, CardPokemon bench){
		CardPokemon a = active;
		active = bench;
		bench = a;
	}
	
	//reenergize
	public void ability11_EnergySwitch(CardPokemon source, CardPokemon destination, int amount){
		source.m_energy = source.m_energy - amount*10;
		destination.m_energy = destination.m_energy + amount*10;
		for(int i = 0; i < amount; i ++){
			destination.m_energyCards.add(source.m_energyCards.removeLast());
		}
	}
	
	public void ability12_RedCard(){
		System.out.println("not developed");
	}
	
	public void ability13_Wally(){
		System.out.println("not developed");
	}
	
}
