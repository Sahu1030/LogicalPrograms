import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStream {

	public static void main(String[] args) {
		
		int[] array1 = {1, 2, 3, 4, 5};
		Stream<Integer> stream1 = Arrays.stream(array1).boxed();
		stream1.forEach(System.out::println);
		
		int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Stream<int[]> stream = Arrays.stream(array);
		System.out.println("Overlapped pairs: " + stream.map(Arrays::toString).collect(Collectors.joining(", ")));
		
		Stream<Integer> elementStream = Arrays.stream(array).flatMapToInt(IntStream::of).boxed();
		elementStream.forEach(System.out::println);
		
		Stream<String> stream11 = Stream.of("apple", "banana", "cherry");
		String[] array11 = stream.toArray(String[]::new);
		IntStream intStream = IntStream.of(1, 2, 3, 4);
		int[] intArray = intStream.toArray();  // returns primitive int[]

	}

}
