import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraytoListANDListtoArray {

		// TODO Auto-generated constructor stub
		public static void main(String[] args) {
	        // Create an array
	        String[] array = {"apple", "banana", "cherry"};

	        // Convert array to list
	        List<String> list = Arrays.asList(array);
	        
	        // Convert array to list java8
	        List<String> lis1 = Arrays.stream(array).collect(Collectors.toList());

	        // Print the list
	        System.out.println(list);
	        System.out.println(lis1);
	        System.out.println("===================================List to array==================");
	        List<String> list11 = new ArrayList<>();
	        list11.add("apple");
	        list11.add("banana");
	        list11.add("cherry");

	        // Convert ArrayList to array
	        String[] array1 = list11.toArray(new String[0]);
	     // Convert ArrayList to array java8
	        String[] array11 = list11.stream().toArray(String[]::new);

	        // Print the array
	        System.out.println(Arrays.toString(array1));
	        System.out.println(Arrays.toString(array11));
	    }
	}