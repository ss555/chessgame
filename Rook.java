
public class Rook extends Piece{

	public Rook(String image,boolean available,boolean isWhite, int x, int y){
		super(image,available,isWhite, x, y);
	}
	
	@Override
    public boolean isValid(Board board, int x, int y, int tox, int toy) {
        if(super.isValid(board, x, y, tox, toy) == false)
            return false;
        //there are 4 possibilities for moving the rook thats why 2 "if" statements that themselves have an "if" statement
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
		
		return ((x==tox)&&(y!=toy))||((y==toy)&&(x!=tox));
    }
}
