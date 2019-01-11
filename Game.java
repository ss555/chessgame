//Starts the game by putting the pieces on the board

import java.util.List;

public class Game{
	private final Player white;
	private final Player black;
	private final Board board;
	
	public Game(Player white, Player black, Board board){
		this.white = white;
		this.black = black;
		this.board = board;
	}

    public Board getBoard() {
        return board;
    }

    public Player getWhite() {
        return white;
    }

    public Player getBlack() {
        return black;
    }

    public boolean initializeBoardGivenPlayers() { // put player's pieces on the board
    	List<Piece> pieces = black.getPieces();
    	Piece piece;
    	for (int i = 0; i < pieces.size(); i++){ 
    		piece = pieces.get(i);
    		board.getSpot(piece.getX(), piece.getY()).occupySpot(piece);
    	}
    	pieces = white.getPieces();
    	for (int i = 0; i < pieces.size(); i++){
    		piece = pieces.get(i);
    		board.getSpot(piece.getX(), piece.getY()).occupySpot(piece);
    	}
        return true;
    }
	
	
	//Method to determine who is winning, therefore end the game
	// we will have a boolean gamewon in the main, and when it is going to be true the game is going to be over
	
}
