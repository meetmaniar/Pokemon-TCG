package pokemon;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;

public class GameEngine {

	Card deck1[], deck2[];

	GameEngine() {

	}

	public void initGame() {
		// initialize the game by starting parser, and initializing the core
		// classes
		deck1 = new Card[30];
		deck2 = new Card[30];
		// ----------------------------------DECK
		// 1----------------------------------------------//
		// prepare the deck1
		CardPokemon[] pokemon = new CardPokemon[5];
		pokemon[0].initPokemon("Pikachu", 0, 40);
		pokemon[1].initPokemon("Electabuzz", 0, 80);
		pokemon[2].initPokemon("Celebi", 0, 50);
		pokemon[3].initPokemon("Eevee", 0, 70);
		pokemon[4].initPokemon("Ditto", 0, 90);

		CardTrainer[] trainer = new CardTrainer[5];
		trainer[0].initTrainer("Pokemon Center Lady", 0, 40);
		trainer[1].initTrainer("Potion", 0, 30);
		trainer[2].initTrainer("Super Power", 0, 30);
		trainer[3].initTrainer("Upgrade Power", 0, 20);
		trainer[4].initTrainer("Misty Power", 0, 10);

		CardEnergy[] energy = new CardEnergy[20];
		energy[0].initEnergy(0, 40);
		energy[1].initEnergy(0, 30);
		energy[2].initEnergy(0, 30);
		energy[3].initEnergy(0, 20);
		energy[4].initEnergy(0, 10);
		energy[5].initEnergy(0, 40);
		energy[6].initEnergy(0, 30);
		energy[7].initEnergy(0, 30);
		energy[8].initEnergy(0, 20);
		energy[9].initEnergy(0, 10);
		energy[10].initEnergy(0, 40);
		energy[11].initEnergy(0, 30);
		energy[12].initEnergy(0, 30);
		energy[13].initEnergy(0, 20);
		energy[14].initEnergy(0, 10);
		// Add trainer cards to deck
		for (int i = 0; i < 5; i++) {
			deck1[i] = trainer[i];
		}
		// Add pokemon cards to deck
		for (int i = 6; i < 10; i++) {
			deck1[i] = pokemon[i];
		}
		// Add energy cards to deck
		for (int i = 11; i < 30; i++) {
			deck1[i] = energy[i];
		}
		// --------------------------------------------------------------------------------//

		// -----------------------------------DECK
		// 2---------------------------------------------//
		// prepare the deck2
		CardPokemon[] pokemon2 = new CardPokemon[5];
		pokemon2[0].initPokemon("Charmender", 0, 40);
		pokemon2[1].initPokemon("Charizard", 0, 80);
		pokemon2[2].initPokemon("Mewtwo", 0, 50);
		pokemon2[3].initPokemon("Greninja", 0, 70);
		pokemon2[4].initPokemon("Gengar", 0, 90);

		CardTrainer[] trainer2 = new CardTrainer[5];
		trainer2[0].initTrainer("Pokemon Center Lady", 0, 40);
		trainer2[1].initTrainer("Potion", 0, 30);
		trainer2[2].initTrainer("Super Power", 0, 30);
		trainer2[3].initTrainer("Upgrade Power", 0, 20);
		trainer2[4].initTrainer("Misty Power", 0, 10);

		CardEnergy[] energy2 = new CardEnergy[20];
		energy2[0].initEnergy(0, 40);
		energy2[1].initEnergy(0, 30);
		energy2[2].initEnergy(0, 30);
		energy2[3].initEnergy(0, 20);
		energy2[4].initEnergy(0, 10);
		energy2[5].initEnergy(0, 40);
		energy2[6].initEnergy(0, 30);
		energy2[7].initEnergy(0, 30);
		energy2[8].initEnergy(0, 20);
		energy2[9].initEnergy(0, 10);
		energy2[10].initEnergy(0, 40);
		energy2[11].initEnergy(0, 30);
		energy2[12].initEnergy(0, 30);
		energy2[13].initEnergy(0, 20);
		energy2[14].initEnergy(0, 10);

		// Add trainer cards to deck
		for (int i = 0; i < 5; i++) {
			deck2[i] = trainer2[i];
		}
		// Add pokemon cards to deck
		for (int i = 6; i < 10; i++) {
			deck2[i] = pokemon2[i];
		}
		// Add energy cards to deck
		for (int i = 11; i < 30; i++) {
			deck2[i] = energy2[i];
		}
		// --------------------------------------------------------------------------------//

		doShuffle(deck1);
		doShuffle(deck2);

		initUI();
	}

//	public void doParse() {
//		// Add the parser thread
//
//	}

	public void doShuffle(Card deck[]) {

		// do the shuffling for the cards

	}

	public void initUI() {
		// init the UI
		GameView game = new GameView();
		game.setVisible(true);

	}

}
