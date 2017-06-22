package pokemon.CoreClasses;

import pokemon.GameEngine;
import pokemon.parser.DeckBuilder;

public class test111 {
	
	public static void main(String[] args){
		GameEngine g = new GameEngine();
		DeckBuilder deck = new DeckBuilder("C:/Users/Zac/Pokemon-TCG./cards.txt");
		Card[] myDeck1 = deck.buildDeck("C:/Users/Zac/Pokemon-TCG./deck1.txt");
		Card[] myDeck2 = deck.buildDeck("C:/Users/Zac/Pokemon-TCG./deck2.txt");
		g.deck1 = myDeck1;
		g.deck2 = myDeck2;
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		human.drawSevenCards(g);
		AI.drawSevenCards(g);
		System.out.println("********human player hand*******");
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
		
		System.out.println("********AIplayer hand*******");
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
		
		human.drawOneCard(g);
		System.out.println("********human player hand*******");
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
		
		AI.drawOneCard(g);
		
		System.out.println("********AIplayer hand*******");
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
