import javax.swing.*; //utilisation de Widgets
import java.awt.event.*; //utilisation d'événements

public class EcouteurAI implements ActionListener{

	private FenetreGraphique fenetregraphique;
	
	/*
	 * Ecouteur which lets us clik in the button instructions in the game and make the frame Instructions appear.  
	 */
	 
	public EcouteurAI(FenetreGraphique v){ fenetregraphique=v; }
	
	public void actionPerformed(ActionEvent ae){
		Player white = new Player(true);
		RANDOMAI black = new RANDOMAI(false);
		
		white.initializePieces();
		black.initializePieces();
		
		Board board = new Board();
		Selection selection = new Selection(board);
		Game game = new Game(white, black, board);
		game.initializeBoardGivenPlayers();
		
		FenetreJeu j = new FenetreJeu(board, 100);
		//while (!endgame){
			if(!selection.turn_white){
				black.makemove(board);
			}
		
		
	}
}
