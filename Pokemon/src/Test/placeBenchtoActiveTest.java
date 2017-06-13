package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.Play;

public class placeBenchtoActiveTest {

	@Test
	public void test() {
		Play player = new Play();
		CardPokemon[] pokemon = new CardPokemon[5];
		int deck1_top = 0;
		int deck2_top = 0;
		Card result1;
		Card result2;
		for (int i = 0; i < 5; i++)
			pokemon[i] = new CardPokemon();

		try {
			pokemon[0].initPokemon("Meowstic", 0, 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top, 0);
			pokemon[1].initPokemon("Jynx", 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[2].initPokemon("Jirachi", 0, 0, deck2_top, deck2_top, deck2_top,0,0, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[3].initPokemon("Meowth", 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
			pokemon[4].initPokemon("Machop", 0, 0, deck2_top, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			player.bench[deck1_top] = pokemon[i];
			deck1_top++;
		}
		
		result1 = player.bench[1];
		player.placeBenchtoActive(1);
		result2 = player.active;
		assertEquals(result1, result2);
		
	}

}
