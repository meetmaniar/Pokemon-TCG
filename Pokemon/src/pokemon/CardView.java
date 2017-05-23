package pokemon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardEnergy;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;

//String name,int hitPoints,int attackPoints, int specialAttackPoints

public class CardView extends JPanel 
{
	public String Publicname; 
	public CardView(CardPokemon e) {
		
		String name=e.m_name;
		int hitPoints=e.m_hp;
		this.setPreferredSize(new Dimension(63, 63));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(null);

		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(5, 0, 700, 20);

		JLabel hpLabel=new JLabel("HP:" +String.valueOf(hitPoints));
		hpLabel.setBounds(5,14,700,20);
		
		

		this.add(nameLabel);
		this.add(hpLabel);
		//this.addMouseListener(listener);
	
	}

public CardView(CardTrainer e) {
		
		int type=e.trainer_type;
		int heal_amount=10;
		this.setPreferredSize(new Dimension(63, 63));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(null);

		JLabel typeLabel = new JLabel(Integer.toString(type));
		typeLabel.setBounds(5, 0, 700, 20);

		JLabel hpLabel=new JLabel("Heal Amount:" +String.valueOf(heal_amount));
		hpLabel.setBounds(5,14,700,20);

		
		this.add(typeLabel);
		this.add(hpLabel);
		//this.addMouseListener(listener);
	
	}
	
public CardView(CardEnergy e) {
	
	int type=e.m_type;
	int energy_level=10; // 10 because the energy amount for the damage is same for each pokemon right now.
	this.setPreferredSize(new Dimension(63, 63));
	this.setBorder(BorderFactory.createLineBorder(Color.black));

	this.setLayout(null);

	JLabel typeLabel = new JLabel(Integer.toString(type));
	typeLabel.setBounds(5, 0, 700, 20);

	JLabel hpLabel=new JLabel("Energy Amount:" +String.valueOf(energy_level));
	hpLabel.setBounds(5,14,700,20);

	
	MouseListener listener=new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
			
			System.out.println("working");
			
			
			
		}
	};

	this.add(typeLabel);
	this.add(hpLabel);
	//this.addMouseListener(listener);

}

	
	
}
