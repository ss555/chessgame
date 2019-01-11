
public class Knight extends Piece{

	public Knight(String image,boolean available,boolean isWhite, int x, int y){
		super(image,available,isWhite, x, y);
	}
	
	@Override
    public boolean isValid(Board board, int fromX, int fromY, int tox, int toy) {
        return((Math.abs(fromX-tox)==2&&Math.abs(fromY-toy)==1)||(Math.abs(fromX-tox)==1&&Math.abs(fromY-toy)==2)); //checks if the knight moves 2 squares in one direction and then 1 square at a 90° angle
		//isvalidknight(L shape move)
    }
	
}
