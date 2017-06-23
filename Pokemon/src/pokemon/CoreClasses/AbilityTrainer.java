package pokemon.CoreClasses;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;

public class AbilityTrainer {
	
	
	public void shuffle(Card[] deck)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = deck.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Card a = deck[index];
	      deck[index] = deck[i];
	      deck[i] = a;
	    }
	  }
	
	//draw 3 cards
	public void ability31_Tierno(Play p, GameEngine g){
		p.drawOneCard(g);
		p.drawOneCard(g);
		p.drawOneCard(g);
	}
	
	//heal
	public void ability32_Potion(CardPokemon c){
		c.m_hp = c.m_hp + 30;
	}
	
	public void ability33_MistyDetermination(){
		System.out.println("not developed");
	}
	
	// heal and destat
	public void ability34_PokmonCenterLady(CardPokemon a){
		a.m_hp = a.m_hp + 60;
		a.removeStatus();
	}
	
	//search
	public void ability35_Clemont(Play p, GameEngine g){
		int count = 0;
		int top = p.deck_top;

		//if it's human player, use deck1
		if(!p.role){
			for(int i = top ; i < g.deck1.length ; i++){
				if(count <= 4){
					if(g.deck1[i].m_type == 1){
						for(int j = 0; j < p.hand.length; j++){
							if(p.hand[j] == null){
								p.hand[j] = g.deck1[i];
								g.deck1[i] = null;
								top = top + 1;
								count ++;
								break;
							}
						}
					}
				}else{break;}
			}
		}
		//if it's AI player
		else{
			for(int i = top ; i < g.deck2.length ; i++){
				if(count <= 4){
					if(g.deck2[i].m_type == 1){
						for(int j = 0; j < p.hand.length; j++){
							if(p.hand[j] == null){
								p.hand[j] = g.deck2[i];
								g.deck2[i] = null;
								top = top + 1;
								count ++;
								break;
							}
						}
					}
				}else{break;}
			}
		}
		
		
	}
	
	public void ability67_FloralCrown(CardPokemon c){
		c.m_hp = c.m_hp + 20;
	}
	
	public void ability68_PokemonBall(Play p, GameEngine g){
		
		//flip a coin		
		int a = ThreadLocalRandom.current().nextInt(0,2);
		if(a == 1){
			int count = 0;
			int top = p.deck_top;

			//if it's human player, use deck1
			if(!p.role){
				for(int i = top ; i < g.deck1.length ; i++){
					if(count <= 1){
						if(g.deck1[i].m_type == 0){
							for(int j = 0; j < p.hand.length; j++){
								if(p.hand[j] == null){
									p.hand[j] = g.deck1[i];
									g.deck1[i] = null;
									top = top + 1;
									count ++;
									break;
								}
							}
						}
					}else{break;}
				}
			}
			//if it's AI player
			else{
				for(int i = top ; i < g.deck2.length ; i++){
					if(count <= 1){
						if(g.deck2[i].m_type == 0){
							for(int j = 0; j < p.hand.length; j++){
								if(p.hand[j] == null){
									p.hand[j] = g.deck2[i];
									g.deck2[i] = null;
									top = top + 1;
									count ++;
									break;
								}
							}
						}
					}else{break;}
				}
			}
			
		}
		else{
			System.out.println("not able to use this ability");
		}
	}
	
	public void ability69_Shauna(Play p, GameEngine g){
		//deck
		//shuffle your own deck
		if(!p.role){
			shuffle(g.deck1);
		}
		else{
			shuffle(g.deck2);
		}
		//draw 5 cards
		for(int i = 0; i <5; i++){
			p.drawOneCard(g);
		}
	}
	
	public void ability70_PokmonFanClub(Play p, GameEngine g){
		int count = 0;
		int top = p.deck_top;

		//if it's human player, use deck1
		if(!p.role){
			for(int i = top ; i < g.deck1.length ; i++){
				if(count <= 2){
					if(g.deck1[i].m_type == 0 && ((CardPokemon)g.deck1[i]).m_pokemonType == 0){
						for(int j = 0; j < p.hand.length; j++){
							if(p.hand[j] == null){
								p.hand[j] = g.deck1[i];
								g.deck1[i] = null;
								top = top + 1;
								count ++;
								break;
							}
						}
					}
				}else{break;}
			}
		}
		//if it's AI player
		else{
			for(int i = top ; i < g.deck2.length ; i++){
				if(count <= 2){
					if(g.deck2[i].m_type == 0 && ((CardPokemon)g.deck2[i]).m_pokemonType == 0){
						for(int j = 0; j < p.hand.length; j++){
							if(p.hand[j] == null){
								p.hand[j] = g.deck2[i];
								g.deck2[i] = null;
								top = top + 1;
								count ++;
								break;
							}
						}
					}
				}else{break;}
			}
		}
		//shuffle
		if(!p.role){
			shuffle(g.deck1);
		}
		else{
			shuffle(g.deck2);
		}
		
	}
	
	public void ability71_Switch(CardPokemon active, CardPokemon bench){
		CardPokemon a = active;
		active = bench;
		bench = a;
	}
	
	//reenergize
	public void ability72_EnergySwitch(CardPokemon source, CardPokemon destination, int amount){
		source.m_energy = source.m_energy - amount*10;
		destination.m_energy = destination.m_energy + amount*10;
		for(int i = 0; i < amount; i ++){
			destination.m_energyCards.add(source.m_energyCards.removeLast());
		}
	}
	
	public void ability73_RedCard(Play p, GameEngine g){
		//deck 
		//shuffle
		if(!p.role){
			shuffle(g.deck1);
		}
		else{
			shuffle(g.deck2);
		}
		//draw opponent 4 cards
	}
	
	public void ability74_Wally(Play p, GameEngine g){
		int count = 0;
		int top = p.deck_top;

		//if it's human player, use deck1
		if(!p.role){
			for(int i = top ; i < g.deck1.length ; i++){
				if(count <= 1){
					if(g.deck1[i].m_type == 0 && ((CardPokemon)g.deck1[i]).m_pokemonType == 0){
						for(int j = 0; j < p.hand.length; j++){
							if(p.hand[j] == null){
								p.hand[j] = g.deck1[i];
								g.deck1[i] = null;
								top = top + 1;
								count ++;
								break;
							}
						}
					}
				}else{break;}
			}
		}
		//if it's AI player
		else{
			for(int i = top ; i < g.deck2.length ; i++){
				if(count <= 1){
					if(g.deck2[i].m_type == 0 && ((CardPokemon)g.deck2[i]).m_pokemonType == 0){
						for(int j = 0; j < p.hand.length; j++){
							if(p.hand[j] == null){
								p.hand[j] = g.deck2[i];
								g.deck2[i] = null;
								top = top + 1;
								count ++;
								break;
							}
						}
					}
				}else{break;}
			}
		}
		//shuffle
		if(!p.role){
			shuffle(g.deck1);
		}
		else{
			shuffle(g.deck2);
		}
	}
	
}
