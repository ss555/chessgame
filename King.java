
public class King extends Piece{

	public King(String image,boolean available,boolean isWhite, int x, int y){
		super(image,available,isWhite, x, y);
	}
	
	@Override
	public boolean isValid(Board board, int X, int Y, int toX, int toY) {
        if(Math.abs(X-toX)<2&&Math.abs(Y-toY)<2){ //checks if the king is moving only one square in any direction
			return true;
		}
		return false;
	}

}
