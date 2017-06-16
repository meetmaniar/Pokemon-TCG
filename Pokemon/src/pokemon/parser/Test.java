package pokemon.parser;

import java.util.ArrayList;

import pokemon.CoreClasses.Card;

public class Test {

	
	public static void main(String args[]) {
		
		DeckBuilder deck = new DeckBuilder("C:/Users/Zac/Pokemon-TCG./cards.txt");
		
		Card[] myDeck1 = deck.buildDeck("C:/Users/Zac/Pokemon-TCG./deck1.txt");
		Card[] myDeck2 = deck.buildDeck("C:/Users/Zac/Pokemon-TCG./deck2.txt");
		
	}
	
	
}
