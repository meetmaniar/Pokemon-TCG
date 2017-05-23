package pokemon;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class GameEngine {

	public Card[] deck1 = new Card[25];
	public Card[] deck2 = new Card[25];

	GameEngine() {

	}

	public void initGame() {
		// initialize the game by starting parser, and initializing the core
		// classes
		// deck1 = new Card[30];
		// deck2 = new Card[30];

		int deck1_top = 0, deck2_top = 0;
		// ----------------------------------DECK
		// 1----------------------------------------------//
		// prepare the deck1
		CardPokemon[] pokemon = new CardPokemon[5];

		for (int i = 0; i < 5; i++)
			pokemon[i] = new CardPokemon();

		try {

			pokemon[0].initPokemon("Meowstic", 0, 30, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top);
			pokemon[1].initPokemon("Jynx", 0, 40, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top);
			pokemon[2].initPokemon("Jirachi", 0, 60, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top);
			pokemon[3].initPokemon("Meowth", 0, 80, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top);
			pokemon[4].initPokemon("Machop", 0, 120, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
					deck2_top, deck2_top, deck2_top, deck2_top);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CardTrainer[] trainer = new CardTrainer[5];

		for (int i = 0; i < 5; i++)
			trainer[i] = new CardTrainer();
		try {

			trainer[0].initTrainer("Pokemon Center Lady", 0,1);
			trainer[1].initTrainer("Potion", 0,2);
			trainer[2].initTrainer("Super Power", 0,3);
			trainer[3].initTrainer("Upgrade Power", 0,4);
			trainer[4].initTrainer("Misty Power", 0,5);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		CardEnergy[] energy = new CardEnergy[20];

		for (int i = 0; i < 20; i++)
			energy[i] = new CardEnergy();

		try {
			energy[0].initEnergy(1);
			energy[1].initEnergy(1);
			energy[2].initEnergy(1);
			energy[3].initEnergy(1);
			energy[4].initEnergy(1);
			energy[5].initEnergy(1);
			energy[6].initEnergy(1);
			energy[7].initEnergy(1);
			energy[8].initEnergy(1);
			energy[9].initEnergy(1);
			energy[10].initEnergy(1);
			energy[11].initEnergy(1);
			energy[12].initEnergy(1);
			energy[13].initEnergy(1);
			energy[14].initEnergy(1);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// Add trainer cards to deck
		for (int i = 0; i < 5; i++) {
			deck1[deck1_top] = trainer[i];
			deck1_top++;
		}
		// Add pokemon cards to deck
		for (int i = 0; i < 5; i++) {
			deck1[deck1_top] = pokemon[i];
			deck1_top++;
		}
		// Add energy cards to deck
		for (int i = 0; i < 15; i++) {
			deck1[deck1_top] = energy[i];
			deck1_top++;
		}
		// --------------------------------------------------------------------------------//

		// -----------------------------------DECK
		// 2---------------------------------------------//

		// fetched from card.txt
		// prepare the deck2
		CardPokemon[] pokemon2 = new CardPokemon[5];

		for (int i = 0; i < 5; i++)
			pokemon2[i] = new CardPokemon();

		pokemon2[0].initPokemon("Meowstic", 0, 0, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
				deck2_top, deck2_top, deck2_top, deck2_top);
		pokemon2[1].initPokemon("Jynx", 0, 0, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
				deck2_top, deck2_top, deck2_top, deck2_top);
		pokemon2[2].initPokemon("Jirachi", 0, 0, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
				deck2_top, deck2_top, deck2_top, deck2_top);
		pokemon2[3].initPokemon("Meowth", 0, 0, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
				deck2_top, deck2_top, deck2_top, deck2_top);
		pokemon2[4].initPokemon("Machop", 0, 0, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top, deck2_top,
				deck2_top, deck2_top, deck2_top, deck2_top);

		CardTrainer[] trainer2 = new CardTrainer[5];
		for (int i = 0; i < 5; i++)
			trainer2[i] = new CardTrainer();

		trainer2[0].initTrainer("Pokemon Center Lady", 0,6);
		trainer2[1].initTrainer("Potion", 0,7);
		trainer2[2].initTrainer("Super Power", 0,8);
		trainer2[3].initTrainer("Upgrade Power", 0,9);
		trainer2[4].initTrainer("Misty Power", 0,10);

		CardEnergy[] energy2 = new CardEnergy[5];
		for (int i = 0; i < 5; i++)
			energy2[i] = new CardEnergy();

		energy2[0].initEnergy(1);
		energy2[1].initEnergy(1);
		energy2[2].initEnergy(1);
		energy2[3].initEnergy(1);
		energy2[4].initEnergy(1);

		// Add trainer cards to deck
		for (int i = 0; i < 5; i++) {
			deck2[deck2_top] = trainer2[i];
			deck2_top++;
		}

		// Add pokemon cards to deck
		for (int i = 0; i < 5; i++) {
			deck2[deck2_top] = pokemon2[i];
			deck2_top++;
		}

		// Add energy cards to deck
		for (int i = 0; i < 5; i++) {
			deck2[deck2_top] = energy2[i];
			deck2_top++;
		}

		// --------------------------------------------------------------------------------//

		doShuffle(deck1);

		/*
		 * for(int a=0; a<deck1.length; a++) {
		 * System.out.print(deck1[a].m_type+" "); }
		 */

		//doShuffle(deck2);

		/*
		 * System.out.println(); for(int a=0; a<deck2.length; a++) {
		 * System.out.print(deck2[a].m_type+" "); }
		 */

		// Initializing Deck 1 to AI and Deck 2 to HUMAN
		GameView.AI.hand = deck1;
		GameView.HUMAN.hand = deck2;

		initUI();
	}

	// public void doParse() {
	// // Add the parser thread
	//
	// }

	public void doShuffle(Card[] deck) {
		// Card[] decks = new Card[deck.length];
		// for(int k = 0; k<deck.length; k++)
		// decks[k] = deck[k];
		// do the shuffling for the cards
		try {
			Random rnd = ThreadLocalRandom.current();
			for (int i = deck.length - 1; i > 0; i--) {
				int index = rnd.nextInt(i + 1);
				// Simple swap
				Card a;
				
				
				
				
				
				
				a = deck[index];
				deck[index] = deck[i];
				deck[i] = a;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int j = 0; j < deck.length - 1; j++) {
			try {
				// System.out.println("Type of the pokemon "+deck[j].m_type + "
				// ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Shuffling Done");

	}

	public void initUI() {
		// init the UI
		GameView game = new GameView();
		game.setVisible(true);

	}

}
