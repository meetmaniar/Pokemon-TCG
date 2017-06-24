package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;

public class trainerTest {
	
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		
		human.active = g.deck1[4];
		AI.active = g.deck2[2];
		
		AI.hand[0] = g.deck2[15];
		
		System.out.println("===========AIplayer hand============");
		for(int i = 0; i < 7 ;i++){
			try{
				if(AI.hand[i].m_type == 0){
					System.out.println("pokemon card: "+((CardPokemon)AI.hand[i]).m_name);
				}
				if(AI.hand[i].m_type == 1){
					System.out.println("energy card: "+((CardEnergy)AI.hand[i]).m_type);
				}
				if(AI.hand[i].m_type == 2){
					System.out.println("trainer card: "+((CardTrainer)AI.hand[i]).name);
				}
				if(AI.hand[i] == null){
					System.out.println("nothing");
				}
			}catch(Exception e){
				
			}
		}
		
		AI.useTrainerCard(0,g);
		System.out.println("===========AIplayer hand============");
		for(int i = 0; i < 7 ;i++){
			try{
				if(AI.hand[i].m_type == 0){
					System.out.println("pokemon card: "+((CardPokemon)AI.hand[i]).m_name);
				}
				if(AI.hand[i].m_type == 1){
					System.out.println("energy card: "+((CardEnergy)AI.hand[i]).m_type);
				}
				if(AI.hand[i].m_type == 2){
					System.out.println("trainer card: "+((CardTrainer)AI.hand[i]).name);
				}
				if(AI.hand[i] == null){
					System.out.println("nothing");
				}
			}catch(Exception e){
				
			}
		}
		int count = 0;
		for(int i = 0; i < AI.hand.length; i++){
			if(AI.hand[i] != null ){
				count++;
			}
		}
		
		assertEquals(3, count);
	
	}
	
	
	
}
