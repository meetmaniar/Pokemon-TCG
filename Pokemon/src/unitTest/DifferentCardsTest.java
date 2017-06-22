package unitTest;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import pokemon.GameEngine;

public class DifferentCardsTest {
	
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		
		//check if two decks have the same card
		assertNotSame(g.deck1[4], g.deck2[4]);
		assertNotSame(g.deck1[20], g.deck2[20]);
		assertNotSame(g.deck1[30], g.deck2[30]);
		assertNotSame(g.deck1[40], g.deck2[40]);
		assertNotSame(g.deck1[50], g.deck2[50]);
		
	}
	
	
}
