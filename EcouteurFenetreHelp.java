import javax.swing.*; //utilisation de Widgets
import java.awt.event.*; //utilisation d'événements

public class EcouteurFenetreHelp implements ActionListener{

	private FenetreJeu fenetrejeu;
	
	/*
	 * Ecouteur which lets us clik in the button instructions in the game and make the frame Instructions appear.  
	 */
	 
	public EcouteurFenetreHelp(FenetreJeu v){ fenetrejeu=v; }
	
	public void actionPerformed(ActionEvent ae){
		
		new FenetreHelp();
	}
}
