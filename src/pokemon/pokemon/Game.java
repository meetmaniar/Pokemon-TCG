package pokemon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.time.*;
import java.util.Timer;


public class Game extends JFrame {

	
	public Game() {
		this.setTitle("Pokemon");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JLabel player1Label = new JLabel("AI", SwingConstants.CENTER);
		player1Label.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(player1Label,BorderLayout.PAGE_START);
		
		JLabel player2Label = new JLabel("Player", SwingConstants.CENTER);
		player2Label.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(player2Label,BorderLayout.PAGE_END);
		
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BorderLayout());
		
		JPanel player1Panel = new JPanel();
		player1Panel.setPreferredSize(new Dimension(700, 76));
		player1Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player1Panel.setLayout(new FlowLayout());
		player1Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		player1Panel.setVisible(false);
		// player 1 panel start ---- 
		
		Card c11 = new Card("AI-C-1",50,20,20);
		player1Panel.add(c11);
		
		Card c21 = new Card("AI-C-2",50,20,20);
		player1Panel.add(c21);
		
		Card c31 = new Card("AI-C-3",50,20,20);
		player1Panel.add(c31);
		
		Card c41 = new Card("AI-C-4",50,20,20);
		player1Panel.add(c41);
		
		Card c51 = new Card("AI-C-5",50,20,20);
		player1Panel.add(c51);

		Card c61 = new Card("AI-C-6",50,20,20);
		player1Panel.add(c61);
		
		Card c71 = new Card("AI-C-7",50,20,20);
		player1Panel.add(c71);
		
		Card c81 = new Card("AI-C-8",50,20,20);
		player1Panel.add(c81);
		
		Card c91 = new Card("AI-C-9",50,20,20);
		player1Panel.add(c91);
		
		Card c101 = new Card("AI-C-10",50,20,20);
		player1Panel.add(c101);
		
		Card c111 = new Card("AI-C-11",50,20,20);
		player1Panel.add(c111);
		
		Card c121 = new Card("AI-C-12",50,20,20);
		player1Panel.add(c121);
		
						
		
		// player 1 panel end ---
		
		//Player 1 bench cards start---
		
		JPanel bench1=new JPanel();
		bench1.setPreferredSize(new Dimension(400,100));
		bench1.setBorder(BorderFactory.createLineBorder(Color.black));
		bench1.setLayout(new FlowLayout());
		bench1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		bench1.setBounds(540, 0, 350, 75);
		bench1.setVisible(false);
		
		Card B1 = new Card("AIC-1",50,20,20);  //AIC: AI bench cards
		bench1.add(B1);
		
		Card B2 = new Card("AIC-2",50,20,20);
		bench1.add(B2);
		
		Card B3 = new Card("AIC-3",50,20,20);
		bench1.add(B3);
		
		Card B4 = new Card("AIC-4",50,20,20);
		bench1.add(B4);
		
		Card B5 = new Card("AIC-5",50,20,20);
		bench1.add(B5);
		//Player 1 bench cards end---
		
		subPanel.add(player1Panel, BorderLayout.PAGE_START);
		
		JPanel player2Panel = new JPanel();
		player2Panel.setPreferredSize(new Dimension(700, 76));
		player2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player2Panel.setLayout(new FlowLayout());
		player2Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		player2Panel.setVisible(false);
		// player 2 panel start ---- 
		
		Card p1 = new Card("pikacu",50,20,20);
		player2Panel.add(p1);
		
		Card p2 = new Card("abc",50,20,20);
		player2Panel.add(p2);
		
		Card p3 = new Card("pidsf",50,20,20);
		player2Panel.add(p3);
		
		Card p4 = new Card("pikacu",50,20,20);
		player2Panel.add(p4);
		
		Card p5 = new Card("abc",50,20,20);
		player2Panel.add(p5);
		
		Card p6 = new Card("pidsf",50,20,20);
		player2Panel.add(p6);
		
		Card p7 = new Card("pikacu",50,20,20);
		player2Panel.add(p7);
		
		Card p8 = new Card("abc",50,20,20);
		player2Panel.add(p8);
		
		Card p9 = new Card("pidsf",50,20,20);
		player2Panel.add(p9);
		
		Card p10 = new Card("pikacu",50,20,20);
		player2Panel.add(p10);
		
		Card p11 = new Card("abc",50,20,20);
		player2Panel.add(p11);
		
		Card p12 = new Card("pidsf",50,20,20);
		player2Panel.add(p12);
		// player 2 panel end ---
		
		//Player 2 bench cards start---
		
				JPanel bench2=new JPanel();
				bench2.setBorder(BorderFactory.createLineBorder(Color.black));
				bench2.setLayout(new FlowLayout());
				bench2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				bench2.setBounds(540, 443, 350, 75);
				bench2.setVisible(false);
				
				Card B11 = new Card("PC-1",50,20,20);  //PC: Player bench cards
				bench2.add(B11);
				
				Card B12 = new Card("PC-2",50,20,20);
				bench2.add(B12);
				
				Card B13 = new Card("PC-3",50,20,20);
				bench2.add(B13);
				
				Card B14 = new Card("PC-4",50,20,20);
				bench2.add(B14);
				
				Card B15 = new Card("PC-5",50,20,20);
				bench2.add(B15); 
				
				
		//Player 2 bench cards end---
		
		subPanel.add(player2Panel, BorderLayout.PAGE_END);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);
		
		//Panel for discardpile--Player begin
		
			JPanel discardP=new JPanel();
			discardP.setBorder(BorderFactory.createLineBorder(Color.black));
			discardP.setLayout(new CardLayout());
			discardP.setBounds(3, 427, 90, 90);
			JLabel discardPileP=new JLabel("DCP P", SwingConstants.CENTER);
			discardPileP.setBorder(BorderFactory.createLineBorder(Color.black));
			discardP.add(discardPileP,BorderLayout.PAGE_START);
			discardP.setVisible(false);
		//Panel for discardpile--Player end
		
		//Panel for discardpile--AI begin
			
			JPanel discardA=new JPanel();
			discardA.setBorder(BorderFactory.createLineBorder(Color.black));
			discardA.setLayout(new CardLayout());
			discardA.setBounds(1274, 1, 90, 90);
			JLabel discardPileA=new JLabel("DCP AI", SwingConstants.CENTER);
			discardPileA.setBorder(BorderFactory.createLineBorder(Color.black));
			discardA.add(discardPileA,BorderLayout.PAGE_START);
			discardA.setVisible(false);
			
		//Panel for discardpile-- end
			
		//Button for passing the turn--begin
			
			JButton done=new JButton("DONE");
			done.setPreferredSize(new Dimension(90,90));
			done.setBounds(950, 250, 70, 35);
			done.setVisible(false);
			//done.setBackground(Color.red);
		//Button for passing the turn--end	
			
		//Randomly assigning the turn to the players--start
			
			
			long compareTime=5;
			long timePassed=System.currentTimeMillis()-compareTime;
			long seconds=timePassed/1000;
			Boolean flag=false;
			String turn;
			if(seconds%2==0)
			{
				 turn="Player's turn"; 
				//flag=true;
			}
			else
			{
				turn="AI's turn";
				//flag=false;
			}
			
			JPanel turnPanel=new JPanel();
			turnPanel.setPreferredSize(new Dimension(90,90));
			turnPanel.setLayout(new BorderLayout());
			//turnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel turnLabel = new JLabel(turn,SwingConstants.CENTER);
			turnLabel.setFont(new Font("Serif",Font.BOLD,74));
			turnPanel.add(turnLabel, BorderLayout.CENTER);	
			turnPanel.setBounds(100, 200, 1200, 100);
			//Timer timer = new Timer();
			//timer.schedule(turnPanel.setVisible(true), 1000);
			
			
			
			
		//Randomly assigning the turn to the players--end
		// game panel start ----
		
		PriceCard leftTop = new PriceCard();
		leftTop.setBounds(10, 10, 82, 123);
		gamePanel.add(leftTop);
		leftTop.setVisible(false);
		
		PriceCard rightBottom = new PriceCard();
		rightBottom.setBounds(1274, 390, 82, 123);
		gamePanel.add(rightBottom);
		rightBottom.setVisible(false);
		JPanel deck1 = new JPanel(); 
		deck1.setPreferredSize(new Dimension(90,90));
		deck1.setLayout(new BorderLayout());
		deck1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deck1Label = new JLabel("DECK1");
		deck1.add(deck1Label, BorderLayout.CENTER);
		deck1.setBounds(10, 145, 80, 80);
		deck1.setVisible(false);
		gamePanel.add(deck1);
		
		JPanel deck2 = new JPanel(); 
		deck2.setLayout(new BorderLayout());
		deck2.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deck2Label = new JLabel("DECK2");
		deck2.add(deck2Label, BorderLayout.CENTER);
		deck2.setBounds(1274, 300, 80, 80);
		deck2.setVisible(false);
		gamePanel.add(deck2);
		
		gamePanel.add(bench1);
		gamePanel.add(bench2);
		gamePanel.add(discardP);
		gamePanel.add(discardA);
		gamePanel.add(done);
		gamePanel.add(turnPanel);
		
		// center image start --
		
		
		ImageIcon background = new ImageIcon("image/Pokeball.png");
		JLabel label=new JLabel();
		label.setIcon(background);
		gamePanel.setLayout(null);
		label.setBounds(570,104,310,310);
		label.setVisible(false);
		gamePanel.add(label);

		// center image end --		
		// game panel end ----
		JButton okay=new JButton("OKAY");
		okay.setPreferredSize(new Dimension(90,90));
		okay.setBounds(665, 350, 70, 35);
		okay.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    turnPanel.setVisible(false);
		    okay.setVisible(false);
		    player1Panel.setVisible(true);
		    player2Panel.setVisible(true);
		    gamePanel.setVisible(true);
		    bench1.setVisible(true);
		    bench2.setVisible(true);
		    rightBottom.setVisible(true);
		    leftTop.setVisible(true);
		    deck1.setVisible(true);
		    deck2.setVisible(true);
		    bench1.setVisible(true);
		    bench2.setVisible(true);
		    done.setVisible(true);
		    label.setVisible(true);
		    discardP.setVisible(true);
		    discardA.setVisible(true);
		  }
		});
		mainPanel.add(okay);
		subPanel.add(gamePanel, BorderLayout.CENTER);
		
		mainPanel.add(subPanel,BorderLayout.CENTER);
		
		Container contentPane = getContentPane();
		
		contentPane.add(mainPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setMinimumSize(new Dimension(600, 710));
		this.setResizable(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setVisible(true);
	}

}