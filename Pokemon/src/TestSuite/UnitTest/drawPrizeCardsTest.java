package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;

public class drawPrizeCardsTest {

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
		human.drawPrizeCards(g);
		AI.drawPrizeCards(g);
		
		System.out.println("===========human player hand section============");
		for(int i = 0; i < human.hand.length ;i++){
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
		
		System.out.println("===========human player prize section============");
		for(int i = 0; i < 7 ;i++){
			try{
				if(human.prize[i].m_type == 0){
					System.out.println("pokemon card: "+((CardPokemon)human.prize[i]).m_name);
				}
				if(human.prize[i].m_type == 1){
					System.out.println("energy card: "+ ((CardEnergy)human.prize[i]).m_type);
				}
				if(human.prize[i].m_type == 2){
					System.out.println("trainer card: "+ ((CardTrainer)human.prize[i]).name);
				}
			}catch(Exception e){	
			}
			
		}
		
		System.out.println("===========AI prize section============");
		for(int i = 0; i < 7 ;i++){
			try{
				
				if(AI.prize[i].m_type == 0){
					System.out.println("pokemon card: "+((CardPokemon)AI.prize[i]).m_name);
				}
				if(AI.prize[i].m_type == 1){
					System.out.println("energy card: "+((CardEnergy)AI.prize[i]).m_type);
				}
				if(AI.prize[i].m_type == 2){
					System.out.println("trainer card: "+((CardTrainer)AI.prize[i]).name);
				}
				if(AI.prize[i] == null){
					System.out.println("nothing");
				}
			}catch(Exception e){
				
			}
		}
		
		System.out.println("===========human player pick a prize card============");
		human.pickPrize();
		System.out.println("===========human player hand section============");
		for(int i = 0; i < human.hand.length ;i++){
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
		
		System.out.println("===========AI player pick a prize card============");
		AI.pickPrize();
		System.out.println("===========AIplayer hand============");
		for(int i = 0; i < AI.hand.length ;i++){
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
