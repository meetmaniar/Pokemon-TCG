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
	
	
	
	
	
}
