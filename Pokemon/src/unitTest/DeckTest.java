package unitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;
import pokemon.parser.DeckBuilder;

public class DeckTest {
	
	
	@Test
	public void test() {
		
		
		GameEngine g = new GameEngine();
		g.iniDeck();
		DeckBuilder deck = new DeckBuilder("C:/Users/Zac/Pokemon-TCG./cards.txt");
		Card[] myDeck1 = deck.buildDeck("C:/Users/Zac/Pokemon-TCG./deck1.txt");
		Card[] myDeck2 = deck.buildDeck("C:/Users/Zac/Pokemon-TCG./deck2.txt");
		
		
		System.out.println("=========Compare Deck1==========");
		for(int i = 0; i < 60 ;i++){
			try{
				if(g.deck1[i].m_type == 0){
					assertEquals(((CardPokemon)myDeck1[i]).m_name,((CardPokemon)g.deck1[i]).m_name );
				}
				if(g.deck1[i].m_type == 1){
					assertEquals(((CardEnergy)myDeck1[i]).m_type,((CardEnergy)g.deck1[i]).m_type );
				}
				if(g.deck1[i].m_type == 2){
					assertEquals(((CardTrainer)myDeck1[i]).name,((CardTrainer)g.deck1[i]).name );
				}
			}catch(Exception e){	
			}
			
		}
		
		System.out.println("=========Compare Deck2==========");
		for(int i = 0; i < 60 ;i++){
			try{
				if(g.deck1[i].m_type == 0){
					assertEquals(((CardPokemon)myDeck2[i]).m_name,((CardPokemon)g.deck2[i]).m_name );
				}
				if(g.deck1[i].m_type == 1){
					assertEquals(((CardEnergy)myDeck2[i]).m_type,((CardEnergy)g.deck2[i]).m_type );
				}
				if(g.deck1[i].m_type == 2){
					assertEquals(((CardTrainer)myDeck2[i]).name,((CardTrainer)g.deck2[i]).name );
				}
			}catch(Exception e){	
			}
			
		}

		
	}
	
	
	
}	



