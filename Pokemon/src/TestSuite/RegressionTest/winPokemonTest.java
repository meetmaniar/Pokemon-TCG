package RegressionTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.Play;

public class winPokemonTest {
	
	
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		//no pokemon on active and bench
		assertEquals(true, human.checkEnd(AI));
	
	
	}
	
}
