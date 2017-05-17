
package pokemon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Card extends JPanel {

	public Card(String name,int hitPoints,int attackPoints, int specialAttackPoints) {
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
		

		this.add(nameLabel);
		this.add(hpLabel);
		this.add(apLabel);
		this.add(sapLabel);
	}
	
}
