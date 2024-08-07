package spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.api.java.JavaDStream;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Similar to `SimpleSparkStreaming` but with 30 seconds aggregation windows.
 */
public class WindowedAggregation {
    public static void main(String[] args) throws InterruptedException {
        // Create a local StreamingContext with two working threads and a batch interval of 1 second
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("WindowedAggregation");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        // Create a DStream that will connect to hostname:port
        JavaDStream<String> lines = jssc.socketTextStream("localhost", 9999);

        // Split each line into words
        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());

        // Map each word to a pair (word, 1)
        JavaPairDStream<String, Integer> pairs = words.mapToPair(word -> new Tuple2<>(word, 1));

        // Windowed reduceByKey operation
        JavaPairDStream<String, Integer> windowedWordCounts = pairs.reduceByKeyAndWindow(
                (a, b) -> a + b,        // Reduce function
                Durations.seconds(30),  // Window duration
                Durations.seconds(10)   // Sliding interval
        );

        // Print the word counts
        windowedWordCounts.print();

        // Start the computation
        jssc.start();
        jssc.awaitTermination();
    }
}