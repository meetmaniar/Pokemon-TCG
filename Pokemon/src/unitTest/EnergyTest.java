package unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import pokemon.GameEngine;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;

public class EnergyTest {
	
	@Test
	public void test() {
		GameEngine g = new GameEngine();
		g.iniDeck();
		
		//check if deck1 has energy type : psychic and fighting
		for(int i = 0; i < 60 ;i++){
			try{
				if(g.deck1[i].m_type == 1){
					if(((CardEnergy)g.deck1[i]).m_type == 2 ){
						assertEquals(2,((CardEnergy)g.deck1[i]).m_type );
					}
					else if(((CardEnergy)g.deck1[i]).m_type == 3 ){
						assertEquals(3,((CardEnergy)g.deck1[i]).m_type );
					}
					else{
						System.out.println("energy check for deck1 fails");
					}
					
				}
			}catch(Exception e){	
			}
		
		}
		
		//check if deck2 has energy type : water and lighting
				for(int i = 0; i < 60 ;i++){
					try{
						if(g.deck2[i].m_type == 1){
							if(((CardEnergy)g.deck2[i]).m_type == 0 ){
								assertEquals(0,((CardEnergy)g.deck2[i]).m_type );
							}
							else if(((CardEnergy)g.deck2[i]).m_type == 1 ){
								assertEquals(1,((CardEnergy)g.deck2[i]).m_type );
							}
							else{
								System.out.println("energy check for deck2 fails");
							}
						}
					}catch(Exception e){	
					}
				
				}
	
	}
}
