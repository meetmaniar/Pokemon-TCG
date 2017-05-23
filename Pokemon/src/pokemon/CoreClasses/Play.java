package pokemon.CoreClasses;


import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;




public class Play {
	
	public Card active;
	public Card bench[];
	public Card hand [];
	public Card prize[];
	public Card discard[];
	public Card shuffled_deck[];
	
	int bench_top;
	int prize_top;
	int discard_top;
	int deck_top;
	int hand_top;
	
	boolean role;
	
	
	public Play(){	
		active = new Card();
		bench = new Card[5];
		hand = new Card[15];
		prize = new Card[6];
		discard = new Card[30];
		shuffled_deck = new Card[15];
		
	}
	
	//if player is AI, set role to true 
	public void setDeck(){
		role = true;
	}
	public void handToBench(int hand_index){
		System.arraycopy(hand, hand_index, bench, 0, 1);
		for(int i=hand_index+1;i<=hand.length;i++)
		{
			hand[i-1]=hand[i];    /*Please check this method*/
		}
		
	}
	

	public void drawSevenCards(GameEngine g){
		if(!role){
			deck_top = 0;
			for(int i = 0; i < 7; i++){
				hand[i] = g.deck1[deck_top];
				deck_top = deck_top + 1;
			}
		}
		else{
			deck_top = 0;
			for(int i = 0; i < 7; i++){
				hand[i] = g.deck2[deck_top];
				deck_top = deck_top + 1;
			}
		}
		
		
	}
	
	public void drawPrizeCards(GameEngine g){
		if(!role){
			for(int i = 0; i < 6; i++){
				prize[i] = g.deck1[deck_top];
				deck_top = deck_top + 1;
			}
		}
		else{
			for(int i = 0; i < 6; i++){
				prize[i] = g.deck2[deck_top];
				deck_top = deck_top + 1;
			}
		}
		
	}
	
	public void drawOneCard(GameEngine g){
		if(!role){
			if(deck_top == 61){
				System.out.println("No cards in decks");
			}
			for(int i = 0; i <hand.length; i++){
				if(hand[i] == null){
					hand[i] = g.deck1[deck_top];
					deck_top = deck_top + 1;
					break;
				}
			}
		}
		else{
			if(deck_top == 61){
				System.out.println("No cards in decks");
			}
			for(int i = 0; i <hand.length; i++){
				if(hand[i] == null){
					hand[i] = g.deck2[deck_top];
					deck_top = deck_top + 1;
					break;
				}
			}
		}
		
	}
	
	public void placeActive( int i){
		active = hand[i];
		
		System.out.println("Poke" + hand[i].m_type);
		((CardPokemon) active).m_active = true;
		swap(hand,i);
	}
	
	//organize card in hand and bench
	public void swap(Card c[], int i){
		for(int m = i; m < c.length-1; m++ ){
			if(i == hand.length - 1){
				hand[m] = null;
			}
			else{
				System.out.println("Value of m "+m);
				hand[m] = hand [m+1];
			}	
		}
	}
	
	public void placeBench(int i){
		bench[bench_top] = hand[i];
		bench_top = bench_top + 1;
		swap(hand, i);
	}
	
	//choose card in hand[i] to evolve pokemon on active
	public void evolveActive(int i){
		Card a = active;
		active = hand[i];
		((CardPokemon) active).m_active = ((CardPokemon) a).m_active;
		((CardPokemon) active).m_energyCards = ((CardPokemon) a).m_energyCards;
		((CardPokemon) active).m_energy = ((CardPokemon) a).m_energy;
		((CardPokemon) active).removeStatus();
		swap(hand, i);
	}
	
	//choose card in hand[i] to evolve pokemon on bench[j]
	public void evolveBench(int i, int j){
		Card a = bench[j];
		bench[j] = hand[i];
		((CardPokemon) bench[j]).m_active = ((CardPokemon) a).m_active;
		((CardPokemon) bench[j]).m_energyCards = ((CardPokemon) a).m_energyCards;
		((CardPokemon) bench[j]).m_energy = ((CardPokemon) a).m_energy;
		((CardPokemon) bench[j]).removeStatus();
		swap(hand, i);
	}
	
	
	public void pickPrize(){
		for(int i = 0; i <prize.length; i++){
			if(hand[i] == null){
				hand[i] = prize[prize_top];
				prize_top = prize_top + 1;
				break;
			}
		}
	}
	
	
	public void dropDiscard(Card c){
		discard[discard_top] = c;
		discard_top = discard_top + 1;
	}
	
	//choose card in hand[i] to evolve pokemon on bench[j]
	public void attachEnergyBench( int i, int j){
		((CardPokemon) bench[j]).addEnergy((CardEnergy) hand[i]);
		swap(hand, i);
		
	}
	
	//choose card in hand[i] to evolve pokemon on bench[j]
	public void attachEnergyActive( int i){
		((CardPokemon) active).addEnergy((CardEnergy) hand[i]);
		swap(hand, i);
		
	}
	
	public void useTrainerCard(CardTrainer a, CardPokemon c, CardPokemon d){
		switch(a.trainer_ability) {

			case 1:
					a.abilityTrainer.ability1_Tierno(this);

			case 2:
					a.abilityTrainer.ability2_Potion(c);;

			case 3:
					a.abilityTrainer.ability3_MistyDetermination();

			case 4:
					a.abilityTrainer.ability4_PokmonCenterLady(c, d);
					
			case 5:
					//a.abilityTrainer.ability5_Clemont(this, g);
					
			case 6:
					a.abilityTrainer.ability6_FloralCrown();
					
			case 7:
					//a.abilityTrainer.ability7_PokemonBall(this, g);
			
			case 8:
					a.abilityTrainer.ability8_Shauna();
					
			case 9:
					//a.abilityTrainer.ability9_PokmonFanClub(this, g);
			
			case 10:
					a.abilityTrainer.ability10_Switch((CardPokemon) active, c);
				
			case 11:
					a.abilityTrainer.ability11_EnergySwitch(c, d, 20);
			
			case 12:
					a.abilityTrainer.ability12_RedCard();
			
			case 13:
					a.abilityTrainer.ability13_Wally();

			default:
					System.out.println("do nothing");

		}
	}
	
//	public Card search(GameEngine g, int type){
//		if(!role){
//			for(int i = 0; i <= g.deck1.length; i++){
//				if(g.deck1[deck_top+i].m_type == type){
//					deck_top = deck_top + 1;
//					return g.deck1[deck_top+i-1];
//				}
//			}
//		}
//		else{
//			for(int i = 0; i <= g.deck1.length; i++){
//				if(g.deck2[deck_top+i].m_type == type){
//					deck_top = deck_top + 1;
//					return g.deck2[deck_top+i-1];
//				}
//			}
//		}
//		return null;
//	}
	
//	public Card searchBasicPokemon(GameEngine g){
//		if(!role){
//			for(int i =  ; i <= g.deck1.length; i++){
//				if(g.deck1[deck_top+i].m_type == 0 && ((CardPokemon)g.deck1[deck_top+i]).m_pokemonType == 0){
//					deck_top = deck_top + 1;
//					return g.deck1[deck_top+i-1];
//				}
//			}
//		}
//		else{
//			for(int i = 0; i <= g.deck1.length; i++){
//				if(g.deck2[deck_top+i].m_type == 0 && ((CardPokemon)g.deck2[deck_top+i]).m_pokemonType == 0){
//					deck_top = deck_top + 1;
//					return g.deck2[deck_top+i-1];
//				}
//			}
//		}
//		return null;
//	}
	
	public void retreatActive(int i){
		((CardPokemon) active).retreat();
	}
	
	public void attack1(CardPokemon opponent){
		((CardPokemon) active).attackBasic(opponent);
	}
	
	public void attack2(CardPokemon opponent){
		((CardPokemon) active).attackAdvance(opponent);
	}
	
	public void checkKnock(CardPokemon a){
		if(a.m_hp <= 0){
			dropDiscard(a);
			active = null;
		}
	}
	
	public void checkCondition(CardPokemon a){
		switch(a.m_statusEffect) {
		
		case 1:
			a.m_statusEffect = 0;
					
		case 2:
			
		{	//flip a coin
			int i = ThreadLocalRandom.current().nextInt(0,2);
			if(i == 1){
				a.m_statusEffect = 0;
			}
		}	
							
		case 3:
			a.m_statusEffect = 0;
					
		case 4:
			a.m_statusEffect = 0;
			
		default:
			a.m_statusEffect = 0;
		}
	}
	
	public boolean checkEnd(Play opponent){
		if(prize == null){
			System.out.println("Congrats! You Win");
			return true;
		}
		if(opponent.active == null && opponent.bench == null){
			System.out.println("Congrats! You Win");
			return true;
		}
		if(!role){
			if(opponent.deck_top == 61){
				System.out.println("Congrats! You Win!");
				return true;
			}
		}
		else{
			if(opponent.deck_top == 61){
				System.out.println("Oops! You Lose!");
				return true;
			}
		}
		return true;
		
	}
	
	//------ AI Function ------// 
	
	
	public void nextMove()
	{
	
		addPokemonToBenchForAI();
		selectActivePokemon();
		addEnergyToAP();
		attack();
		//refreshUI();
	}
	
	
	
	
	public void selectActivePokemon()
	{	
		//1. Return false if the active Pokemon is available else select the new pokemon
		
		//2. check the hand to select the most powerful pokemon to make the acitve pokemon.
		
	}
	
	public void addPokemonToBenchForAI()
	{
		// check the hand to see if the pokemon is available, If yes, Move it to deck.
	int selected_pokemon=0,max_hp=0;
		for(int i=0;i<hand_top;i++)
		{
			if(hand[i].m_type==0)
			{
				int temp=((CardPokemon)hand[i]).m_hp;
				if(temp>max_hp)
				{
					selected_pokemon=i;
					max_hp=temp;
				}	
			}
		}
		placeBench(selected_pokemon);
	}
	
	
	
	public void addEnergyToAP()
	{
		// check if Energy Card is available in the deck, Attach the energy card to the AP
	
		for(int i=0;i<hand_top;i++)
		{
			if(hand[i].m_type==1)
			{
				//int temp=(CardEnergy)
			}
		}
		
		
	}
	
	public void attack()
	{
		// Create the Damage
	
	}
	
}
