//This method is used when we create other panels, it is to shorten the other methods
import java.awt.Graphics;
import java.awt.Image; 
import javax.swing.JButton;
import javax.swing.JPanel;


public class ImagePanel extends JPanel{
	
	private Image img;
	
	public ImagePanel(Image img){
        this.img = img;
    }
	
	public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}

