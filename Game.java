
package pokemon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Game extends JFrame {

	
	public Game() throws IOException {
		this.setTitle("Pokemon");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JLabel player1Label = new JLabel("Player 1", SwingConstants.CENTER);
		player1Label.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(player1Label,BorderLayout.PAGE_START);
		
		JLabel player2Label = new JLabel("Player 2", SwingConstants.CENTER);
		player2Label.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(player2Label,BorderLayout.PAGE_END);
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BorderLayout());
		
		JPanel player1Panel = new JPanel();
		player1Panel.setPreferredSize(new Dimension(700, 100));
		player1Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player1Panel.setLayout(new FlowLayout());
		player1Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		// player 1 panel start ---- 
		
		Card c11 = new Card("pikacu");
		player1Panel.add(c11);
		
		Card c21 = new Card("abc");
		player1Panel.add(c21);
		
		Card c31 = new Card("pidsf");
		player1Panel.add(c31);
		
		
		
		// player 1 panel end ---
		
		subPanel.add(player1Panel, BorderLayout.PAGE_START);
		
		JPanel player2Panel = new JPanel();
		player2Panel.setPreferredSize(new Dimension(700, 100));
		player2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player2Panel.setLayout(new FlowLayout());
		player2Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		// player 2 panel start ---- 
		
		Card c1 = new Card("pikacu");
		player2Panel.add(c1);
		
		Card c2 = new Card("abc");
		player2Panel.add(c2);
		
		Card c3 = new Card("pidsf");
		player2Panel.add(c3);
		// player 2 panel end ---
		
		subPanel.add(player2Panel, BorderLayout.PAGE_END);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);
		
		// game panel start ----
		
		PriceCard leftTop = new PriceCard();
		leftTop.setBounds(10, 10, 82, 123);
		gamePanel.add(leftTop);
		
		PriceCard rightBottom = new PriceCard();
		rightBottom.setBounds(610, 310, 82, 123);
		gamePanel.add(rightBottom);
		
		JPanel deck1 = new JPanel(); 
		deck1.setLayout(new BorderLayout());
		deck1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deck1Label = new JLabel("DECK");
		deck1.add(deck1Label, BorderLayout.CENTER);
		deck1.setBounds(10, 390, 40, 40);
		
		gamePanel.add(deck1);
		
		JPanel deck2 = new JPanel(); 
		deck2.setLayout(new BorderLayout());
		deck2.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deck2Label = new JLabel("DECK");
		deck2.add(deck2Label, BorderLayout.CENTER);
		deck2.setBounds(650, 10, 40, 40);
		
		gamePanel.add(deck2);
		
		// center image start --
		
		BufferedImage myPicture = ImageIO.read(new File("C:/Users/m_aniaR/Downloads/dataset-original.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
		
		// center image end --		
		// game panel end ----
		
		subPanel.add(gamePanel, BorderLayout.CENTER);
		
		mainPanel.add(subPanel,BorderLayout.CENTER);
		
		Container contentPane = getContentPane();
		
		contentPane.add(mainPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setMinimumSize(new Dimension(600, 710));
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
