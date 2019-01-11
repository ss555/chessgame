
import java.util.ArrayList;
import java.util.List;

public class RANDOMAI extends Player{
	
	public static Piece selected_random;
	public static List<Spot> possible=new ArrayList<>();
	 
	public static Spot initial;
	public static Spot finall;
	
	public RANDOMAI(boolean isWhite) {
        super(isWhite);
    }
	
	
	public static void makemove(Board board1){
		
		int r=(int)(Math.random() * pieces.size());
		Piece selected_random=pieces.get(r);//finds the random among the possible pieces
		initial=board1.spotArray[selected_random.getX()][ selected_random.getY()];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(selected_random.isValid( board1, initial.x, initial.y, i, j)){
					System.out.println("yeap");
					possible.add(board1.spotArray[i][j]);
				}
			}
		}
		int r1=(int)(Math.random() * possible.size());
		finall=possible.get(r);
		finall.occupySpot(selected_random);
		finall.repaint();
		initial.releaseSpot();
		initial.repaint();
		
	} 
}

