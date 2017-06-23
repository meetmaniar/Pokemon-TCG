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

public class CardView extends JPanel implements MouseListener {
	public String Publicname;
	GameView gameView;
	JLabel nameLabel;
	
	JLabel typeLabel;
	JLabel hpLabel;
	JLabel apLabel;
	JLabel sapLabel;
	JLabel reLabel;
	JLabel sa2Label;
	JLabel cost1Label;
	JLabel cost2Label;
	JLabel color1Label;
	JLabel color2Label;
//	JLabel cocost1Label;
//	JLabel cocost2Label;
//	
	int index_hand = -1;
	int index_bench = -1;
	int index_active = -1;
	int IS_AI=0;
	String place="";
	public CardView(CardPokemon e, GameView ge, int index_hand, int index_bench, int index_active,int IS_AI,String place) {
		this.place=place;
		this.index_hand = index_hand;
		this.index_bench = index_bench;
		this.index_active = index_active;
		this.IS_AI=IS_AI;
		this.gameView = ge;
		String name = e.m_name;
		int hitPoints = e.m_hp;
		int type = e.m_pokemonType;
		//pokemon energy type
		int energy= e.m_energy;
		int attacktype1 =e.m_attacktype1;
		int attacktype2 = e.m_attacktype2;
		int attacktype1cost = e.m_attacktype1cost;
		int attacktype2cost = e.m_attacktype2cost;
		int color1 = e.m_color1;
		int color2 = e.m_color2;
		int color1cost = e.m_color1cost;
		int color2cost = e.m_color2cost;
		int retreatcost = e.m_retreatCost;
		
		this.setPreferredSize(new Dimension(63, 63));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(null);
		
		nameLabel = new JLabel(name);
		nameLabel.setBounds(5, 0, 700, 20);
		
		hpLabel = new JLabel("HP:" + String.valueOf(hitPoints));
		hpLabel.setBounds(5, 14, 700, 20);
		
		//display pokemon type
		switch(type){
		case 0:
			typeLabel = new JLabel("basic");
			typeLabel.setBounds(5, 28, 700, 20);
			break;
			
		case 1:
			typeLabel = new JLabel("stage-one");
			typeLabel.setBounds(5, 20, 700, 20);
		
		default:
			System.out.println("***no pokemo type");
		}
		
		
		//display pokemon energy type
		System.out.println("Energy type "+energy);
		switch (energy) {

		case 0:
			apLabel = new JLabel("Pokemon energy type: water");
			apLabel.setBounds(5, 84, 700, 20);
			break;

		case 1:
			apLabel = new JLabel("Pokemon energy type: lighting");
			apLabel.setBounds(5, 84, 700, 20);
			break;
		
		case 2:
			apLabel = new JLabel("Pokemon energy type: psychic");
			apLabel.setBounds(5, 84, 700, 20);
			break;
			
		case 3:
			apLabel = new JLabel("Pokemon energy type: fighting");
			apLabel.setBounds(5, 84, 700, 20);
			break;
			
		case 4:
			apLabel = new JLabel("Pokemon energy type: colorless");
			apLabel.setBounds(5, 84, 700, 20);
			break;
		
		default:
			System.out.println("***no pokemon energy type");

		}
//		apLabel = new JLabel("energy"+ String.valueOf(energy));
//		apLabel.setBounds(5, 29, 700, 20);
		
		//display retreat cost
		reLabel = new JLabel("Retreat: colorless  Cost:" + String.valueOf(retreatcost));
		reLabel.setBounds(5,98, 700, 20);
		
		//display first attatck type and cost
		switch (attacktype1) {

		case 0:
			sapLabel.setBounds(5, 45, 700, 20);
			break;

		case 1:
			sapLabel = new JLabel("first attack type: lighting");
			sapLabel.setBounds(5, 45, 700, 20);
			break;
		
		case 2:
			sapLabel = new JLabel("first attack type: psychic");
			sapLabel.setBounds(5, 45, 700, 20);
			break;
			
		case 3:
			sapLabel = new JLabel("first attack type: fighting");
			sapLabel.setBounds(5, 45, 700, 20);
			break;
			
		case 4:
			sapLabel = new JLabel("first attack type: colorless");
			sapLabel.setBounds(5, 45, 700, 20);
			break;
		
		default:
			sapLabel = new JLabel("first attack type: no specific type");
			sapLabel.setBounds(5, 45, 700, 20);

		}
		
		if(attacktype1cost != 0){
			cost1Label = new JLabel("first attack cost: "+String.valueOf(attacktype1cost));
			cost1Label.setBounds(5, 42, 700, 20);
		}else{
			cost1Label = new JLabel("first attack specific cost: "+String.valueOf(attacktype1cost));
			cost1Label.setBounds(5, 42, 700, 20);
		}
		
		if(color1 != -1){
			 color1Label = new JLabel("first attack colorless cost: "+String.valueOf(color1cost));
			 color1Label.setBounds(5, 60, 700, 20);
		}else{
			color1Label = new JLabel("no colorless cost for first attck");
			 color1Label.setBounds(5, 60, 700, 20);
		}
		
		//display second attack
		switch (attacktype2) {

		case 0:
			sa2Label = new JLabel("second attack type: water");
			sa2Label.setBounds(5, 70, 700, 20);
			break;

		case 1:
			sa2Label = new JLabel("second attack type: lighting");
			sapLabel.setBounds(5, 70, 700, 20);
			break;
		
		case 2:
			sa2Label = new JLabel("second attack type: psychic");
			sa2Label.setBounds(5, 70, 700, 20);
			break;
			
		case 3:
			sa2Label = new JLabel("second attack type: fighting");
			sa2Label.setBounds(5, 70, 700, 20);
			break;
			
		case 4:
			sa2Label = new JLabel("second attack type: colorless");
			sa2Label.setBounds(5, 70, 700, 20);
			break;
		
		default:
			sa2Label = new JLabel("second attack type: no specific type");
			sa2Label.setBounds(5, 70, 700, 20);


		}
		
		if(attacktype2cost != 0){
			cost2Label = new JLabel("second attack cost: "+String.valueOf(attacktype2cost));
			cost2Label.setBounds(5, 74, 700, 20);
		}else{
			cost2Label = new JLabel("second attack specific cost: "+String.valueOf(attacktype1cost));
			cost2Label.setBounds(5, 74, 700, 20);
		}
		
		if(color2 != -1){
			 color2Label = new JLabel("second attack colorless cost: "+String.valueOf(color2cost));
			 color2Label.setBounds(5, 90, 700, 20);
		}else{
			color2Label = new JLabel("no colorless cost for second attck");
			 color2Label.setBounds(5, 90, 700, 20);
		}
		
		
		
		
		this.add(nameLabel);
		//this.add(typeLabel);
		this.add(hpLabel);
		/*this.add(apLabel);
		//this.add(reLabel);
		this.add(sapLabel);*/
		this.addMouseListener(this);
		

	}

	public CardView(CardTrainer e, GameView ge, int index,String place) {
		this.place=place;
		index_hand = index;
		this.gameView = ge;
		int type = e.trainer_type;
		int heal_amount = 10;
		this.setPreferredSize(new Dimension(63, 63));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(null);

		JLabel typeLabel = new JLabel(e.name);
		typeLabel.setBounds(5, 0, 700, 20);
		
		nameLabel = new JLabel(e.name);
		nameLabel.setBounds(5, 0, 700, 20);
		
		switch(e.trainer_type){
		case 1:
			hpLabel = new JLabel("trainer type: supporter");
			hpLabel.setBounds(5, 14, 700, 20);
			break;
			
		case 2:
			hpLabel = new JLabel("trainer type: item");
			hpLabel.setBounds(5, 14, 700, 20);
			break;
			
		default:
			System.out.println("no trainer type");
		}
		
		this.add(typeLabel);
		this.add(hpLabel);
		this.addMouseListener(this);

	}

	public CardView(CardEnergy e, GameView ge, int index,String place) {
		this.place=place;
		index_hand = index;
		this.gameView = ge;
		int type = e.m_type;
		int energy_level = 10; // 10 because the energy amount for the damage is
								// same for each pokemon right now.
		this.setPreferredSize(new Dimension(63, 63));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(null);
		
		JLabel typeLabel = new JLabel(Integer.toString(type));
		typeLabel.setBounds(5, 0, 700, 20);
		switch(type){
			case 0:
				typeLabel = new JLabel("water");
				typeLabel.setBounds(5, 0, 700, 20);	
				break;
				
			case 1:
				typeLabel = new JLabel("lighting");
				typeLabel.setBounds(5, 0, 700, 20);	
				break;
			
			case 2:
				typeLabel = new JLabel("psychic");
				typeLabel.setBounds(5, 0, 700, 20);	
				break;
				
			case 3:
				typeLabel = new JLabel("fighting");
				typeLabel.setBounds(5, 0, 700, 20);	
				break;
			
			default:
				typeLabel=new JLabel("No energy type");
				typeLabel.setBounds(5, 0, 700, 20);
				System.out.println("no energy type");
		}
		
		hpLabel = new JLabel("Energy Amount:" + String.valueOf(energy_level));
		hpLabel.setBounds(5, 14, 700, 20);

		nameLabel = new JLabel("Energy Amount:" + String.valueOf(energy_level));
		nameLabel.setBounds(5, 0, 700, 20);

		this.add(typeLabel);
		this.add(hpLabel);
		this.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(GameView.HUMAN.active==null){
			CardView temp = (CardView) e.getSource();
			if(temp.place.equals("P")){
				GameView.HUMAN.placeActive(temp.index_hand);
				gameView.refreshUI();
			}
			
		}
		if(e.getClickCount()<2){
			
			CardView temp = (CardView) e.getSource();
			
			if(temp.place.equals("T"))
			{
				GameView.HUMAN.heal(temp.index_hand);	
			}
			
			if(temp.place.equals("E"))
			if(temp.IS_AI==0)
			{
				GameView.HUMAN.attachEnergyActive(temp.index_hand);	
				System.out.println("Energy for the Human AP"+((CardPokemon)GameView.HUMAN.active).m_energy);
				gameView.refreshUI();
				
				return;
			}
			else
			{
				GameView.AI.attachEnergyActive(temp.index_hand);	
				gameView.refreshUI();
				return;
			}
			
			
			try {
				if (GameView.HUMAN.hand[temp.index_hand].m_type != 0)
					return;
			} catch (Exception ed) {

			} 
			if (temp.index_bench > -1) {
				System.out.println("Moving to Active");
				GameView.HUMAN.placeBenchtoActive(temp.index_bench);
			} else {
				System.out.println("Moving to Bench");
				GameView.HUMAN.placeBench(temp.index_hand);
				temp.index_bench = GameView.AI.bench_top;
			}
			gameView.refreshUI();

			// System.out.println(((CardPokemon)GameView.HUMAN.active).m_name);
			// gameView.refreshUI();
		}
		if(e.getClickCount()==2){
			CardView temp = (CardView) e.getSource();
			GameView.HUMAN.placeBench(temp.index_hand);
			temp.index_bench = GameView.AI.bench_top;
			GameView.HUMAN.placeBenchtoActive(temp.index_bench);
			gameView.refreshUI();
		}
		System.out.println(index_hand);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		CardView temp = (CardView) e.getSource();
		if (gameView == null) {
			System.out.println("Null Gameview");
		}
		if (gameView.toolTip == null) {
			System.out.println("Null Tool");
		}
		if (nameLabel == null) {
			System.out.println("Null nameLabel");
		}
		try{
			
		if(temp.place.equals("P")){
			
				
				gameView.toolTip.add(nameLabel);
				gameView.toolTip.add(hpLabel);
				gameView.toolTip.add(typeLabel);
				
				
				gameView.toolTip.add(cost1Label);
				gameView.toolTip.add(cost2Label);
				gameView.toolTip.add(sa2Label);
				gameView.toolTip.add(apLabel);
		
				gameView.toolTip.add(color1Label);
				gameView.toolTip.add(sa2Label);
				gameView.toolTip.add(reLabel);
		}
		
		else {
			
				gameView.toolTip.add(nameLabel);
				gameView.toolTip.add(hpLabel);
				//gameView.toolTip.add(typeLabel);
			}
		
		
		
		gameView.toolTip.repaint();
		}
		catch(Exception ee)
		{
			
		}
		// gameView.toolTip.revalidate();

	}

	@Override
	public void mouseExited(MouseEvent e) {

		try{
			
		
		gameView.toolTip.removeAll();
		gameView.toolTip.repaint();
		this.add(nameLabel);
		this.add(hpLabel);
		}
		catch(Exception eead)
		{
		
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		
		
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		// TODO Auto-generated method stub
		// gameView.refreshUI();
	}

	
	
}