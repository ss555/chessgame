//Help window that defines the rules to the player if needed
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class FenetreHelp extends JFrame{
	
	private ImagePanel imagepanel = new ImagePanel(new ImageIcon("9275420-las-posiciones-iniciales-de-las-piezas-de-ajedrez-en-el-tablero-de-ajedrez-Foto-de-archivo.jpg").getImage());//Background image
	private JTextArea text;
	
	 /**
     * Constructor which creates the instructions frame . 
     * It has a JTextArea where we have written the instructions. 
     * As a foreground the frame uses a panel which is called imagepanel and which has a image as a wallpaper.
     */
	
	public FenetreHelp(){
	
	super("Instructions");	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JTextArea text = new JTextArea("  THE GOAL OF CHESS \n"+"\n Chess is a game played between two opponents on opposite sides of a board containing 64 squares of alternating colors.  " + 
		" Each player has 16 pieces: 1 king, 1 queen, 2 rooks, 2 bishops, 2 knights, and 8 pawns. " + 
		" The goal of the game is to checkmate the other king. Checkmate happens when the king is in a position to be captured (in check) and cannot escape from capture.\n" + 
		"\n  STARTING A GAME \n" +"\n The white player starts. He can only move one of its pawn one or two squares forward (see moves of pawn). \n"+"\n  HOW PIECES MOVE \n" + " \n Each of the 6 different kinds of pieces moves differently. Pieces cannot move through other pieces (though the knight can jump over other pieces), " + 
		"and can never move onto a square with one of their own pieces. However, they can be moved to take the place of an opponent's piece which is then captured. " + "Pieces are generally moved into positions where they can capture other pieces"
		+"(by landing on their square and then replacing them), defend their own pieces in case of capture, or control important squares in the game. \n"+"\n King:"+ " It can only move one square in any direction - up, down, to the sides, and diagonally. "
		+"\n Knight: Knights move in a very different way from the other pieces, going two squares in one direction, and then one more move at a 90 degree angle, just like the shape of an L. "
		+"\n Bishop: The bishop may move as far as it wants, but only diagonally. Each bishop starts on one color (light or dark) and must always stay on that color."
		+ "\n Queen:  She can move in any one straight direction - forward, backward, sideways, or diagonally, as far as possible as long as she does not move through any of her own pieces."+ "\n Rook: The rook may move as far as it wants, but only forward, backward, and to the sides. "
		+ "\n Pawn: Pawns can only move forward one square at a time, except for their very first move where they can move forward two squares. Pawns can only capture one square diagonally in front of them. They can never move or capture backwards.\n"
		+"\n  CHECK & CHECKMATE \n"+"\n The purpose of the game is to checkmate the opponents king. This happens when the king is put into check and cannot get out of check."+
		" There are only three ways a king can get out of check: move out of the way (though he cannot castle!), block the check with another piece, or capture the piece threatening the king."+
		" If a king cannot escape checkmate then the game is over. Customarily the king is not captured or removed from the board, the game is simply declared over." );
	
	text.setFont(new Font("Serif", Font.ITALIC, 16)); // We introduce the size and the type of font.
	text.setBounds(70,40,660,890); // Dimensions and position of the JTextArea
	text.setEditable(false); // We cannot edit the text.
	text.setLineWrap (true); // Pour un retour à ligne automatique
	text.setWrapStyleWord(true); // The JTextArea cannot cut the words.
	text.setBorder(new LineBorder(Color.BLACK)); // We set the border of the JTextArea in black.
	
	imagepanel.add(text);
	imagepanel.setLayout(null);
	setResizable(false);
	setSize(800,990);
	setVisible(true);	
	setContentPane(imagepanel);
	}
	
	public static void main (String args[]) {
			
			new FenetreHelp(); 
	}
}

