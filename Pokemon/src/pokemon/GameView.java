package pokemon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import pokemon.CoreClasses.Card;
import pokemon.CoreClasses.CardPokemon;
import pokemon.CoreClasses.CardTrainer;
import pokemon.CoreClasses.Play;
import pokemon.CoreClasses.CardEnergy;

//
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameView extends JFrame {

	public JPanel toolTip;

	JPanel player1Panel;
	JPanel player2Panel;
	JPanel bench2;
	JPanel bench1;
	JPanel deck1, deck2;
	JPanel active2,active1;
	JButton attack = null;
	JButton attack2=null;
	JButton done = null;
	int AI_deck_size=60-AI.deck_top;
	int HUMAN_deck_size=60-HUMAN.deck_top;

	public GameView() {
		this.setTitle("Pokemon");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JLabel player1Label = new JLabel("AI", SwingConstants.CENTER);
		player1Label.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(player1Label, BorderLayout.PAGE_START);

		JLabel player2Label = new JLabel("Player", SwingConstants.CENTER);
		player2Label.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(player2Label, BorderLayout.PAGE_END);

		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BorderLayout());
		
		
		
		JButton priceCard=new JButton("PriceCard");
		priceCard.setPreferredSize(new Dimension(90, 90));
		priceCard.setBounds(100, 400, 70, 35);
		priceCard.setVisible(false);
		priceCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameView.HUMAN.pickPrize();
				HUMAN.checkEnd(AI);
				refreshUI();
				
				}

		});

		player1Panel = new JPanel();
		player1Panel.setPreferredSize(new Dimension(700, 76));
		player1Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player1Panel.setLayout(new FlowLayout());
		player1Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		player1Panel.setVisible(false);
		
		
		
		// player 1 panel start ----

		CardView hand_ai[] = new CardView[15];
		System.out.println("Shuffling Over Complete");
		for (int i = 0; i < 15; i++) {
			try {
				// System.out.println(HUMAN.hand[i].m_type + " M_TYPE" );

				if (AI.hand[i].m_type == 0) {
					hand_ai[i] = new CardView((CardPokemon) AI.hand[i], this, i, -1, -1,1,"P");
				}
				if (AI.hand[i].m_type == 1)
					hand_ai[i] = new CardView((CardEnergy) AI.hand[i], this, i,"E");
				if (AI.hand[i].m_type == 2)
					hand_ai[i] = new CardView((CardTrainer) AI.hand[i], this, i,"T");
			} catch (Exception e) {

			}

		}

		for (int i = 0; i < 15; i++) {
			try {
				player1Panel.add(hand_ai[i]);
			} catch (Exception e) {
				System.out.println(i);

			}

		}

		// player 1 panel end ---

		// Player 1 bench cards start---

		bench1 = new JPanel();
		bench1.setPreferredSize(new Dimension(400, 100));
		bench1.setBorder(BorderFactory.createLineBorder(Color.black));
		bench1.setLayout(new FlowLayout());
		bench1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		bench1.setBounds(540, 0, 350, 75);
		bench1.setVisible(false);

		
		active1 = new JPanel();
		active1.setBorder(BorderFactory.createLineBorder(Color.black));
		active1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		active1.setBounds(680, 128, 75, 75);
		active1.setVisible(false);
		
		
		CardView bench_ai[] = new CardView[5];
		for (int i = 0; i < 15; i++) {
			try {
				if (AI.bench[i].m_type == 0) {

					bench_ai[i] = new CardView((CardPokemon) AI.bench[i], this, i, -1, -1,1,"P");
				}

			} catch (Exception e) {

			}
		}

		for (int i = 0; i < 5; i++) {
			try {
				bench1.add(bench_ai[i]);
			} catch (Exception e) {

			}
		}
		// Player 1 bench cards end---

		subPanel.add(player1Panel, BorderLayout.PAGE_START);

		// Dynamic Back-end Connectivity

		player2Panel = new JPanel();
		player2Panel.setPreferredSize(new Dimension(700, 76));
		player2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		player2Panel.setLayout(new FlowLayout());
		player2Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		player2Panel.setVisible(false);

		// player 2 panel start ----

		CardView hand_player[] = new CardView[15];
		System.out.println("Shuffling Over Complete");
		for (int i = 0; i < 15; i++) {
			try {
				// System.out.println(HUMAN.hand[i].m_type + " M_TYPE" );
				if (HUMAN.hand[i] == null) {

				}
				if (HUMAN.hand[i].m_type == 0) {
					hand_player[i] = new CardView((CardPokemon) HUMAN.hand[i], this, i, -1, -1,0,"P");
				}
				if (HUMAN.hand[i].m_type == 1)
					hand_player[i] = new CardView((CardEnergy) HUMAN.hand[i], this, i,"E");

				if (HUMAN.hand[i].m_type == 2)
					hand_player[i] = new CardView((CardTrainer) HUMAN.hand[i], this, i,"T");
			} catch (Exception e) {

			}

		}

		for (int i = 0; i < 15; i++) {
			try {
				player2Panel.add(hand_player[i]);
			} catch (Exception e) {

			}

		}

		// Player 2 bench cards start---

		bench2 = new JPanel();
		bench2.setBorder(BorderFactory.createLineBorder(Color.black));
		bench2.setLayout(new FlowLayout());
		bench2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		bench2.setBounds(540, 528, 350, 75);
		bench2.setVisible(false);

		active2 = new JPanel();
		active2.setBorder(BorderFactory.createLineBorder(Color.black));
		active2.setLayout(new FlowLayout());
		active2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		active2.setBounds(680, 428, 75, 75);
		active2.setVisible(false);

		CardView bench_player[] = new CardView[5];
		for (int i = 0; i < 15; i++) {
			try {
				if (HUMAN.bench[i].m_type == 0) {

					bench_player[i] = new CardView((CardPokemon) HUMAN.bench[i], this, i, -1, -1,0,"P");
				}

			} catch (Exception e) {

			}
		}

		for (int i = 0; i < 5; i++) {
			try {
				bench2.add(bench_player[i]);
			} catch (Exception e) {

			}
		}

		

		subPanel.add(player2Panel, BorderLayout.PAGE_END);

		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(null);

		// Panel for discardpile--Player begin

		JPanel discardP = new JPanel();
		discardP.setBorder(BorderFactory.createLineBorder(Color.black));
		discardP.setLayout(new CardLayout());
		discardP.setBounds(3, 427, 90, 90);
		JLabel discardPileP = new JLabel("DCP P", SwingConstants.CENTER);
		discardPileP.setBorder(BorderFactory.createLineBorder(Color.black));
		discardP.add(discardPileP, BorderLayout.PAGE_START);
		discardP.setVisible(false);
		// Panel for discardpile--Player end

		// Panel for discardpile--AI begin

		JPanel discardA = new JPanel();
		discardA.setBorder(BorderFactory.createLineBorder(Color.black));
		discardA.setLayout(new CardLayout());
		discardA.setBounds(1274, 1, 90, 90);
		JLabel discardPileA = new JLabel("DCP AI", SwingConstants.CENTER);
		discardPileA.setBorder(BorderFactory.createLineBorder(Color.black));
		discardA.add(discardPileA, BorderLayout.PAGE_START);
		discardA.setVisible(false);

		// Panel for discardpile-- end

		// Button for passing the turn--begin

		done = new JButton("DONE");
		done.setPreferredSize(new Dimension(90, 90));
		done.setBounds(950, 250, 70, 35);
		done.setVisible(false);
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameEngine.ge.turnCounter++;
				GameView.AI.drawOneCard(ge);
				AI.nextMove();
				refreshUI();refreshUI();refreshUI();refreshUI();refreshUI();refreshUI();
				//GameView.AI.attack();
				attack.setVisible(true);
				attack2.setVisible(true);
			}

		});

		JButton refresh = new JButton("Refresh");
		refresh.setPreferredSize(new Dimension(90, 90));
		refresh.setBounds(1150, 250, 70, 35);
		refresh.setVisible(false);
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				refreshUI();
			}

		});
		
		JButton draw = new JButton("Draw");
		draw.setPreferredSize(new Dimension(90, 90));
		draw.setBounds(1350, 250, 70, 35);
		draw.setVisible(false);
		draw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameView.HUMAN.drawOneCard(ge);
				refreshUI();
				System.out.println("+++++++++++++++++++++++++++++++++++++++" + AI_deck_size+HUMAN_deck_size);
			}

		});
		JButton attack2=new JButton("Atk-2");
		attack2.setPreferredSize(new Dimension(90, 90));
		attack2.setBounds(100, 100, 70, 35);
		attack2.setVisible(false);
		attack2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((CardPokemon)GameView.HUMAN.active).attackAdvance(HUMAN, ge, (CardPokemon) AI.active);
				refreshUI();
			}

		});
		
		attack = new JButton("Atk-1");
		attack.setPreferredSize(new Dimension(90, 90));
		attack.setBounds(1050, 450, 70, 35);
		attack.setVisible(false);
		attack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((CardPokemon)GameView.HUMAN.active).attackBasic(HUMAN, ge, (CardPokemon) AI.active);
				//System.out.println("======================hp "+((CardPokemon)GameView.HUMAN.active).m_hp);
				done.setVisible(true);
				attack.setVisible(false);
				refreshUI();
				
			}

		});
		
		
		// done.setBackground(Color.red);
		// Button for passing the turn--end
		
		JButton shuffle = new JButton("Shuffle");
		shuffle.setPreferredSize(new Dimension(110, 110));
		shuffle.setBounds(950, 300, 70, 35);
		shuffle.setVisible(false);
		shuffle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				GameEngine.doShuffle(GameEngine.deck1);
	//			GameEngine.doShuffle(GameEngine.deck2);
			}

		});


		// Randomly assigning the turn to the players--start

		long compareTime = 5;
		long timePassed = System.currentTimeMillis() - compareTime;
		long seconds = timePassed / 1000;

		String turn = "";
		if (seconds%2==0) {
			turn = "Player's turn";
			// flag=true;
		} 
		else {
			turn = "AI's turn";
//			// flag=false;
		}

		JPanel turnPanel = new JPanel();
		turnPanel.setPreferredSize(new Dimension(90, 90));
		turnPanel.setLayout(new BorderLayout());
		// turnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel turnLabel = new JLabel(turn, SwingConstants.CENTER);
		turnLabel.setFont(new Font("Serif", Font.BOLD, 74));
		turnPanel.add(turnLabel, BorderLayout.CENTER);
		turnPanel.setBounds(100, 200, 1200, 100);
		// Timer timer = new Timer();
		// timer.schedule(turnPanel.setVisible(true), 1000);

		// Randomly assigning the turn to the players--end
		// game panel start ----

		PriceCard leftTop = new PriceCard();
		leftTop.setBounds(10, 10, 82, 123);
		gamePanel.add(leftTop);
		leftTop.setVisible(false);
		GameView.AI.drawPrizeCards(ge);
		GameView.HUMAN.drawPrizeCards(ge);

		PriceCard rightBottom = new PriceCard();
		rightBottom.setBounds(1274, 390, 82, 123);
		gamePanel.add(rightBottom);
		rightBottom.setVisible(false);
		deck1 = new JPanel();
		deck1.setPreferredSize(new Dimension(90, 90));
		deck1.setLayout(new BorderLayout());
		deck1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deck1Label = new JLabel("DECK:" + HUMAN_deck_size);
		deck1.add(deck1Label, BorderLayout.CENTER);
		deck1.setBounds(10, 145, 80, 80);
		deck1.setVisible(false);
		gamePanel.add(deck1);

		deck2 = new JPanel();
		deck2.setLayout(new BorderLayout());
		deck2.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deck2Label = new JLabel("DECK:" + AI_deck_size);
		deck2.add(deck2Label, BorderLayout.CENTER);
		deck2.setBounds(1274, 300, 80, 80);
		deck2.setVisible(false);
		gamePanel.add(deck2);

		gamePanel.add(bench1);
		gamePanel.add(bench2);
		gamePanel.add(active2);
		gamePanel.add(active1);
		gamePanel.add(discardP);
		gamePanel.add(discardA);
		gamePanel.add(done);
		gamePanel.add(refresh);
		gamePanel.add(draw);
		gamePanel.add(attack);
		gamePanel.add(turnPanel);
		gamePanel.add(shuffle);
		gamePanel.add(priceCard);
		gamePanel.add(attack2);
		// center image start --

		ImageIcon background = new ImageIcon("image/Pokeball.png");
		JLabel label = new JLabel();
		label.setIcon(background);
		gamePanel.setLayout(null);
		label.setBounds(570, 104, 310, 310);
		label.setVisible(false);
		//gamePanel.add(label);

		// toolTip begin---
		toolTip = new JPanel();
		toolTip.setPreferredSize(new Dimension(700, 76));
		toolTip.setBorder(BorderFactory.createLineBorder(Color.black));
		toolTip.setLayout(new FlowLayout());
		toolTip.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolTip.setVisible(false);
		toolTip.setBounds(300, 100, 200, 400);

		
		gamePanel.add(toolTip);
		// toolTip end---

		// center image end --
		// game panel end ----
		JButton okay = new JButton("OKAY");
		okay.setPreferredSize(new Dimension(90, 90));
		okay.setBounds(665, 350, 70, 35);
		okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turnPanel.setVisible(false);
				okay.setVisible(false);
				player1Panel.setVisible(true);
				player2Panel.setVisible(true);
				gamePanel.setVisible(true);
				bench1.setVisible(true);
				bench2.setVisible(true);
				rightBottom.setVisible(false);
				leftTop.setVisible(false);
				deck1.setVisible(true);
				deck2.setVisible(true);
				priceCard.setVisible(true);
				active2.setVisible(true);
				active1.setVisible(true);
				bench1.setVisible(true);
				bench2.setVisible(true);
				done.setVisible(true);
				refresh.setVisible(true);
				draw.setVisible(true);
				attack.setVisible(true);
				label.setVisible(true);
				discardP.setVisible(false);
				discardA.setVisible(false);
				toolTip.setVisible(true);
				shuffle.setVisible(true);
				attack2.setVisible(true);
 
				// remove the cards on bench start--
				ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

				Runnable taskRun = new Runnable() {
					int secondsToWait = 2;

					public void run() {
						secondsToWait--;
						System.out.println("Ticks");
						if (secondsToWait == 0) {
							// System.out.println("Ticks Com");
							// B11.setVisible(false);
							// B12.setVisible(false);
							// B13.setVisible(false);
							// B14.setVisible(false);
							// B15.setVisible(false);
							exec.shutdown();

						}
					}
				};

				exec.scheduleAtFixedRate(taskRun, 1, 1, TimeUnit.SECONDS);
				// remove the cards on bench end--

				// //--add JTextArea--start
				// for(int i = 0; i < 5; i++) {
				// JTextArea area = new JTextArea();
				//
				// bench2.setLayout(new GridLayout(1, 1));
				// bench2.add(area);
				// }
				//
				// //--add JTextArea--end

			}
		});

		mainPanel.add(okay);
		subPanel.add(gamePanel, BorderLayout.CENTER);
		mainPanel.add(subPanel, BorderLayout.CENTER);
		Container contentPane = getContentPane();
		contentPane.add(mainPanel);
		/*
		 * int t=100; ActionListener taskPerformer=new ActionListener(){
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { // TODO
		 * Auto-generated method stub gamePanel.repaint(); }
		 * 
		 * }; Timer timer=new Timer(t,taskPerformer);
		 */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(600, 710));
		this.setResizable(true);
		this.pack();
		this.setLocationRelativeTo(null);
		// addMouseListener(new MouseListener())

	}

	public void refreshUI() 
	{
		player2Panel.removeAll();
		player1Panel.removeAll();
		bench1.removeAll();
		bench2.removeAll();
		/*deck1.removeAll();
		deck2.removeAll();*/
		active1.removeAll();
		active2.removeAll();
		deck2.invalidate();
		deck2.validate();
		deck2.revalidate();
		deck2.repaint();
		
		
		
		refreshPlayer2Panel();
		refreshBench();
		refreshActive();
		invalidate();
		validate();
		repaint();
		try {
			System.out.println("Bench");
			for (int i = 0; i < HUMAN.bench.length; i++) {
				System.out.println(HUMAN.bench[i].m_type);
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		try {
			System.out.println("Hand");
			for (int i = 0; i < HUMAN.hand.length; i++) {
				System.out.println(HUMAN.hand[i].m_type);
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		try {

			System.out.println("Active");

			System.out.println("Pokemon Active "+HUMAN.active.m_type+ ((CardPokemon)HUMAN.active).m_energy);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("refresh working");
	}

	public static Play AI, HUMAN;
	static GameEngine ge;
	public static void main(String[] args) {
		
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		ge = new GameEngine();
		GameEngine.ge=ge;
		AI = new Play();
		HUMAN = new Play();
		
		AI.role=true;
		HUMAN.role=false;
		
		ge.initGame();
	}

	public void refreshPlayer2Panel() {
		CardView hand_player[] = new CardView[15];
		System.out.println("Shuffling Over Complete");
		for (int i = 0; i < 15; i++) {
			try {
				// System.out.println(HUMAN.hand[i].m_type + " M_TYPE" );
				if (HUMAN.hand[i] == null) {
					//System.out.println("1111111");
				}
				if (HUMAN.hand[i].m_type == 0) {
					hand_player[i] = new CardView((CardPokemon) HUMAN.hand[i], this, i, -1, -1,0,"P");
				}
				if (HUMAN.hand[i].m_type == 1)
					hand_player[i] = new CardView((CardEnergy) HUMAN.hand[i], this, i,"E");

				if (HUMAN.hand[i].m_type == 2)
					hand_player[i] = new CardView((CardTrainer) HUMAN.hand[i], this, i,"T");
			} catch (Exception e) {

			}

		}

		for (int i = 0; i < 15; i++) {
			try {
				player2Panel.add(hand_player[i]);
			} catch (Exception e) {

			}

		}

		CardView hand_ai[] = new CardView[15];
		System.out.println("Shuffling Over Complete");
		for (int i = 0; i < 15; i++) {
			try {
				// System.out.println(HUMAN.hand[i].m_type + " M_TYPE" );
				if (HUMAN.hand[i] == null) {
					System.out.println("22222");
				}
				
				if (AI.hand[i].m_type == 0) {
					hand_ai[i] = new CardView((CardPokemon) AI.hand[i], this, i, -1, -1,1,"P");

				}
				if (AI.hand[i].m_type == 1)
					hand_ai[i] = new CardView((CardEnergy) AI.hand[i], this, i,"E");

				if (AI.hand[i].m_type == 2)
					hand_ai[i] = new CardView((CardTrainer) AI.hand[i], this, i,"T");
			} catch (Exception e) {

			}

		}

		for (int i = 0; i < 15; i++) {
			try {
				player1Panel.add(hand_ai[i]);
			} catch (Exception e) {
				System.out.println(i);

			}

		}

	}

	public void refreshActive() {

		try {
			CardView active_player,active_ai;

			active_player = new CardView((CardPokemon) HUMAN.active, this, -1, -1, 1,0,"P");
			active2.add(active_player);
			active2.repaint();
			
			active_ai = new CardView((CardPokemon) AI.active, this, -1, -1, 1,1,"P");
			active1.add(active_ai);
			active1.repaint();
			
			
		} catch (Exception e) {
			 //e.printStackTrace();
		}

	}

	public void refreshBench() {
		CardView bench_player[] = new CardView[5];
		for (int i = 0; i < 5; i++) {
			try {
				if (HUMAN.bench[i].m_type == 0) {
					System.out.println("----------------------------New SET---------------------------");
					bench_player[i] = new CardView((CardPokemon) HUMAN.bench[i], this, -1, i, -1,0,"P");
				}
			} catch (Exception e) {
			}
		}

		for (int i = 0; i < 5; i++) {
			try {
				bench2.add(bench_player[i]);
			} catch (Exception e) {

			}
		}

		CardView bench_ai[] = new CardView[5];
		for (int i = 0; i < 15; i++) {
			try {
				if (AI.bench[i].m_type == 0) {

					bench_ai[i] = new CardView((CardPokemon) AI.bench[i], this, i, -1, -1,1,"P");
				}

			} catch (Exception e) {

			}
		}

		for (int i = 0; i < 5; i++) {
			try {
				bench1.add(bench_ai[i]);
			} catch (Exception e) {

			}
		}

	}
	
	
	

}