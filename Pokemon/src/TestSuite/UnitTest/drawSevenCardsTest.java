package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;

public class drawSevenCardsTest {

	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		
		System.out.println("==========game starts==========");
		human.drawSevenCards(g);
		AI.drawSevenCards(g);
		
		System.out.println("===========human player hand============");
		for(int i = 0; i < 7 ;i++){
			try{
				if(human.hand[i].m_type == 0){
					System.out.println("pokemon card: "+((CardPokemon)human.hand[i]).m_name);
				}
				if(human.hand[i].m_type == 1){
					System.out.println("energy card: "+ ((CardEnergy)human.hand[i]).m_type);
				}
				if(human.hand[i].m_type == 2){
					System.out.println("trainer card: "+ ((CardTrainer)human.hand[i]).name);
				}
			}catch(Exception e){	
			}
			
		}
		
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
			
	}
	
	

}
