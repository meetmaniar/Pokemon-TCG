package IntegrationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.Play;
import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;

public class statusTest {
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		
		human.active = g.deck1[4];
		AI.active = g.deck2[2];
		
		((CardPokemon)human.active).paralize((CardPokemon) AI.active); 
		switch(((CardPokemon) AI.active).m_statusEffect){
			case 1:
				System.out.println("status is paralized");break;
			case 2:
				System.out.println("status is asleep");break;
			case 3:
				System.out.println("status is stuck");break;
			case 4:
				System.out.println("status is poisoned");break;
			default:
				System.out.println("status is healthy");
		}
		
		assertEquals(1, ((CardPokemon) AI.active).m_statusEffect);
	
	
	}
}
