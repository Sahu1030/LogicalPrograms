import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Arraytoset {

	public Arraytoset() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Create an array
		String[] array = { "apple", "banana", "cherry", "apple" };

		// Convert array to set
		Set<String> set = new HashSet<>(Arrays.asList(array));

		// Print the set
		System.out.println(set);
		System.out.println("==============JAVA8===================");

		// Convert array to set
		Set<String> set1 = Arrays.stream(array).collect(Collectors.toSet());

		// Print the set
		System.out.println(set1);
		List<String> list1 = Arrays.asList("apple", "banana", "apple", "orange", "banana");

		Set<String> seen = new HashSet<>();
		Set<String> duplicates = new HashSet<>();

		for (String item : list1) {

			if (!seen.add(item)) {
				duplicates.add(item);
			}

//			if(seen.contains(item)) { duplicates.add(item); } else { seen.add(item); }

		}

		System.out.println("Original: " + seen); // Output: [banana, apple]
		System.out.println("Duplicates: " + duplicates); // Output: [banana, apple]
	}
}
