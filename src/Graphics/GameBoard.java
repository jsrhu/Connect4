package Graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	private int [][] layout;

	private static final int SCALE = 75;	
	//Load Internal Representation of Colors
	private static final int RED = 1, BLUE = -1;
	//Load rows and columns
	private static final int ROW = 6, COL = 7;
	
	GameBoard(int[][] x){
		layout = x;
	}
	
	public void paint(Graphics g){		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 9*SCALE, 6*SCALE);
		//creates all the disks and empty disk spots
		for (int row = 0; row < ROW; row++){
			for (int col = 0; col < COL; col++){
				//decides which color to make each disk
				if (layout[row][col] == BLUE){
					g.setColor(Color.BLUE);
				}else if (layout[row][col] == RED){
					g.setColor(Color.RED);
				}else{
					g.setColor(Color.WHITE);
				}
				g.fillOval(SCALE + SCALE*col,SCALE*row, SCALE, SCALE); // change to final variable
			}
		}
		//Red Button
		g.setColor(Color.RED);
		g.fillOval(0, 0, SCALE, SCALE);

		//Blue Button
		g.setColor(Color.BLUE);
		g.fillOval(8*SCALE, 0, SCALE, SCALE);
	}

	public void setBoard(int[][] layout) {
		this.layout = layout;
	}
}