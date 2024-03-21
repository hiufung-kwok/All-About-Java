package concurrent.concurrency.future.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;



/**
 * This demo can be used to demonstrate how future can be used in actual application.
 * In this example, getPrice( ) have choice to return future<Double> instead of normal 
 * Double, so consumer have choice to work on others first and come back later.
 * 
 * Also two patterns of parallelism can be found. First one is parallel stream, which 
 * multiple thread on client side is used to retrieve result. The result list only be 
 * acquired when all thread have answer from their end-point which is Shop class in this example. 
 * 
 * The other approach would be having the implementation over end-point which is future,
 * in this situation, sever would return a reference call future<Double> which is the token 
 * to retireve the final result, as the result is not available yet upon request time.
 * So client sequentially launch other task and only check the result when it finish all the
 * remaining. 
 */
public class Customer {
	
	static List<Shop>  shops = Arrays.asList(new Shop("BestPrice"),
									new Shop("L&&R"),
									new Shop("Target"),
									new Shop("KMart"),
									new Shop("Maccas") );
	
	
	
	/*
	 * Following method ( ) would check the price with each store object one by one and 
	 * return the result only when all done. 
	 */	
	private static List<String> findPrice (String product) {

		return shops.stream()
					.map(shop -> String.valueOf(shop.getPrice(product)))
					.collect( Collectors.toList() );
	}
	
	// (Parallel on Client side <ParallelStream> )
	private static List<String> findPriceParallel (String product) {

		return shops.parallelStream()
					.map(shop -> String.valueOf(shop.getPrice(product)))
					.collect( Collectors.toList() );
	}
	
	/* (Parallel on Server side <Future> )
	 * As future get method is a blocking call, processing need to be divided into two parts.
	 * First call getPriceAsync by stream, as its not parallel stream. Get prcie query would launch one by one.
	 * All the first part, a list of future<Double> would be collected and now can perform get( ) 
	 * to retrieve the final result. 
	 *
	 */
	private static List<String> findPriceAsync (String product) {
		
		List<Future<Double>> futures = shops.stream()
				.map(shop -> shop.getPriceAsyncLambda(product) )
				.collect( Collectors.toList() );
		
		
		return futures.stream()
						.map(future -> {
							try {
								return String.valueOf( (Double) future.get() );
							} catch (Exception  e) {
								return " ";
							}
						})
						.collect( Collectors.toList());
	}
	
	
	private static void main(String[] args) {
		
		
		//Find single store quote with either sync / async call
		long start, duration;
		
		//Multiple store quote (sequential)
		start = System.nanoTime();
		System.out.println(findPrice("IPhone"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + "msecs");
		
		//Parallel in client side (Parallel Stream)
		start = System.nanoTime();
		System.out.println(findPriceParallel("IPhone"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + "msecs");
		
		//Parallel in Server side (Future)
		start = System.nanoTime();
		System.out.println(findPriceAsync("IPhone"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + "msecs");
		
		

	}
	


}
