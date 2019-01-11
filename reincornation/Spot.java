
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.util.Scanner;

public class Spot extends JComponent{
	public final int x;
	public final int y;
	private Piece piece;
	private boolean inside = false;
	private boolean selected = false;
	private boolean red=false;
	
	public Spot (int x, int y, Selection selection){
		this.x = x;
		this.y = y;
		piece = null;
		
		
		addMouseListener(new MouseAdapter() {
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
	
	public void occupySpot (Piece piece){ 
		if (this.piece != null) {
			this.piece.setAvailable(false); //not available should leave the player's list
		}
		this.piece = piece;
		piece.setX(x);
		piece.setY(y);
		}
		
		public void setRed(){
			this.red=true;
		}
		
		public void unsetRed(){
			this.red=false;
		}
	
	public boolean isOccupied(){
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
	
	public void changePawn(boolean white){
		boolean changed=false;
		while(!changed){
		System.out.println("What piece do you want ? Type 1 for queen, 2 for rook, 3 for knight, 4 for bishop");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		this.releaseSpot();
		switch (i){
			case 1: 
			if(white){
				Piece newPiece = new Queen("images/QueenWhite.png",true,true, this.x, this.y);
				this.occupySpot(newPiece);
			}else{
				Piece newPiece = new Queen("images/QueenBlack.png",true,false, this.x, this.y);
				this.occupySpot(newPiece);
			}
			
			
			changed=true;
			break;
			
			case 2: 
			if(white){
				Piece newPiece = new Rook("images/RookWhite.png",true,true, this.x, this.y);
				this.occupySpot(newPiece);
			}else{
				Piece newPiece = new Rook("images/RookBlack.png",true,false, this.x, this.y);
				this.occupySpot(newPiece);
			}

			changed=true;
			break;
			
			case 3: 
			if(white){
				Piece newPiece = new Knight("images/KnightWhite.png",true,true, this.x, this.y);
				this.occupySpot(newPiece);
			}else{
				Piece newPiece = new Knight("images/KnightBlack.png",true,false, this.x, this.y);
				this.occupySpot(newPiece);
			}
			
			changed=true;
			break;
			
			case 4: 
			if(white){
				Piece newPiece = new Bishop("images/BishopWhite.png",true,true, this.x, this.y);
				this.occupySpot(newPiece);
			}else{
				Piece newPiece = new Bishop("images/BishopBlack.png",true,false, this.x, this.y);
				this.occupySpot(newPiece);
			}
			
			changed=true;
			break;
			
			default:
			if (i<=0 && i>=5)
			changed=false;
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //mandatory
		//if actionevent alors on change la couleur en bleu
		if(selected){
			 g.setColor(new Color(20,255,20)); //when we click on it turns green
	}
		else if (red){
		g.setColor(new Color(255,0,0));
		}
		else {
			if (y % 2 == x % 2) {
				if (inside) g.setColor(new Color(80,80,80));//slight nuance when we pass the mouse over it
				else g.setColor(Color.darkGray); //we can't see the black pieces
			} else {
	    		if (inside) g.setColor(new Color(205,205,205));
	    		else g.setColor(Color.white);
	    	}
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		if (piece != null) piece.drawPiece(g);//Draw the pieces in the spot 
	}
}
