package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.Play;

public class winDeckTest {
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		
	
		for(int i = 0; i < 60; i++){
			AI.deck_top++;
		}
		//opponent deck is empty
		assertEquals(true, human.checkEnd(AI));
	
	
	}
	
}
