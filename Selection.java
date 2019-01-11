//This method implements what happens when we click on a square depending on what we can or cannot do 
public class Selection {
	private final Board board;
	private Piece selectedPiece = null;
	public static boolean endgame=false;
	public static boolean turn_white=true;
	
	public Selection(Board board){
		this.board = board;
	}
	
	public void clic(int x, int y, Piece piece){
		if(!endgame){
		if (selectedPiece != null){ //We first select a piece 
			if (selectedPiece.isValid(board, selectedPiece.getX(), selectedPiece.getY(), x, y)&&(turn_white==selectedPiece.isWhite())){//We check if th epiece can move and if it correpsonds to the colour of the player suppose to play
				if (piece != null){//second piece we click on
					if (piece.isWhite() == selectedPiece.isWhite()) {//if it's one of your pieces
						board.getSpot(selectedPiece.getX(), selectedPiece.getY()).unselect();//does not select anymore the first piece
						selectedPiece = null;
					}
					else { //enemy's piece
						if(piece.getClass().getSimpleName()=="King"){//checks for mate,i.e if the king of the opponent is killed
							System.out.println("GAME IS OVER.CONGRATULATIONS!!!");
							if(!piece.isWhite()){
								System.out.println("WHITE has won");
								endgame=!endgame;//game ends so no need to continue, the king is dead!
							}else{
								System.out.println("BLACK has won");
								endgame=!endgame;//game ends so no need to continue, the king is dead!
							}
						}
						turn_white=!turn_white;
						Spot spot = board.getSpot(selectedPiece.getX(), selectedPiece.getY()); //get the spot of the first selected piece (we have a move)
						spot.releaseSpot(); //redefines the square as an empty one 
						spot.unselect();
						spot.repaint();
						spot = board.getSpot(x, y);
						spot.occupySpot(selectedPiece);
						spot.repaint();
						
						selectedPiece = null;
					}
				} else {// if we click on an empty spot
					turn_white=!turn_white;
					Spot spot = board.getSpot(selectedPiece.getX(), selectedPiece.getY());
					spot.releaseSpot();
					spot.unselect();
					spot.repaint();
					spot = board.getSpot(x, y);
					spot.occupySpot(selectedPiece);
					spot.repaint();
					selectedPiece = null;
				}
				
				board.wipeOutRed();
					
			} else {
				board.getSpot(selectedPiece.getX(), selectedPiece.getY()).unselect();	
				selectedPiece = null; // if we click somewhere the piece can't go we unselect it
			}
            
            //we "remove" the red attribute of the spots
            
            //checking all the valid moves and painting them red if the moves are valid
			//we use integers as these are constants
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
                        this.board.getSpot(i,j).unsetRed();
                        this.board.getSpot(i,j).repaint();
                    
					}
				}
		} else if (piece != null) {//when we first click on the first spot with a piece on it
			selectedPiece = piece;
			board.getSpot(selectedPiece.getX(), selectedPiece.getY()).select();
			//checking all the valid moves and painting them red if the moves are valid
			//we use integers as these are constants
            //NOTE : I may have gotten wrong the order of i and j. If it is the case, don't forget to change and to write down somewhere what i and j correspond to (as x and y)
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						if(selectedPiece.isValid(this.board,this.selectedPiece.getX(),this.selectedPiece.getY(),i,j)){
                            //we should maybe add the "exception" there is a piece of the same color on the spot
							this.board.getSpot(i,j).setRed();
							this.board.getSpot(i,j).repaint();
						}
					}
				}
			
		}
	}
	
	}
}
