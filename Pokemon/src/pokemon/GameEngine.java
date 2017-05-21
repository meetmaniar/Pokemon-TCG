package pokemon;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;



public class GameEngine {

	Card[] deck1 = new Card[25];
	Card[] deck2 = new Card[25];

	GameEngine() {

	}

	public void initGame() {
		// initialize the game by starting parser, and initializing the core
		// classes
		//deck1 = new Card[30];
		//deck2 = new Card[30];
		
		int deck1_top=0,deck2_top=0;
		// ----------------------------------DECK
		// 1----------------------------------------------//
		// prepare the deck1
		CardPokemon[] pokemon = new CardPokemon[5];
		
		for(int i=0;i<5;i++)
		pokemon[i]= new CardPokemon();
		
		try{
		
		pokemon[0].initPokemon("Pikachu", 0, 40);
		pokemon[1].initPokemon("Electabuzz", 0, 80);
		pokemon[2].initPokemon("Celebi", 0, 50);
		pokemon[3].initPokemon("Eevee", 0, 70);
		pokemon[4].initPokemon("Ditto", 0, 90);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			
		CardTrainer[] trainer = new CardTrainer[5];
		
		for(int i=0;i<5;i++)
			trainer[i]= new CardTrainer();
		try{
		
		trainer[0].initTrainer("Pokemon Center Lady", 0, 40);
		trainer[1].initTrainer("Potion", 0, 30);
		trainer[2].initTrainer("Super Power", 0, 30);
		trainer[3].initTrainer("Upgrade Power", 0, 20);
		trainer[4].initTrainer("Misty Power", 0, 10);
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		CardEnergy[] energy = new CardEnergy[20];
		
		for(int i=0;i<20;i++)
			energy[i]= new CardEnergy();
		
		try{
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
		}
		
		catch(Exception e)
		{
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
		// prepare the deck2
		CardPokemon[] pokemon2 = new CardPokemon[5];
		
		for(int i=0;i<5;i++)
		pokemon2[i]= new CardPokemon();
		
		pokemon2[0].initPokemon("Charmender", 0, 40);
		pokemon2[1].initPokemon("Charizard", 0, 80);
		pokemon2[2].initPokemon("Mewtwo", 0, 50);
		pokemon2[3].initPokemon("Greninja", 0, 70);
		pokemon2[4].initPokemon("Gengar", 0, 90);

		CardTrainer[] trainer2 = new CardTrainer[5];
		for(int i=0;i<5;i++)
			trainer2[i]= new CardTrainer();
		trainer2[0].initTrainer("Pokemon Center Lady", 0, 40);
		trainer2[1].initTrainer("Potion", 0, 30);
		trainer2[2].initTrainer("Super Power", 0, 30);
		trainer2[3].initTrainer("Upgrade Power", 0, 20);
		trainer2[4].initTrainer("Misty Power", 0, 10);

		CardEnergy[] energy2 = new CardEnergy[20];
		for(int i=0;i<20;i++)
			energy2[i]= new CardEnergy();
		
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
			deck2[deck2_top] = trainer2[i];
			deck2_top++;
		}
		
		// Add pokemon cards to deck
		for (int i = 0; i < 5; i++) {
			deck2[deck2_top] = pokemon2[i];
			deck2_top++;
		}
		
		// Add energy cards to deck
		for (int i = 0; i < 15; i++) {
			deck2[deck2_top] = energy2[i];
			deck2_top++;
		}
		// --------------------------------------------------------------------------------//

		doShuffle(deck1);
	/*	for(int a=0; a<deck1.length; a++)
		{
			System.out.print(deck1[a].m_type+" ");
		}
		*/
		doShuffle(deck2);
	/*	System.out.println();
		for(int a=0; a<deck2.length; a++)
		{
			System.out.print(deck2[a].m_type+" ");
		}
		*/
		initUI();
	}

//	public void doParse() {
//		// Add the parser thread
//
//	}

	public void doShuffle(Card[] deck) {
		//Card[] decks = new Card[deck.length];
	//	for(int k = 0; k<deck.length; k++)
		//	decks[k] = deck[k];
		// do the shuffling for the cards
		try{
		Random rnd = ThreadLocalRandom.current();
		    for (int i = deck.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);
		      // Simple swap
		      Card a = new Card();
		       a = deck[index];
		      deck[index] = deck[i];
		      deck[i] = a;
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		    for (int j = 0; j < deck.length -1 ; j++)
		      {
		        System.out.println("Type of the pokemon "+deck[j].m_type + " ");
		      }
		      System.out.println();
		    
		    
	}

	public void initUI() {
		// init the UI
		GameView game = new GameView();
		game.setVisible(true);

	}

}
