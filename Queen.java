
public class Queen extends Piece {
	
	public Queen(String image, boolean available,boolean isWhite, int x, int y){
		super(image,available,isWhite, x, y);
	}
	
	@Override
    public boolean isValid(Board board, int X, int Y, int tox, int toy) {
        if(super.isValid(board, X, Y, tox, toy) == false)
            return false;
        //there are 4 possibilities for moving the queen thats why 2 "if" statements that themselves have an "if" statement just like the rook
		if((x==tox)&&(y!=toy)){//horizontal move
			int max,min;
			max=Math.max(y,toy);
			min=Math.min(y,toy);
			for(int i=min+1;i<max;i++){
				if(board.spotArray[x][i].piece!=null){//checks if there are pieces on the path
					//System.out.println("Be careful there is a figure on your way,you can't jump through the figures!:-)");
					return false;
					
				}
			}

		}
			
			
		if((y==toy)&&(x!=tox)){//vertical move
			int max,min;
			max=Math.max(x,tox);
			min=Math.min(x,tox);
			for(int i=min+1;i<max;i++){
				if(board.spotArray[i][y].piece!=null){//checks if there are pieces on the path
					//System.out.println("Be careful there is a figure on your way,you can't jump through the figures!:-)");  WE used these lines to compile the codes
					return false;
					
				}
			}
		}
		//moves like a bishop, we check it
		if(Math.abs(X-tox)==Math.abs(Y-toy)){
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
		return ((Math.abs(X-tox)==Math.abs(Y-toy))||((x==tox)&&(y!=toy))||((y==toy)&&(x!=tox)));
    }


}
