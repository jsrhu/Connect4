package Backend; 

public class check {
	//Loads fields
	private static final int ROW = 6;
	private static final int COL = 7;
	private static int[][] layout;

	//returns a boolean, true if there are 4 disks in a row, false otherwise
	public static boolean check4(int[][] x) {
		layout = x;
	// checks to see if there are 4 disks in a row: horizontal, vertical or diagonal
		
		// horizontal rows
		for (int row=0; row<ROW; row++) {
			for (int col=0; col<COL-3; col++) {
				int current = layout[row][col];
				if (current != 0 && current == layout[row][col+1] && current == layout[row][col+2]&& current == layout[row][col+3]) {
					return true;
				}
			}
		}
		// vertical columns
		for (int col=0; col<COL; col++) {
			for (int row=0; row<ROW-3; row++) {
				int current = layout[row][col];
				if (current != 0 && current == layout[row+1][col] && current == layout[row+2][col] && current == layout[row+3][col]){
					return true;
				}
			}
		}
		// diagonal lower left to upper right
		for (int row=0; row<ROW-3; row++) {
			for (int col=0; col<COL-3; col++) {
				int current = layout[row][col];
				if (current !=0 && current == layout[row+1][col+1] && current == layout[row+2][col+2] && current == layout[row+3][col+3]){
					return true;
				}
			}
		}
		// diagonal upper left to lower right
		for (int row=ROW-1; row>=3; row--) {
			for (int col=0; col<COL-3; col++) {
				int current = layout[row][col];
				if (current !=0 && current == layout[row-1][col+1] && current == layout[row-2][col+2] && current == layout[row-3][col+3]){
					return true;
				}
			}
		}
		return false;
	}
	
	//returns a boolean, true if there are unsupported disks
	public static boolean checkFloating(int[][] x) {
		layout = x;
		//checks to see if there are any unsupported disks
		for (int col=0; col<COL; col++){
			for (int row=0; row<ROW-1; row++){
				if (!isBlockEmpty(row, col) && isBlockEmpty(row+1, col)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//pre: 2 ints to indicate the location on the board
	//post: returns true if the indicated location is a white/empty disk
	public static boolean isBlockEmpty(int row, int col) {
		if (layout[row][col] == 0) {
			return true;
		}
		return false;
	}
	
	//returns a boolean, true if the number of red and blue disks are equal
	public static boolean checkEqual(int[][] x) {
		layout = x;
		int r=0, b=0;
		for (int col=0; col<COL; col++){
			for (int row=0; row<ROW; row++){
				if (layout[row][col] == 1) {
					r++;//counts every time a red disk is found
				}
				else if (layout[row][col] == -1) {
					b++;//counts every time a blue disk is found
				}
			}
		}
		//checks if the counts are equal
		if (r == b) {
			return true;
		}
		return false;
	}
}
