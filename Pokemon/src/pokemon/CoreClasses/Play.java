package pokemon.CoreClasses;


import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;



public class Play {
	
	public Card active;
	public Card bench[];
	public Card hand [];
	public Card prize[];
	public Card discard[];
	int bench_top;
	int prize_top;
	int discard_top;
	int deck_top;
	boolean role;
	
	public Play(){	
		active = new Card();
		bench = new Card[5];
		hand = new Card[30];
		prize = new Card[6];
		discard = new Card[60];
	}
	
	//if player is AI, set role to true 
	public void setDeck(){
		role = true;
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
			for(int i = 0; i <hand.length; i++){
				if(hand[i] == null){
					hand[i] = g.deck1[deck_top];
					deck_top = deck_top + 1;
					break;
				}
			}
		}
		else{
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
		((CardPokemon) active).m_active = true;
		swap(hand,i);
	}
	
	//organize card in hand and bench
	public void swap(Card c[], int i){
		for(int m = i; m < c.length; m++ ){
			if(i == hand.length - 1){
				hand[m] = null;
			}
			else{
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
	
	public void useTrainer(CardTrainer a){
		
	}
	
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
	
	public boolean checkEnd(GameEngine g, Play opponent){
		if(prize == null){
			System.out.println("Congrats! You Win");
			return true;
		}
		if(opponent.active == null && opponent.bench == null){
			System.out.println("Congrats! You Win");
			return true;
		}
		if(!role){
			if(g.deck2 == null){
				System.out.println("Congrats! You Win!");
				return true;
			}
		}
		else{
			if(g.deck1 == null){
				System.out.println("Oops! You Lose!");
				return true;
			}
		}
		return true;
		
	}
	
	
	
	
}
