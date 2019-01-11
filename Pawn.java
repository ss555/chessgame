
public class Pawn extends Piece{
	public Pawn(String image,boolean available,boolean isWhite, int x, int y){
		super(image,available,isWhite, x, y);
	}

	public boolean isValid(Board board, int x, int y, int tox, int toy) {
		if(super.isValid(board, x, y, tox, toy) == false)
            return false;
		if(tox==x){
			if(board.spotArray[tox][toy].isOccupied())return false;
			if((this.isWhite())&&(y==1)){
				return((toy-y)>0&&(toy<4));
				//white pawns can move two spots forward at once on its own territory of the board
			}
			if((!this.isWhite())&&(y==6)){
				return((y-toy)>0&&(toy>3));
				//black pawns can move two spots forward at once on its own territory of the board
			}
			if(this.isWhite()){//On the other half of the board the pawn can only move 1 square forward
					if((toy-y)==1){
					return true;
				}
			}else{
				if((toy-y)==-1){
					return true;
				}
			}
		
			
		}else if(Math.abs(tox-x)==1&&(board.spotArray[tox][toy].isOccupied())&&(board.spotArray[tox][toy].piece.isWhite()!=this.isWhite())){//the pawn kills by moving 1 square to the right or left
			
			if(this.isWhite()){
					if((toy-y)==1){
					return true;
				}
			}
			if((toy-y)==-1){
					return true;
			}
		}
		
		return false;
	}
	

}
