// defines the player and its pieces at the beginning of the game
import java.util.ArrayList;
import java.util.List;


public class Player {

    public boolean isWhite;
    protected static List<Piece> pieces = new ArrayList<>();

    public Player(boolean isWhite) { //defines the player according to its colour
        super();
        this.isWhite = isWhite;
    }

    public List<Piece> getPieces() { //returns the list of pieces that th eplayer has left
        return pieces;
    }


    public void initializePieces(){ //makes a list of the player's pieces 
        if(this.isWhite == true){
            for(int i=0; i<8; i++){ // draw 8 pawns
                pieces.add(new Pawn("images/PawnWhite.png",true,true,i,1));
            }
            pieces.add(new Rook("images/RookWhite.png",true,true, 0, 0));
            pieces.add(new Rook("images/RookWhite.png",true,true, 7, 0));
            pieces.add(new Bishop("images/BishopWhite.png",true,true, 2, 0));
            pieces.add(new Bishop("images/BishopWhite.png",true,true, 5, 0));
            pieces.add(new Knight("images/KnightWhite.png",true,true, 1, 0));
            pieces.add(new Knight("images/KnightWhite.png",true,true, 6, 0));
            pieces.add(new Queen("images/QueenWhite.png",true,true, 3, 0));
            pieces.add(new King("images/KingWhite.png",true,true, 4, 0));
        }
        else{
            for(int i=0; i<8; i++){ // draw pawns
                pieces.add(new Pawn("images/PawnBlack.png",true,false,i,6));
            }
            pieces.add(new Rook("images/RookBlack.png",true,false, 0, 7));
            pieces.add(new Rook("images/RookBlack.png",true,false, 7, 7));
            pieces.add(new Bishop("images/BishopBlack.png",true,false, 2, 7));
            pieces.add(new Bishop("images/BishopBlack.png",true,false, 5, 7));
            pieces.add(new Knight("images/KnightBlack.png",true,false, 1, 7));
            pieces.add(new Knight("images/KnightBlack.png",true,false, 6, 7));
            pieces.add(new Queen("images/QueenBlack.png",true,false, 3, 7));
            pieces.add(new King("images/KingBlack.png",true,false, 4, 7));
        }

    }
}
