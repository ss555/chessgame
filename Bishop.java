
public class Bishop extends Piece{

	public Bishop(String image,boolean available,boolean isWhite, int x, int y){
		super(image,available,isWhite, x, y);
	}
	
	@Override
    public boolean isValid(Board board, int X, int Y, int tox, int toy) { // the bishop moves as far as it wants diagonally 
        if(super.isValid(board, X, Y, tox, toy) == false)// checks if the move is inside the board
            return false;
        if(Math.abs(X-tox)==Math.abs(Y-toy)){ // for each direction we check if there is a piece in the way of the bishop
			if(X>tox){
				if(Y>toy){
					for(int i=1;i<(X-tox);i++){
						if(board.spotArray[X-i][Y-i].isOccupied()){
							return false;
						}
					}
				}else{
					for(int i=1;i<(X-tox);i++){
						if(board.spotArray[X-i][Y+i].isOccupied()){
							return false;
						}
					}
				}
			}else{
				if(Y>toy){
					for(int i=1;i<(tox-X);i++){
						if(board.spotArray[X+i][Y-i].isOccupied()){
							return false;
						}
					}
				}else{
					for(int i=1;i<(tox-X);i++){
						if(board.spotArray[i+X][i+Y].isOccupied()){
							return false;
						}
					}
				}
			}
		}
		return (Math.abs(X-tox)==Math.abs(Y-toy));
    }
}
