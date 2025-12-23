import java.util.HashSet;

public class FindDuplicateFromArray {

	public FindDuplicateFromArray() {
	}
		public static void main(String[] args) {
	        int[] array = {1, 2, 3, 4, 2, 7, 8, 8, 3};

	        HashSet<Integer> set = new HashSet<>();

	        for (int i : array) {
	            if (!set.add(i)) {
	                System.out.println("Duplicate found: " + i);
	            } else {
	                set.add(i);
	            }
	        }
	        System.out.println(set);

	    }
	}
