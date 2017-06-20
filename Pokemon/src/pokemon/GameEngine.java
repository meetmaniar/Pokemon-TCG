package pokemon;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.parser.DeckBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class GameEngine {

	public Card[] deck1 = new Card[60];
	public Card[] deck2 = new Card[60];

	public GameEngine() {

	}

	public void initGame() {
		
		DeckBuilder deck = new DeckBuilder("C:/Users/M_ANIAR/git/Pokemon-TCG/Pokemon/src/pokemon/parser/cards.txt");
		
		deck1 = deck.buildDeck("C:/Users/M_ANIAR/git/Pokemon-TCG/Pokemon/src/pokemon/parser/deck1.txt");
		deck2 = deck.buildDeck("C:/Users/M_ANIAR/git/Pokemon-TCG/Pokemon/src/pokemon/parser/deck2.txt");
		
		
		
//		// initialize the game by starting parser, and initializing the core
//		// classes
//		// deck1 = new Card[30];
//		// deck2 = new Card[30];
//
//		int deck1_top = 0, deck2_top = 0;
//		// ----------------------------------DECK
//		// 1----------------------------------------------//
//		// prepare the deck1
//		CardPokemon[] pokemon = new CardPokemon[5];
//
//		for (int i = 0; i < 5; i++)
//			pokemon[i] = new CardPokemon();
//
//		try {
//			pokemon[0].initPokemon("Pikachu", 0, 30,0, 50, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//					deck2_top, deck2_top, deck2_top, deck2_top);
//			pokemon[1].initPokemon("Raichu", 0, 40,0, 60, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//					deck2_top, deck2_top, deck2_top, deck2_top);
//			pokemon[2].initPokemon("Bulbasor", 0, 30,0, 70, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//					deck2_top, deck2_top, deck2_top, deck2_top);
//			pokemon[3].initPokemon("Gengar", 0, 20,0, 80, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//					deck2_top, deck2_top, deck2_top, deck2_top);
//			pokemon[4].initPokemon("TeamRocket", 0, 50,0, 40, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//					deck2_top, deck2_top, deck2_top, deck2_top);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		CardTrainer[] trainer = new CardTrainer[5];
//
//		for (int i = 0; i < 5; i++)
//			trainer[i] = new CardTrainer();
//		try {
//
//			trainer[0].initTrainer("Pokemon Center Lady", 0,1);
//			trainer[1].initTrainer("Potion", 0,2);
//			trainer[2].initTrainer("Super Power", 0,3);
//			trainer[3].initTrainer("Upgrade Power", 0,4);
//			trainer[4].initTrainer("Misty Power", 0,5);
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		CardEnergy[] energy = new CardEnergy[20];
//
//		for (int i = 0; i < 5; i++)
//		{
//			energy[i] = new CardEnergy();
//			energy[i].initEnergy(1);
//		}
//		
//		// Add trainer cards to deck
//		for (int i = 0; i < 5; i++) {
//			deck1[deck1_top] = trainer[i];
//			deck1_top++;
//		}
//		// Add pokemon cards to deck
//		for (int i = 0; i < 5; i++) {
//			deck1[deck1_top] = pokemon[i];
//			deck1_top++;
//		}
//		// Add energy cards to deck
//		for (int i = 0; i < 5; i++) {
//			deck1[deck1_top] = energy[i];
//			deck1_top++;
//		}
//		// --------------------------------------------------------------------------------//
//
//		// -----------------------------------DECK
//		// 2---------------------------------------------//
//
//		// fetched from card.txt
//		// prepare the deck2
//		CardPokemon[] pokemon2 = new CardPokemon[5];
//
//		for (int i = 0; i < 5; i++)
//			pokemon2[i] = new CardPokemon();
//
//		pokemon2[0].initPokemon("Meowstic", 0, 20,0, 50, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//				deck2_top, deck2_top, deck2_top, deck2_top);
//		pokemon2[1].initPokemon("Jynx", 0, 30,0, 60, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//				deck2_top, deck2_top, deck2_top, deck2_top);
//		pokemon2[2].initPokemon("Jirachi", 0, 40,0, 70, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//				deck2_top, deck2_top, deck2_top, deck2_top);
//		pokemon2[3].initPokemon("Meowth", 0, 50,0, 80, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//				deck2_top, deck2_top, deck2_top, deck2_top);
//		pokemon2[0].initPokemon("Machop", 0, 10,0, 40, deck2_top, deck2_top, 0,0,deck2_top, deck2_top, deck2_top,
//				deck2_top, deck2_top, deck2_top, deck2_top);
//
//		CardTrainer[] trainer2 = new CardTrainer[5];
//		for (int i = 0; i < 5; i++)
//			trainer2[i] = new CardTrainer();
//
//		trainer2[0].initTrainer("Pokemon Center Lady", 0,6);
//		trainer2[1].initTrainer("Potion", 0,7);
//		trainer2[2].initTrainer("Super Power", 0,8);
//		trainer2[3].initTrainer("Upgrade Power", 0,9);
//		trainer2[4].initTrainer("Misty Power", 0,10);
//
//		CardEnergy[] energy2 = new CardEnergy[5];
//		for (int i = 0; i < 5; i++)
//		{
//			energy2[i] = new CardEnergy();
//			energy2[i].initEnergy(1);
//		}
//		
//		
//
//		// Add trainer cards to deck
//		for (int i = 0; i < 5; i++) {
//			deck2[deck2_top] = trainer2[i];
//			deck2_top++;
//		}
//		
//		// Add pokemon cards to deck
//		for (int i = 0; i < 5; i++) {
//			deck2[deck2_top] = pokemon2[i];
//			deck2_top++;
//		}
//		// Add energy cards to deck
//		for (int i = 0; i < 5; i++) {
//			deck2[deck2_top] = energy2[i];
//			deck2_top++;
//		}
//		// --------------------------------------------------------------------------------//
//
//		doShuffle(deck1);
//
//		/*
//		 * for(int a=0; a<deck1.length; a++) {
//		 * System.out.print(deck1[a].m_type+" "); }
//		 */
//
//		doShuffle(deck2);

		/*
		 * System.out.println(); for(int a=0; a<deck2.length; a++) {
		 * System.out.print(deck2[a].m_type+" "); }
		 */

		GameView.AI.drawSevenCards(this);
		GameView.HUMAN.drawSevenCards(this);
		
		//GameView.AI.drawPrizeCards(this);
		//GameView.HUMAN.drawPrizeCards(this);
		
		// Initializing Deck 1 to AI and Deck 2 to HUMAN
		//GameView.AI.hand = deck1;
		//GameView.HUMAN.hand = deck2;

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
