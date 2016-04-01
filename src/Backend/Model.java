package Backend;

public class Model {
	// Colour
	private static final int WHITE = 0, RED = 1, BLUE = -1;
	private static int [] [] layout;
	
	//Load rows and columns
	private static int ROW, COL;
	
	// Active Player
	private static int activeColour = 0;
	
	// The message to be displayed at the top of the gui
	private static String activeString = "Select A Game Mode";
	
	public Model(int row, int col){
		ROW = row;
		COL = col;
		layout = init.initEmpty(ROW,COL);
	}
	
	//pre: accepts 2 ints, the row and column number of the position to be checked
	//post: returns the internal int representation of the color in the given position 
	public int getColour(int row, int col){
		return layout[row][col];
	}
	
	//returns the internal int representation of the color that is currently able to be placed
	public int getActiveColour(){
		return activeColour;
	}
	
	//returns the internal 2D int array representation of the board
	public int[][] getLayout(){
		return layout;
	}
	
	//pre: an int
	//post: changes the activeColour to the given
	public void setActiveColour (int i){
		activeColour = i;
		if(activeColour == 1){
			setActiveString("Red's Turn");
		}else if(activeColour == -1){
			setActiveString("Blue's Turn");
		}
	}
	
	public void setLayout(int[][] layout) {
		layout = layout;
	}

	//pre: accepts 2 ints, the row and column number of the position to be changed 
	//post: changes the int representation to the current active color
	public void setColour(int Row, int Col){
		//Prevents Over Writing Spots
		if(layout[Row][Col] == WHITE){
			layout[Row][Col] = activeColour;
		}
	}
	
	//returns a string
	public String getActiveString(){
		return activeString;
	}
	
	//pre: string
	//post: changes the active string so that next time the gui is updated the given string is displayed
	public void setActiveString(String New){
		activeString = New;
	}
	
	public void startNewGame(){
		layout = init.initEmpty(ROW,COL);
		setActiveColour(init.initRandomStart());
	}
	
	public void startCurrentState(){
		layout = init.initEmpty(ROW,COL);
	}
}