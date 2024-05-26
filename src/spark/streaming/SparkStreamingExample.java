package spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import scala.Tuple2;
import java.util.Arrays;

public class SparkStreamingExample {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("Spark Streaming Example");
        JavaStreamingContext ssc = new JavaStreamingContext(conf, new Duration(1000));

        JavaReceiverInputDStream<String> lines = ssc.socketTextStream("localhost", 9999);
        JavaPairDStream<String, Integer> wordCounts = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((i1, i2) -> i1 + i2);
        wordCounts.print();

        ssc.start();
        ssc.awaitTermination();
    }
}