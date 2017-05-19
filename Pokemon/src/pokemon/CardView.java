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



public class CardView extends JPanel {
	public String Publicname; 
	public CardView(String name,int hitPoints,int attackPoints, int specialAttackPoints) {
		this.setPreferredSize(new Dimension(63, 63));
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.setLayout(null);

		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(5, 0, 700, 20);

		JLabel hpLabel=new JLabel("HP:" +String.valueOf(hitPoints));
		hpLabel.setBounds(5,14,700,20);

		JLabel apLabel=new JLabel("AP:" +String.valueOf(attackPoints));
		apLabel.setBounds(5,29,700,20);

		JLabel sapLabel=new JLabel("SAP:" +String.valueOf(specialAttackPoints));
		sapLabel.setBounds(0,44,700,20);
		
		MouseListener listener=new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				
				System.out.println("working");
				
				
				
			}
		};

		this.add(nameLabel);
		this.add(hpLabel);
		this.add(apLabel);
		this.add(sapLabel);
		this.addMouseListener(listener);
	
	}

}
