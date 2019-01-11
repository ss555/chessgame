// Implements the window on which we play, with the grid formed of the squares and the help button
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;

public class FenetreJeu extends JFrame{
    
	
	public FenetreJeu(Board board, int size){
		
		EcouteurFenetreHelp ec = new EcouteurFenetreHelp(this);
		JPanel jPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(8, 8);
		gridLayout.setHgap(0); //horizontal gap
        gridLayout.setVgap(0);//Vertical gap
		
		jPanel.setLayout(gridLayout);// puts grid on JPanel
		jPanel.setMaximumSize(new Dimension(8 * size, 8 * size)); // if we change the size of the window the size of the board doesn't change
        
        Spot spot;
        Dimension dim = new Dimension(size, size);
        for (int x = 0; x < 8; x++){
        	for (int y = 0; y < 8; y++){
        		spot = board.getSpot(x, y);
        		spot.setMinimumSize(dim);
        		spot.setPreferredSize(dim);
        		jPanel.add(spot);
        	} // adds each spot to fill the grid
        }
  
		
		//Definition of the Help button that will enable the player to have access to the help window
		JButton helpButton = new JButton();
		try{
			Image helpImage = ImageIO.read(new File("images/icon_help.gif"));
			helpButton.setIcon(new ImageIcon(helpImage));
		} catch (Exception ex){
			System.out.println(ex);
		}
		helpButton.setPreferredSize(new Dimension(50,40));
		helpButton.addActionListener(ec);
		
		
		
        JPanel wrap = new JPanel(); //take all the space on the JFrame so that the grid doesn't change size when the window does
        wrap.setLayout(new GridBagLayout());
        
        //Gives the origin of the grid to enable us to place the help button
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = (0);
        gbc.gridy = (1);
               
        //We add the help button 
        wrap.add(helpButton, gbc);
        wrap.add(jPanel);
        
		add(wrap, BorderLayout.CENTER); //center the wrap on the JFrame      
		pack();// JFrame takes width and length of its component so of wrap and JPanel
		setVisible(true);
		setMinimumSize(new Dimension(8 * size, 8 * size + 46));
	}
}



