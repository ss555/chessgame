//creates the board, an array of spot
public class Board{
	
	protected Spot[][] spotArray = new Spot[8][8];
	
	public Board(){
		Selection selection = new Selection(this);
		for (int i=0; i<spotArray.length; i++){
			for (int j=0; j<spotArray.length; j++){
				spotArray[i][j] = new Spot(i,j, selection);
			}
		}
	}
	
	public Spot getSpot (int x, int y){
		return spotArray[x][y];
	}
	
	public void wipeOutRed(){ //we want to earase all the red in the board by going through all the spots in the array and setting red to false, repainting each spot every time
			for(int i=0;i<spotArray.length;i++){
				for(int j=0;j<spotArray[0].length;j++){
					this.spotArray[i][j].unsetRed();
					this.spotArray[i][j].repaint();
					
				}
			}
	}
	
}
