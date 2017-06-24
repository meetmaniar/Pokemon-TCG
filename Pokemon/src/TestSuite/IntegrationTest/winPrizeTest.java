package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.Play;

public class winPrizeTest {
	
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		
		AI.drawPrizeCards(g);
		for(int i = 0; i < 6; i++){
			AI.pickPrize();
		}
		assertEquals(true, human.checkEnd(AI));
	
	
	}
	
}
