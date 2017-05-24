package pokemon.CoreClasses;

import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;


public class AbilityPokemon {
	 
	public void dam(CardPokemon c, int amount){
		c.m_hp = c.m_hp - amount;
	}
	
	public void deenergize(CardPokemon c, int amount){
		c.m_energy = c.m_energy - amount*10;
		for(int i = 0; i < amount; i ++){
			c.m_energyCards.removeLast();
		}
	}
	
	//choice 0:AI, 1:HUMAN, 2:random
	public void deck(GameEngine g, int choice, int amount){
		
	}
	
	public void ability1_ActCute(){
		
	}
	
	public void ability2_Scratch(CardPokemon c){
		dam(c,20);
	}
	
	public void ability3_QuickAttack(CardPokemon c){
		dam(c,10);
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(c,30);
		}
	}
	
	public void ability4_FlyingElekick(CardPokemon c){
		dam(c,50);
	}
	
	public void ability5_Nuzzle(CardPokemon c){
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			c.m_statusEffect = 1;
		}
	}
	
	public void ability6_QuickAttack(CardPokemon c){
		dam(c,20);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(c,10);
		}
	}
	
	public void ability7_CircleCircuit(CardPokemon c){
	
	}
	
	public void ability8_Thunderbolt(CardPokemon c, CardPokemon d, int amount ){
		dam(c,100);
		deenergize(d, amount);
		
	}
	
	public void ability9_RainSplash(CardPokemon c ){
		dam(c,20);
	}
	
}
