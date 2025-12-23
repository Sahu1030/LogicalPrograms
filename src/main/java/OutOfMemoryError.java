import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class OutOfMemoryError {

	 public static void main(String[] args) {
	        // Create a large collection
	        List<String> list = new ArrayList<>();
	        for (int i = 0; i < 1000000; i++) {
	            list.add("Item " + i);
	        }
	       // Record the start time
	        long startTime = System.currentTimeMillis();
	        
//	        for (String item : list) {
//                System.out.println(item);
//            }

	        // Process the collection in chunks
//	        int chunkSize = 1000;
//	        ListIterator<String> iterator = list.listIterator();
//	        while (iterator.hasNext()) {
//	            List<String> chunk = new ArrayList<>();
//	            for (int i = 0; i < chunkSize && iterator.hasNext(); i++) {
//	                chunk.add(iterator.next());
//	            }
//	            // Process the chunk
//	            System.out.println("Processing chunk");
//	            for (String item : chunk) {
//	                System.out.println(item);
//	            }
//	        }
//	        
	     // Process the collection in chunks in JAVA8
	        list.stream()
	                .collect(Collectors.groupingByConcurrent(item -> item.hashCode() % 100))
	                .forEach((key, value) -> {
	                    // Process the chunk
	                    System.out.println("Processing chunk " + key);
	                    value.forEach(System.out::println);
	                });
//	        
	     // Process the collection in parallel
	       
//	        Spliterator<String> spliterator = list.spliterator();
//	        while (spliterator.tryAdvance(item -> {
//	            // Process the item
//	            System.out.println(item);
//	        }));
//	        
	        long endTime = System.currentTimeMillis();

	        // Calculate the elapsed time
	        long elapsedTime = endTime - startTime;
	        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");

	    }
	}