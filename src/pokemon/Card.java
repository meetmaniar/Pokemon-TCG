package pokemon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Card extends JPanel {

	public Card(String name) {
		this.setPreferredSize(new Dimension(90, 90));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setLayout(null);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(3, 2, 700, 20);
		
		this.add(nameLabel);
	}
	
}
