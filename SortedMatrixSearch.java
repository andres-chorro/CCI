
public class SortedMatrixSearch {
	private int[][] matrix;
	
	public SortedMatrixSearch(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public Coord search(int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new Coord(-1, -1);
		}
		Coord topLeft = new Coord(0, 0); 
		Coord bottomRight = new Coord(matrix.length, matrix[0].length);
		return searchHelper(target, topLeft, bottomRight);
	}
	
	private Coord searchHelper(int target, Coord topLeft, Coord bottomRight) {
		Coord mid = new Coord((topLeft.row+bottomRight.row) / 2, (topLeft.col+bottomRight.col) / 2);
		if (target == get(mid)) {
			return mid;
		}
		return new Coord(-1, -1);
	}
	
	private int get(Coord c) {
		return matrix[c.row][c.col];
	}
}

class Coord {
	int row;
	int col;
	
	Coord(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
