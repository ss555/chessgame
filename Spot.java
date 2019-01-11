//this method is implemeting the squares. It is used to know when we click on a square what can happen thanks to the mouse lostener.
//This method also implements the graphical aspect of the square by assgning a color to each one according to its position and the position of the mouse
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Spot extends JComponent{
	public final int x;
	public final int y;
	protected Piece piece;
	private boolean inside = false;
	private boolean selected = false;
	private boolean red=false; //this boolean is used for coloring the spots red if the selected piece can go on it
	
	public Spot (int x, int y, Selection selection){
		this.x = x;
		this.y = y;
		piece = null;
		
		
		addMouseListener(new MouseAdapter() {// mouse listener on each of the squares
			@Override
			public void mouseEntered(MouseEvent arg0) {
				inside = true;
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				inside = false;
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selection.clic(x, y, piece);
			}
		});
	}
	
	public void occupySpot (Piece piece){ //eating method : a piece replaces another one on a square
		if (this.piece != null) {
			this.piece.setAvailable(false); //if there is a piece on the spot it becomes not available
		}
		this.piece = piece; // put the new piece on the spot
		piece.setX(x);//give to the new piece the coordinates of the square
		piece.setY(y);
		}
		
		public void setRed(){
			this.red=true;
		}
		
		public void unsetRed(){
			this.red=false;
		}
	
	public boolean isOccupied(){ //checks if a square is empty or not
		if (piece != null)
			return true;
		return false;
	}
	
	public Piece releaseSpot(){ // tell you what piece you removed from the square
		Piece releasedPiece = this.piece;
		this.piece = null;
		return releasedPiece;
	}
	
	public void select(){
		selected = true;
		repaint();
	}
	public void unselect(){
		selected = false;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		if(selected){
			 g.setColor(new Color(20,255,20)); //when we click on a square it turns green
	}
		else if (red){
		g.setColor(new Color(255,0,0)); //if the move is valid the color is turned to red
		}
		else {
			if (y % 2 == x % 2) {//colors the squares which have even coordinates
				if (inside) g.setColor(new Color(80,80,80));//slight nuance when we pass the mouse over it
				else g.setColor(Color.darkGray); //we can't see the black pieces on black squares so we modified the color to light grey
			} else {// colors the squares which have odd coordinates
	    		if (inside) g.setColor(new Color(205,205,205)); 
	    		else g.setColor(Color.white);
	    	}
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		if (piece != null) piece.drawPiece(g);//Draw the pieces in the spot 
	}
}
