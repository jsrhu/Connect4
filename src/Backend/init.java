package Backend;

public class init {
	private static int [][] layout;
	//pre: 2 ints, the # rows and # columns wanted for the board
	//post: returns a 2D array, all initialized to contain the internal representation of a white disk
	public static int [][] initEmpty(int Row, int Col){
		layout = new int [Row][Col];
		for (int row = 0; row < Row; row++){
			for (int col = 0; col < Col; col++){
				layout[row][col] = 0;
			}
		}
		return layout;
	}
	//pre: none
	//post: returns randomly which color will start the game
	public static int initRandomStart(){
		if (Math.random() < 0.5){
			return 1;
		}else{
			return -1;
		}
	}
}
