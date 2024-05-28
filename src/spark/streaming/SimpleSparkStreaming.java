package spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import scala.Tuple2;

import java.util.Arrays;

/**
 * A basic example from Spark site: https://spark.apache.org/docs/latest/streaming-programming-guide.html#note
 * which print each distinct word entered the socket on 1 second interval and list out the associated frequency.
 */
public class SimpleSparkStreaming {
    public static void main(String[] args) throws InterruptedException {
        // Create a local StreamingContext with two working threads and a batch interval of 1 second
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("SimpleSparkStreaming");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
        

        // Create a DStream that will connect to hostname:port
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);

        // Split each line into words
        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());

        // Count each word in each batch
        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));

        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((i1, i2) -> i1 + i2);

        // Print the first ten elements of each RDD generated in this DStream to the console
        wordCounts.print();

        // Start the computation
        jssc.start();
        jssc.awaitTermination();
    }
}