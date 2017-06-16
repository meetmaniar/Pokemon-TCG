package pokemon.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import pokemon.CoreClasses.Card;

public class DeckBuilder {

	
	private LinkedList<DeckBuilderCard> m_cards;
	
	
	public static int toTrainerType(String trainerTypeName) { 
		if (trainerTypeName.equals("stadium")) { return 0; }
		if (trainerTypeName.equals("supporter")) { return 1; }
		if (trainerTypeName.equals("item")) { return 2; }
		
		System.out.println("ERROR: Unknown trainer type name passed to toTrainerType: " + trainerTypeName);
		return -1;	}
	
	public static int toColorId(String colorName) {
				
		if (colorName.equals("water")) { return 0; }
		if (colorName.equals("lightning")) { return 1; }
		if (colorName.equals("psychic")) { return 2; }
		if (colorName.equals("fight")) { return 3; }
		if (colorName.equals("colorless")) { return 4; }
		
		System.out.println("ERROR: Unknown color name passed to toColorId: " + colorName);
		return -1;
	}
	
	public static String toColorString(int colorId) {
		
		switch(colorId) {
		case 0: return "water";
		case 1: return "ligthning";
		case 2: return "psychic";
		case 3: return "fighting";
		case 4: return "colorless";
		default: return "";
		}
		
	}
	
	
	public DeckBuilder(String cardsFilePath) {
		
		
		m_cards = new LinkedList<DeckBuilderCard>(); 
		
		// Loadup all the cards.
		BufferedReader cardsReader = null;
		try {
			cardsReader = new BufferedReader(new FileReader(cardsFilePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Read everything.
		String line = null;
		try {
			line = cardsReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] cardType;
		while (line != null) {
			
			// Split line to check what type of card we have.
			cardType = line.split(":");
			if (cardType.length > 1) {
				if (cardType[1].equals("pokemon")) { processPokemon(line); }
				else if (cardType[1].equals("trainer")) { processTrainer(line); }
				else if (cardType[1].equals("energy")) { processEnergy(line); }
				else { System.out.println("Unknown card: " + line); }
			}
			else {
				System.out.println("Not a card: " + line);
				m_cards.add(new DeckBuilderCard());
			}
			
			//line = null;
			try {
				line = cardsReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			cardsReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private void processPokemon(String line) {
		
		
		String[] divided = line.split("attacks:");
		
		//System.out.println("div1 " + divided[0]);
		//System.out.println("div2 " + divided[1]);
		
		// Fill up pokemon basic information.
		
		String[] pokInf = divided[0].split(":");
		
		int offset = 0;
		
		String pokemonName = pokInf[0];
				
		String pokemonEvolved = null;
		if (pokInf[3].equals("stage-one")) { offset++; pokemonEvolved = pokInf[4]; }
		else if (pokInf[3].equals("basic")) {  }
		else { System.out.println("\t Evolved: ERROR Invalid pokemon cat."); }
		
		String pokemonColor = pokInf[5 + offset];
		
		int hp = Integer.parseInt(pokInf[6 + offset]);
		
		String[] retreatDivided = divided[0].split("retreat:");
		
		String retreatCost;
		String retreatColor;
		if (retreatDivided.length < 2) {
			retreatCost = "0";
			retreatColor = "colorless";
		}
		else {
			String[] retrInf = retreatDivided[1].split(":");
			retreatColor = retrInf[1];
			retreatCost = retrInf[2];
		}
				
		DeckBuilderPokemonCard pokemon = new DeckBuilderPokemonCard();
		pokemon.addPokemonInformation(pokemonName, pokemonEvolved, toColorId(pokemonColor), hp);
		pokemon.addPokemonRetreatInformation(toColorId(retreatColor), Integer.parseInt(retreatCost));
		
		// Taking care of attacks.
		
		String[] attacks = divided[1].split(",");		
		
		
		// set newAttack to true
		
		// Split attack to attack string []
		
		// If attack string[] length == 3:
		// set newAttack to true
		
		// if attack string[] length == 2:
		// add color and cost to current attack
		// set newAttack to false
		
		
		
		
		
		
		// set newAttack to true
		
		// Split attack to attack string []
		// for (int i = 0; i < attack string length; i++) {
			// if (newAttack) {
				
				// Create blank attack (attackType and colorless1 both set to -1; everything else set to 0)
				// newAttack set to false.
		
			// if attack cat == colorless:
					// set colorless to 1; set colorlessCost
			
			// if attack cat != colorless:
					// set color to energy type; set attackCost
			
			// if abilityId specified:
				// add to attack.
				// set newAttack to true.
				
			
			// If attack string[] length == 3:
			// set newAttack to true
		
		
			boolean newAttack = true;
		
			for (int i = 0; i < attacks.length; i++) {
					
				String[] currentAttack = attacks[i].split(":");
				
				if (newAttack) {
					
					pokemon.newAttack();
					
					newAttack = false;
					
				}
				
				if (currentAttack[1].equals("colorless")) {
					
					int colorlessCost = Integer.parseInt(currentAttack[2]);
					
					pokemon.setAttackColorless(colorlessCost);
					
				}
				
				else {
					
					int color = toColorId(currentAttack[1]);
					int cost = Integer.parseInt(currentAttack[2]);
					
					pokemon.setAttackEnergy(color, cost);
					
				}
				
				if (currentAttack.length > 3) {
					
					int abilityId = Integer.parseInt(currentAttack[3]);
					pokemon.setAttackAbilityId(abilityId);
					
					newAttack = true;
					
				}
			
			}
			
		pokemon.print();
		
		m_cards.add(pokemon);
		
		
	}
	
	private void processTrainer(String line) {
		
		String[] trainerInfo = line.split(":");
		
		String trainerName = trainerInfo[0];
		String trainerTypeName = trainerInfo[3];
		String trainerAbilityId = trainerInfo[4];
		
		System.out.println("Trainer:");
		System.out.println("\t Name: " + trainerName);
		System.out.println("\t Type: " + trainerTypeName);
		System.out.println("\t AbilityID: " + trainerAbilityId);
		
		DeckBuilderTrainerCard card = new DeckBuilderTrainerCard(trainerName, toTrainerType(trainerTypeName), Integer.parseInt(trainerAbilityId));
		
		m_cards.add(card);
	}
	
	private void processEnergy(String line) {
		
		String[] energyInfo = line.split(":");

		String color = energyInfo[3];
		
		System.out.println("Energy:");

		System.out.println("\t Color: " + color);

		DeckBuilderEnergyCard card = new DeckBuilderEnergyCard(toColorId(color));
		
		m_cards.add(card);
		
		
	}
	
	public Card[] buildDeck(String deckFilePath) {
		
		System.out.println("Building deck: " + deckFilePath);
		
		BufferedReader deckReader = null;
		try {
			deckReader = new BufferedReader(new FileReader(deckFilePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Read everything.
		String line = null;
		try {
			line = deckReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ArrayList<Card> cards = new ArrayList<Card>();
		Card[] cards = new Card[60];
		int index = 0;
		
		while (line != null) {
		
			int cardId = Integer.parseInt(line);
			System.out.print("\t[" + cardId + "] ");
			DeckBuilderCard parsedCard = m_cards.get(cardId - 1);
			Card card = parsedCard.toPlayableCard();	
			cards[index] = card;
			index ++;
			
			
			
			try {
				line = deckReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			deckReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cards;
	
	}
		
}

