package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;


import Backend.Model;
import Backend.check;
import Graphics.*;

public class Controller implements MouseListener, ActionListener{
//fields
private int x, y;
private static int [][] layout;
//GUI window
private static GameWindow Frame;
//Model
private static Model game;

// state?
private boolean currentState = false;
private boolean startState = false;



//Rows Columns
private static final int ROW = 6, COL = 7;

	public Controller (JPanel board, JButton start, JButton current, JButton save, JButton load, JButton check){
		board.addMouseListener(this);
		start.addActionListener(this);
		current.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		check.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton a = (JButton)arg0.getSource();
		String button = a.getText();
		layout = game.getLayout();
		
		if(button.equalsIgnoreCase("Start Game")){
			startState = !startState;
			if(currentState){
				currentState = !currentState;
			}
			game.startNewGame();
		}else if(button.equalsIgnoreCase("Save")){
			save();
		}else if(button.equalsIgnoreCase("Load")){
			load();
			update();
		}else if(button.equalsIgnoreCase("Check")){
			String error = "Error: ";
			boolean flag = false;
			if(check.check4(layout)){
				flag = true;
				error = error + "Four in a Row,";
			}
			if(!check.checkEqual(layout)){
				flag = true;
				error = error + "Imbalanced Colours,";
			}
			if(check.checkFloating(layout)){
				flag = true;
				error = error + "Unsupported disks,";
			}
			if(flag){
				game.setActiveString(error.substring(0,error.length()-1));
			}else{
				game.setActiveString("All Checks Passed");
			}
			
		}else if(button.equalsIgnoreCase("Current State")){
			currentState = !currentState;
			if(startState){
				startState = !startState;
			}
			game.startCurrentState();
			
		}
		update();
	}
	
	
	//event is trigged when the mouse is clicked on any of the added windows
	@Override
	public void mouseClicked(MouseEvent e) {
		//gets the x and y coordinates of the click
		x = e.getX();
		y = e.getY();
		
		int i = rowClicked(y);
		int j = colClicked(x);
		if (startState | currentState){
			if (currentState){
				if(j == -1 && i == 0){
					game.setActiveColour(1);
				}else if(j == 7 && i == 0){
					game.setActiveColour(-1);
				}
			}
			if(j>-1 && j<7 && i>-1 && i<7){
				int colour = game.getActiveColour();
				game.setColour(i,j);
				if(startState && colour == -1){
					game.setActiveColour(1);
				}else if(startState && colour == 1){
					game.setActiveColour(-1);
				}
			}
		}
		
		update();
		
	}
	
	//creates the graphics window, starts the game
	public static void main(String [] args){
		game = new Model(ROW,COL);
		layout = game.getLayout();
		Frame = new GameWindow(layout);
	}
	
	public static void update(){
		Frame.update(game.getActiveString(),game.getLayout());
	}
	
	public int rowClicked(int x){
		if(x<75){
			return 0;
		}else if(x<150){
			return 1;
		}else if(x<225){
			return 2;
		}else if(x<300){
			return 3;
		}else if(x<375){
			return 4;
		}else if(x<450){
			return 5;
		}else{
			return -1;
		}
	}
	
	public int colClicked(int x){
		if(x<75){
			return -1;
		}else if(x<150){
			return 0;
		}else if(x<225){
			return 1;
		}else if(x<300){
			return 2;
		}else if(x<375){
			return 3;
		}else if(x<450){
			return 4;
		}else if(x<525){
			return 5;
		}else if(x<600){
			return 6;
		}else if(x<675){
			return 7;
		}else{
			return -10;
		}
	}
	public static void load(){
		Scanner loadGame = null;
		try {
			loadGame = new Scanner (new File("data/save.txt")).useDelimiter("/n");
		} catch (FileNotFoundException e) {
			System.exit(0);
		} 
		String line = loadGame.next();
		int i = 0;
		int col = 0;
		int row = 0;
		while(loadGame.hasNext()){
			if(col > COL){
				col = 0;
				layout[row][col] = Integer.parseInt(line);
				System.out.println(layout[row][col]);
				row++;
			}
			layout[row][col] = Integer.parseInt(line);
			col++;
		}
		game.setLayout(layout);
		update();
	}
	public static void save(){
		layout = game.getLayout();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter( new File("data/save.txt"));
		} catch (FileNotFoundException e) {
			System.exit(0);
		}
		for (int row = 0; row < ROW; row ++){
			for (int col = 0; col < COL; col++){
				writer.println(layout[row][col]);
			}
		}
		writer.close();
	}

	//Mouse events below are not used currently used
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	
	}
}