package pokemon.CoreClasses;

import pokemon.GameEngine;

public class AbilityTrainer {
	
	
	//draw 3 cards
	public void ability1_Tierno(Play p, GameEngine g){
		p.drawOneCard(g);
		p.drawOneCard(g);
		p.drawOneCard(g);
	}
	
	//heal
	public void ability2_Potion(CardPokemon c){
		c.m_hp = c.m_hp + 30;
	}
	
	public void ability3_MistyDetermination(){
		
	}
	
	public void ability4_Pok¨¦monCenterLady(){
		
	}
	
	public void ability5_Clemont(){
		
	}
	
	public void ability6_FloralCrown(){
		
	}
	
	public void ability7_Pok¨¦Ball(){
		
	}
	
	public void ability7_Shauna(){
		
	}
	
	public void ability8_Pok¨¦monFanClub(){
		
	}
	
	public void ability9_Switch(CardPokemon active, CardPokemon bench){
		CardPokemon a = active;
		active = bench;
		bench = a;
	}
	
	public void ability10_EnergySwitch(CardPokemon source, CardPokemon destination, int amount){
		source.m_hp = source.m_hp - amount;
		destination.m_hp = destination.m_hp + amount;
	}
	
	public void ability11_RedCard(){
		
	}
	
	public void ability12_Wally(){
		
	}
	
}
