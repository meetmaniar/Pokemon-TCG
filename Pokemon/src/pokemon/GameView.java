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


public class GameView extends JFrame {

	
	public GameView() {
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
		
		CardView c11 = new CardView("AI-C-1",50,20,20);
		player1Panel.add(c11);
		
		CardView c21 = new CardView("AI-C-2",50,20,20);
		player1Panel.add(c21);
		
		CardView c31 = new CardView("AI-C-3",50,20,20);
		player1Panel.add(c31);
		
		CardView c41 = new CardView("AI-C-4",50,20,20);
		player1Panel.add(c41);
		
		CardView c51 = new CardView("AI-C-5",50,20,20);
		player1Panel.add(c51);

		CardView c61 = new CardView("AI-C-6",50,20,20);
		player1Panel.add(c61);
		
		CardView c71 = new CardView("AI-C-7",50,20,20);
		player1Panel.add(c71);
		
		CardView c81 = new CardView("AI-C-8",50,20,20);
		player1Panel.add(c81);
		
		CardView c91 = new CardView("AI-C-9",50,20,20);
		player1Panel.add(c91);
		
		CardView c101 = new CardView("AI-C-10",50,20,20);
		player1Panel.add(c101);
		
		CardView c111 = new CardView("AI-C-11",50,20,20);
		player1Panel.add(c111);
		
		CardView c121 = new CardView("AI-C-12",50,20,20);
		player1Panel.add(c121);
		
						
		
		// player 1 panel end ---
		
		//Player 1 bench CardViews start---
		
		JPanel bench1=new JPanel();
		bench1.setPreferredSize(new Dimension(400,100));
		bench1.setBorder(BorderFactory.createLineBorder(Color.black));
		bench1.setLayout(new FlowLayout());
		bench1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		bench1.setBounds(540, 0, 350, 75);
		bench1.setVisible(false);
		
		CardView B1 = new CardView("AIC-1",50,20,20);  //AIC: AI bench CardViews
		bench1.add(B1);
		
		CardView B2 = new CardView("AIC-2",50,20,20);
		bench1.add(B2);
		
		CardView B3 = new CardView("AIC-3",50,20,20);
		bench1.add(B3);
		
		CardView B4 = new CardView("AIC-4",50,20,20);
		bench1.add(B4);
		
		CardView B5 = new CardView("AIC-5",50,20,20);
		bench1.add(B5);
		//Player 1 bench CardViews end---
		
		subPanel.add(player1Panel, BorderLayout.PAGE_START);
		
		JPanel player2Panel = new JPanel();
		player2Panel.setPreferredSize(new Dimension(700, 76));
		player2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player2Panel.setLayout(new FlowLayout());
		player2Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		player2Panel.setVisible(false);
		// player 2 panel start ---- 
		
		CardView p1 = new CardView("pikacu",50,20,20);
		player2Panel.add(p1);
		
		CardView p2 = new CardView("abc",50,20,20);
		player2Panel.add(p2);
		
		CardView p3 = new CardView("pidsf",50,20,20);
		player2Panel.add(p3);
		
		CardView p4 = new CardView("pikacu",50,20,20);
		player2Panel.add(p4);
		
		CardView p5 = new CardView("abc",50,20,20);
		player2Panel.add(p5);
		
		CardView p6 = new CardView("pidsf",50,20,20);
		player2Panel.add(p6);
		
		CardView p7 = new CardView("pikacu",50,20,20);
		player2Panel.add(p7);
		
		CardView p8 = new CardView("abc",50,20,20);
		player2Panel.add(p8);
		
		CardView p9 = new CardView("pidsf",50,20,20);
		player2Panel.add(p9);
		
		CardView p10 = new CardView("pikacu",50,20,20);
		player2Panel.add(p10);
		
		CardView p11 = new CardView("abc",50,20,20);
		player2Panel.add(p11);
		
		CardView p12 = new CardView("pidsf",50,20,20);
		player2Panel.add(p12);
		// player 2 panel end ---
		
		//Player 2 bench CardViews start---
		
				JPanel bench2=new JPanel();
				bench2.setBorder(BorderFactory.createLineBorder(Color.black));
				bench2.setLayout(new FlowLayout());
				bench2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				bench2.setBounds(540, 443, 350, 75);
				bench2.setVisible(false);
				
				CardView B11 = new CardView("PC-1",50,20,20);  //PC: Player bench CardViews
				bench2.add(B11);
				
				CardView B12 = new CardView("PC-2",50,20,20);
				bench2.add(B12);
				
				CardView B13 = new CardView("PC-3",50,20,20);
				bench2.add(B13);
				
				CardView B14 = new CardView("PC-4",50,20,20);
				bench2.add(B14);
				
				CardView B15 = new CardView("PC-5",50,20,20);
				bench2.add(B15); 
				
				
		//Player 2 bench CardViews end---
		
		subPanel.add(player2Panel, BorderLayout.PAGE_END);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);
		
		//Panel for disCardViewpile--Player begin
		
			JPanel disCardViewP=new JPanel();
			disCardViewP.setBorder(BorderFactory.createLineBorder(Color.black));
			disCardViewP.setLayout(new CardLayout());
			disCardViewP.setBounds(3, 427, 90, 90);
			JLabel disCardViewPileP=new JLabel("DCP P", SwingConstants.CENTER);
			disCardViewPileP.setBorder(BorderFactory.createLineBorder(Color.black));
			disCardViewP.add(disCardViewPileP,BorderLayout.PAGE_START);
			disCardViewP.setVisible(false);
		//Panel for disCardViewpile--Player end
		
		//Panel for disCardViewpile--AI begin
			
			JPanel disCardViewA=new JPanel();
			disCardViewA.setBorder(BorderFactory.createLineBorder(Color.black));
			disCardViewA.setLayout(new CardLayout());
			disCardViewA.setBounds(1274, 1, 90, 90);
			JLabel disCardViewPileA=new JLabel("DCP AI", SwingConstants.CENTER);
			disCardViewPileA.setBorder(BorderFactory.createLineBorder(Color.black));
			disCardViewA.add(disCardViewPileA,BorderLayout.PAGE_START);
			disCardViewA.setVisible(false);
			
		//Panel for disCardViewpile-- end
			
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
		gamePanel.add(disCardViewP);
		gamePanel.add(disCardViewA);
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
		    disCardViewP.setVisible(true);
		    disCardViewA.setVisible(true);
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
		
		GameEngine ge = new GameEngine();
		ge.initGame();
		
		
	}

}