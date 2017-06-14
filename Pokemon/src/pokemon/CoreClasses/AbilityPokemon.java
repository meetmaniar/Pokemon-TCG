package pokemon.CoreClasses;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import pokemon.GameEngine;


public class AbilityPokemon {
	 
	public void dam(CardPokemon c, int amount){
		c.m_hp = c.m_hp - amount;
	}
	
	public void deenergize(CardPokemon c, int amount){
		c.m_energy = c.m_energy - amount*10;
		for(int i = 0; i < amount; i ++){
			c.m_energyCards.removeLast();
		}
	}
	
	public int count(Card[] c){
		int count = 0;
		for(int i =0; i <= c.length; i++){
			if(c[i] != null){
				count++;
			}
		}
		return count;
	}
	
	public void heal(CardPokemon c, int amount){
		c.m_hp = c.m_hp + amount;
	}
	
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
	
	public void ability1_ActCute(){
		
	}
	
	public void ability2_Scratch(CardPokemon active){
		dam(active,20);
	}
	
	public void ability3_QuickAttack(CardPokemon active){
		dam(active,10);
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active,30);
		}
	}
	
	public void ability4_FlyingElekick(CardPokemon active){
		dam(active,50);
	}
	
	public void ability5_Nuzzle(CardPokemon active){
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			active.m_statusEffect = 1;
		}else{
			System.out.println("Can't apply paralyzation");
		}
	}
	
	public void ability6_QuickAttack(CardPokemon active){
		dam(active,20);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active,10);
		}
		else{
			System.out.println("Can't apply 10 damage");
		}
	}
	
	public void ability7_CircleCircuit(Play p, CardPokemon active){
		dam(active, 20);
		int a = count(p.bench);
		dam(active, a*20);
	}
	
	public void ability8_Thunderbolt(Play p, CardPokemon active){
		dam(active,100);
		int num = ((CardPokemon)p.active).m_energy/10;
		deenergize(active, num);
	}
	
	public void ability9_RainSplash(CardPokemon active ){
		dam(active,20);
	}
	
	public void ability10_SoakingHorn(CardPokemon active){
		dam(active,10);
		//cond:healed
	}
	public void ability11_RecklessCharge(Play p, CardPokemon active){
		dam(active,40);
		dam((CardPokemon) p.active, 10);
		
	}
	public void ability12_RecklessCharge(Play p, CardPokemon active){
		dam(active,20);
		dam((CardPokemon) p.active, 10);
	}
	public void ability13_Cut(CardPokemon active){
		dam(active, 30);
	}
	public void ability14_Pound(CardPokemon active){
		dam(active, 10);
	}
	public void ability15_ClampCrush(CardPokemon active){
		dam(active, 30);
		//flip a coin and deenergize
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
		deenergize(active,1);	
		}
		//applystat
		active.paralize(active);
	}
	
	public void ability16_SpikeCannon(CardPokemon active){
		dam(active, 30);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active,30);	
		}else{
			System.out.println("Can't apply 30 damage");
		}
		//flip a coin
		int j = ThreadLocalRandom.current().nextInt(0,2);
		if(j == 1){
			dam(active,30);	
		}else{
			System.out.println("Can't apply 30 damage");
		}
		//flip a coin
		int k = ThreadLocalRandom.current().nextInt(0,2);
		if(k == 1){
			dam(active,30);	
		}else{
			System.out.println("Can't apply 30 damage");
		}
		//flip a coin
		int a = ThreadLocalRandom.current().nextInt(0,2);
		if(a == 1){
			dam(active,30);	
		}else{
			System.out.println("Can't apply 30 damage");
		}
		//flip a coin
		int b = ThreadLocalRandom.current().nextInt(0,2);
		if(b == 1){
			dam(active,30);	
		}else{
			System.out.println("Can't apply 30 damage");
		}
	}
	
	public void ability17_SpiralDrain(Play p, CardPokemon active){
		dam(active, 20);
		heal((CardPokemon) p.active, 20);
	}
	
	public void ability18_AuroraBeam(CardPokemon active){
		dam(active, 80);
	}
	
	public void ability19_WingAttack(CardPokemon active){
		dam(active, 20);
	}
	
	public void ability20_BraveBird(Play p, CardPokemon active){
		dam(active, 80);
		dam((CardPokemon) p.active, 20);
	}
	public void ability21_Lunge(CardPokemon active){
		
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
			if(i == 1){
				dam(active,20);	
			}else{
				System.out.println("Can't apply 20 damage");
			}
	}
	
	public void ability22_Slash(CardPokemon active){
		dam(active, 30);
	}
	
	public void ability23_NyanPress(CardPokemon active){
		dam(active, 40);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active, 40);
		}else{
			//applystat
			active.paralize(active);
		}
	}
	
	public void ability24_RandomSpark(CardPokemon opponent){
		dam(opponent, 30);
	}
	
	public void ability25_Bite(CardPokemon active){
		dam(active, 40);
	}
	
	public void ability26_Bite(CardPokemon active){
		dam(active, 10);
	}
	
	public void ability27_KnucklePunch(CardPokemon active){
		dam(active, 30);
	}
	
	public void ability28_Electroslug(CardPokemon active){
		dam(active, 90);
	}
	
	public void ability29_KnucklePunch(CardPokemon active){
		dam(active, 20);
	}
	
	public void ability30_DestructiveBeam(CardPokemon active){
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			deenergize(active, 1);
		}
	}
	
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
	
	//need to finish
	public void ability36_EarInfluence(){
		System.out.println("not developed yet");
	}
	
	public void ability37_Psychic(CardPokemon active){
		dam(active, 60);
		int count = active.m_energy;
		dam(active , count);
	}
	
	public void ability38_Hug(CardPokemon active){
		dam(active, 30);
		active.stuck(active);
	}
	
	public void ability39_Wish(Play p, GameEngine g){
		//search one card from deck(any type) = draw one card 
		p.drawOneCard(g);
	}
	
	public void ability40_HeartSign(CardPokemon active){
		dam(active, 50);
	}
	
	public void ability41_ActTough(Play p,CardPokemon active){
		dam(active, 10);
		int count = 0;
		for(int i =0; i < ((CardPokemon)p.active).m_energyCards.size(); i++){
			if( ((CardPokemon)p.active).m_energyCards.get(i).m_type == 2){
				count ++;
			}
		}
		if(count > 0){
			dam(active, 20);
		}
	}
	
	public void ability42_ExhaustedTackle(Play p, CardPokemon opponentActive){
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(opponentActive, 30);
		}else{
			dam((CardPokemon) p.active, 30);
		}
	}
	
	public void ability43_KnucklePunch(CardPokemon active){
		dam(active, 10);
	}
	
	public void ability44_DoubleStab(CardPokemon active){
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active, 10);
		}else{ System.out.println("can't apply damage 10");}
		//flip a coin
		int j = ThreadLocalRandom.current().nextInt(0,2);
		if(j == 1){
			dam(active, 10);
		}else{ System.out.println("can't apply damage 10");}
	}
	
	public void ability45_DoduoDelivery(Play p, GameEngine g){
		p.drawOneCard(g);
		p.drawOneCard(g);
	}
	
	public void ability46_FuryAttack(CardPokemon active){
		dam(active, 40);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active, 40);
		}else{ System.out.println("can't apply damage 40");}
		//flip a coin
		int j = ThreadLocalRandom.current().nextInt(0,2);
		if(j == 1){
			dam(active, 40);
		}else{ System.out.println("can't apply damage 40");}
		//flip a coin
		int k = ThreadLocalRandom.current().nextInt(0,2);
		if(k == 1){
			dam(active, 40);
		}else{ System.out.println("can't apply damage 40");}
		
	}
	
	public void ability47_Rollout(CardPokemon active){
		dam(active, 10);
	}
	
	//need to be developed
	public void ability48_Flail(){
		System.out.println("not developed yet");
	}
	
	public void ability49_SkillDive(CardPokemon active){
		dam(active, 10);
	}
	
	public void ability50_PoisonRing(CardPokemon active){
		active.stuck(active);
		active.poison(active);
	}
	
	public void ability51_SleepPoison(CardPokemon active){
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			active.fallasleep(active);
			active.poison(active);
		}else{System.out.println("can't apply sleep poison");}
	}
	
	//need to be developed
	public void ability52_Mine(){
		System.out.println("not developed yet");
	}
	
	public void ability53_MudSlap(CardPokemon active){
		dam(active, 20);
	}
	
	public void ability54_Earthquake(Play p, CardPokemon active){
		dam(active, 60);
		for(int i = 0; i < p.bench.length; i++){
			if(p.bench[i] != null){
				dam((CardPokemon) p.bench[i], 10);
			}
		}
	}
	
	public void ability55_RockTumble(CardPokemon active){
		dam(active, 60);
	}
	
	public void ability56_Scratch(CardPokemon active){
		dam(active, 10);
	}
	
	public void ability57_SpacingOut(Play p){
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			heal((CardPokemon) p.active, 10);
		}
	}
	
	//need to be developed
	public void ability58_Scavenge(){
		System.out.println("not developed yet");
	}
	
	public void ability59_StretchKick(CardPokemon bench){
		dam(bench, 30);
	}
	
	public void ability60_SpiralKick(CardPokemon active){
		dam(active, 30);
	}
	
	public void ability61_BulletPunch(CardPokemon active){
		dam(active, 20);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active, 20);
		}else{ System.out.println("can't apply damage 20");}
		//flip a coin
		int j = ThreadLocalRandom.current().nextInt(0,2);
		if(j == 1){
			dam(active, 20);
		}else{ System.out.println("can't apply damage 20");}
	}
	
	public void ability62_MachCross(CardPokemon active){
		dam(active, 60);
	}
	
	public void ability63_Beatdown(CardPokemon active){
		dam(active, 40);
	}
	
	public void ability64_Twinkle(CardPokemon active){
		active.fallasleep(active);
	}
	
	public void ability65_FakeOut(CardPokemon active){
		dam(active, 30);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			active.paralize(active);
		}
	}
	
	public void ability66_Ambush(CardPokemon active){
		dam(active, 40);
		//flip a coin
		int i = ThreadLocalRandom.current().nextInt(0,2);
		if(i == 1){
			dam(active,30);
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
