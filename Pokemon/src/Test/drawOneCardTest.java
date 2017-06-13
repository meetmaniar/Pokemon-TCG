package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;

public class drawOneCardTest {

	@Test
	public void test() {
		Play player = new Play();
		GameEngine g = new GameEngine();
		int deck2_top = 0;
		int deck1_top = 0;
		int result1;
		int result2;
		
		CardPokemon[] pokemon = new CardPokemon[5];

		for (int i = 0; i < 5; i++)
			pokemon[i] = new CardPokemon();

//		try {
			pokemon[0].initPokemon("Meowstic", 0, 0, deck2_top, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[1].initPokemon("Jynx", 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[2].initPokemon("Jirachi", 0, 0, deck2_top, deck2_top, deck2_top,0,0, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[3].initPokemon("Meowth", 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[4].initPokemon("Machop", 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		CardTrainer[] trainer = new CardTrainer[5];

		for (int i = 0; i < 5; i++)
			trainer[i] = new CardTrainer();
//		try {

			trainer[0].initTrainer("Pokemon Center Lady", 0,1);
			trainer[1].initTrainer("Potion", 0,2);
			trainer[2].initTrainer("Super Power", 0,3);
			trainer[3].initTrainer("Upgrade Power", 0,4);
			trainer[4].initTrainer("Misty Power", 0,5);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}

		CardEnergy[] energy = new CardEnergy[20];

		for (int i = 0; i < 5; i++)
		{
			energy[i] = new CardEnergy();
			energy[i].initEnergy(1);
		}
		
		// Add trainer cards to deck
		for (int i = 0; i < 5; i++) {
			g.deck1[deck1_top] = trainer[i];
			deck1_top++;
		}
		// Add pokemon cards to deck
		for (int i = 0; i < 5; i++) {
			g.deck1[deck1_top] = pokemon[i];
			deck1_top++;
		}
		// Add energy cards to deck
		for (int i = 0; i < 5; i++) {
			g.deck1[deck1_top] = energy[i];
			deck1_top++;
		}
		
		
		player.drawOneCard(g);
		result1 = g.deck1[0].m_type;
		result2 = player.hand[0].m_type;
		assertEquals(result1, result2);
			
	}

	

}
