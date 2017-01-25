
public class FindDuplicates {
	
	public static void main(String[] args) {
		short[] list = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7, 7};
		System.out.println(getDuplicates(list));
		short[] list2 = {1, 2, 3, 4, 5};
		System.out.println(getDuplicates(list2));
		short[] emptyList = {};
		System.out.println(getDuplicates(emptyList));
	}
	
	public static String getDuplicates(short[] list) {
		StringBuilder sb = new StringBuilder();
		int expected = 1;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == expected) {
				expected++;
			} else {
				sb.append(list[i] + " ");
			}
		}
		return sb.toString();
	}
}
