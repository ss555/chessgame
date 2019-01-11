// All of the classes "Piece" implement if a piece is available or not, its colour, its coordinates on the board, and if it is able to move
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Piece{
	private boolean available;
	private boolean isWhite;
	protected int x;
	protected  int y;
	private BufferedImage image;
	
	public Piece(String image, boolean available,boolean isWhite, int x, int y){ //Constructor of the piece
		try {
             this.image = ImageIO.read(new File(image)); //Gets the image of the piece 
             
        } catch(Exception err) {
        	err.printStackTrace();
            System.out.println(image+" introuvable !");            
            System.exit(0);
        }
		this.available = available;
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	public boolean isAvailable() { //tells if a piece is available hence if it hasn't been eaten yet
        return available;
    }
    
    public void setAvailable(boolean available) { // enables to set a piece available hence to say that we can play with it
        this.available = available;
    }
    
    public boolean isWhite(){ //returns true if the piece is white
    	return this.isWhite;
    }
    
    public int getX() { //gets the x coordinate of the piece
        return x;
    }
    
    public void setX(int x) { //sets the x coordinate of the piece
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){ // checks if the move that we want to make is inside the boundaries of the board
        if(toX == fromX && toY == fromY)
            return false; //We don't move 
        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
            return false; //Move outside of the board is not possible
        return true;
    }
    
  
    public void drawPiece(Graphics g){ //draw the piece and give its dimensions
    	g.drawImage(image, 0, 0, 100, 100, null);
    }

    
}
