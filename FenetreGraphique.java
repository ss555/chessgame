//This method creates the window that opens when we want to play. When we play against someone it initializes the board, the players and their pieces
import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class FenetreGraphique extends JFrame implements  ActionListener{
	
	private JButton bt = new JButton("Against another player");
	private JButton btIA = new JButton("Against the computer");
	private ImagePanel panel = new ImagePanel(new ImageIcon("1480869850_original.jpg").getImage());//Background image
	private EcouteurAI ai = new EcouteurAI(this);
	
	public FenetreGraphique(){//defines the first window that will open. Enables to choose between playing against someone or against the computer
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		panel.setLayout(null);
		btIA.addActionListener(ai);
		bt.addActionListener(this);//when we click on the button 
		bt.setBounds(650,530,180,40);
		bt.setBorder(new LineBorder(Color.BLACK));
		bt.setBackground(Color.lightGray);
		btIA.setBounds(950,530,180,40);
		btIA.setBorder(new LineBorder(Color.BLACK));
		btIA.setBackground(Color.lightGray);
		
		panel.add(bt);
		panel.add(btIA);
		
		
		setSize(1200,700);
		setContentPane(panel);	
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		Player white = new Player(true);
		Player black = new Player(false);//Initialization of the 2 players
		white.initializePieces();
		black.initializePieces();
		
		Board board = new Board();//Creation of the board
		
		Game game = new Game(white, black, board);
		game.initializeBoardGivenPlayers();
		
		FenetreJeu j = new FenetreJeu(board, 100);
			
	}    

    
	public static void main(String[] args) {//launches the game
	
		FenetreGraphique f = new FenetreGraphique(); 
		
		
		
	}
}
