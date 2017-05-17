
package pokemon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class PriceCard extends JPanel {

	public PriceCard() {
		this.setLayout(new GridLayout(3 , 2));
		this.setPreferredSize(new Dimension(90, 90));
		
		for(int i=0;i<6;i++) {
			JPanel pc = new JPanel();
			pc.setBorder(BorderFactory.createLineBorder(Color.black));
			this.add(pc);
		}
	}
}
