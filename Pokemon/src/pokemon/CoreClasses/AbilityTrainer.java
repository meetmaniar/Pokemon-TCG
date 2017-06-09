package pokemon.CoreClasses;

import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;

public class AbilityTrainer {
	
	
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
	public void ability34_PokmonCenterLady(CardPokemon a, CardPokemon b){
		a.m_hp = a.m_hp + 60;
		b.removeStatus();
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
	}
	
}
