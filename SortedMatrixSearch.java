
public class SortedMatrixSearch {
	private int[][] matrix;
	private static final Coord NOT_FOUND = new Coord(-1, -1);
	
	public SortedMatrixSearch(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public Coord search(int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return NOT_FOUND;
		}
		Coord topLeft = new Coord(0, 0); 
		Coord bottomRight = new Coord(matrix.length - 1, matrix[0].length - 1);
		return searchHelper(target, topLeft, bottomRight);
	}
	
	private Coord searchHelper(int target, Coord topLeft, Coord bottomRight) {
		if (topLeft.equals(bottomRight)) {
			return get(topLeft) == target ? topLeft : NOT_FOUND;
		}
		
		Coord mid = new Coord((topLeft.row+bottomRight.row) / 2, (topLeft.col+bottomRight.col) / 2);
		if (target == get(mid)) {
			return mid;
		}
		if (target < get(mid)) {
			Coord topBlockResult = searchHelper(target, topLeft, new Coord(mid.row-1, bottomRight.col));
			if (topBlockResult != NOT_FOUND)
				return topBlockResult;
			Coord leftBlockResult = searchHelper(target, new Coord(mid.row, topLeft.col), new Coord(bottomRight.row, mid.col-1));
			if (leftBlockResult != NOT_FOUND)
				return leftBlockResult;
		} else {
			Coord bottomBlockResult = searchHelper(target, new Coord(mid.row+1, topLeft.col), bottomRight);
			if (bottomBlockResult != NOT_FOUND)
				return bottomBlockResult;
			Coord rightBlockResult = searchHelper(target, new Coord(topLeft.row, mid.col+1), new Coord(mid.row, bottomRight.col));
			if (rightBlockResult != NOT_FOUND)
				return rightBlockResult;
		}
		return NOT_FOUND;
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
	
	@Override
	public boolean equals(Object obj) {
		Coord other = (Coord) obj;
		return row == other.row && col == other.col;
	};
	
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
}
