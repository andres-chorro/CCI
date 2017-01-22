
public class SparceSearch {
	public static int sparceBinarySearch(String target, String[] sortedArray) {
		int leftIndex = 0;
		int rightIndex = sortedArray.length - 1;
		while (leftIndex < rightIndex) {
			int middleIndex = (rightIndex+leftIndex) / 2;
			int nonEmptyMiddleIndex = getNearestNonEmptyIndex(middleIndex, sortedArray);
			String middleString = sortedArray[nonEmptyMiddleIndex];
			if (middleString.equals(target)) {
				return nonEmptyMiddleIndex;
			} else if (target.compareTo(middleString) < 0) {
				rightIndex = nonEmptyMiddleIndex;
			} else
				leftIndex = nonEmptyMiddleIndex;
		}
		return -1;
	}
	
	private static int getNearestNonEmptyIndex(int index, String[] sortedArray) {
		String currentString = sortedArray[index];
		int currentDistance = 1;
		while (currentString.equals("")) {
			int leftIndex = index - currentDistance;
			if (leftIndex >= 0 && !sortedArray[leftIndex].equals("")) {
				return leftIndex;
			}
			int rightIndex = index + currentDistance;
			if (rightIndex <= sortedArray.length - 1 && !sortedArray[rightIndex].equals("")) {
				return rightIndex;
			}
			if (leftIndex < 0 && rightIndex >= sortedArray.length) {
				break;
			}
			currentDistance++;
		}
		return -1;
	}
}
