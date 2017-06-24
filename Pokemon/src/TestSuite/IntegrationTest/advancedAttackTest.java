package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.Play;

public class advancedAttackTest {
	
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		Play human = new Play();
		Play AI = new Play();
		AI.setDeck();
		human.active = g.deck1[4];
		AI.active = g.deck2[2];
		System.out.println(((CardPokemon)human.active).m_name);
		System.out.println("\tHP: " +((CardPokemon)human.active).m_hp);
		if(((CardPokemon)human.active).m_attacktype1 == 0){
			System.out.println("\tfirst attack: specific energy type: water");
			System.out.println("\tfirst attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype1cost);
		}
		if(((CardPokemon)human.active).m_attacktype1 == 1){
			System.out.println("\tfirst attack: specific energy type: lighting");
			System.out.println("\tfirst attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype1cost);
		}
		if(((CardPokemon)human.active).m_attacktype1 == 2){
			System.out.println("\tfirst attack: specific energy type: psychic");
			System.out.println("\tfirst attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype1cost);
		}
		if(((CardPokemon)human.active).m_attacktype1 == 3){
			System.out.println("\tfirst attack: specific energy type: fighting");
			System.out.println("\tfirst attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype1cost);
		}
		if(((CardPokemon)human.active).m_attacktype1 == -1){
			System.out.println("\tdon't need specific energy for first attack");
		}
		if(((CardPokemon)human.active).m_color1 != -1){
				System.out.println("\tfirst attack: colorless: "+((CardPokemon)human.active).m_color1);
				System.out.println("\tfirst attack: colorless cost: "+((CardPokemon)human.active).m_color1cost);
		}
		
		if(((CardPokemon)human.active).m_attacktype2 == 0){
			System.out.println("\tsecond attack: specific energy type: water");
			System.out.println("\tsecond attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype2cost);
		}
		if(((CardPokemon)human.active).m_attacktype2 == 1){
			System.out.println("\tsecond attack: specific energy type: lighting");
			System.out.println("\tsecond attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype2cost);
		}
		if(((CardPokemon)human.active).m_attacktype2 == 2){
			System.out.println("\tsecond attack: specific energy type: psychic");
			System.out.println("\tsecond attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype2cost);
		}
		if(((CardPokemon)human.active).m_attacktype2 == 3){
			System.out.println("\tsecond attack: specific energy type: fighting");
			System.out.println("\tsecond attack: specific energy type cost: "+((CardPokemon)human.active).m_attacktype2cost);
		}
		if(((CardPokemon)human.active).m_attacktype2 == -1){
			System.out.println("\tdon't need specific energy for second attack");
		}
		if(((CardPokemon)human.active).m_color2 != -1){
				System.out.println("\tsecond attack: colorless: "+((CardPokemon)human.active).m_color2);
				System.out.println("\tsecond attack: colorless cost: "+((CardPokemon)human.active).m_color2cost);
		}
		System.out.println("current gathered energy: "+((CardPokemon)human.active).m_collectEnergy);
		//((CardPokemon)human.active).m_energyCards
		
		System.out.println("adding fighting energy");
		CardEnergy m1 = new CardEnergy();
		m1.initEnergy(3);
		((CardPokemon)human.active).addEnergy(m1);
		((CardPokemon)human.active).addEnergy(m1);
		System.out.println("current gathered energy: "+((CardPokemon)human.active).m_collectEnergy);
		System.out.println("before attacking opponent HP: "+((CardPokemon) AI.active).m_hp);
		((CardPokemon)human.active).attackAdvance(human, g, (CardPokemon) AI.active);
		System.out.println("after attacking opponent HP: "+((CardPokemon) AI.active).m_hp);
		assertEquals(30,((CardPokemon) AI.active).m_hp);
	}
	
	
	
}
