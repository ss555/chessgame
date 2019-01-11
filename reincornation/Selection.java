
public class Selection {
	private final Board board;
	private Piece selectedPiece = null;
	
	public Selection(Board board){
		this.board = board;
	}
	
	public void clic(int x, int y, Piece piece){
		if (selectedPiece != null){ //not the first piece we click on 
			if (selectedPiece.isValid(board, selectedPiece.getX(), selectedPiece.getY(), x, y)){
				if (piece != null){//second piece we click on
					if (piece.isWhite() == selectedPiece.isWhite()) {//if it's one of your pieces
						board.getSpot(selectedPiece.getX(), selectedPiece.getY()).unselect();//does not select anymore the first piece
						selectedPiece = null;
					}
					else { //enemy's piece
						Spot spot = board.getSpot(selectedPiece.getX(), selectedPiece.getY()); //get the spot of the first selected piece (we have a move)
						spot.releaseSpot();
						spot.unselect();
						spot.repaint();
						spot = board.getSpot(x, y);
						if(selectedPiece.getType()=="Pawn"){
							if(spot.y==0 && selectedPiece.isWhite()==false){
								spot.changePawn(selectedPiece.isWhite());
							}
							if(spot.y==7 && selectedPiece.isWhite()){
								spot.changePawn(selectedPiece.isWhite());
							}
							else{
								spot.occupySpot(selectedPiece);
								}
						}else{
							spot.occupySpot(selectedPiece);
						}
						spot.repaint();
						
						selectedPiece = null;
					}
				} else {// if we click on an empty spot
					Spot spot = board.getSpot(selectedPiece.getX(), selectedPiece.getY());
					spot.releaseSpot();
					spot.unselect();
					spot.repaint();
					spot = board.getSpot(x, y);
					if(selectedPiece.getType()=="Pawn"){
							if(spot.y==0 && selectedPiece.isWhite()==false){
								spot.changePawn(selectedPiece.isWhite());
							}
							if(spot.y==7 && selectedPiece.isWhite()){
								spot.changePawn(selectedPiece.isWhite());
							}
							else{
								spot.occupySpot(selectedPiece);
								}
						}else{
							spot.occupySpot(selectedPiece);
						}
					spot.repaint();
					selectedPiece = null;
				}
						
				board.wipeOutRed();
					
			} else {
				board.getSpot(selectedPiece.getX(), selectedPiece.getY()).unselect();	
				selectedPiece = null; // if we click somewhere the piece can't go we unselect it
			}
			
							
		} else if (piece != null) {//when we first click on the first spot with a piece on it
			selectedPiece = piece;
			board.getSpot(selectedPiece.getX(), selectedPiece.getY()).select();
			
			//checking all the valid moves and painting them red if the moves are valid
			//we use integers as these are constants
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						if(selectedPiece.isValid(this.board,this.selectedPiece.getX(),this.selectedPiece.getY(),i,j)){
							this.board.getSpot(i,j).setRed();
							this.board.getSpot(i,j).repaint();
						}
					}
				}
		}
	
	}
}
