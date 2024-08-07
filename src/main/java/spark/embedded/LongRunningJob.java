package spark.embedded;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class LongRunningJob {
    public static void main(String[] args) {
        // Configure Spark
        SparkConf conf = new SparkConf()
                .setAppName("Long Running Job")
                .setMaster("local[*]")  // Change this to your cluster's master URL if needed
                .set("spark.eventLog.enabled", "true")
                .set("spark.eventLog.dir", "file:///tmp/spark-events")
                .set("spark.history.fs.logDirectory", "file:///tmp/spark-events");

        // Initialize JavaSparkContext
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Sample data
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create an RDD
        JavaRDD<Integer> rdd = sc.parallelize(data);

        // Simulate long-running job
        for (int i = 0; i < 100; i++) {
            JavaPairRDD<Integer, Integer> pairs = rdd.mapToPair(num -> new Tuple2<>(num, num * num));
            JavaPairRDD<Integer, Integer> counts = pairs.reduceByKey((a, b) -> a + b);
            counts.foreach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));

            try {
                Thread.sleep(10000); // Sleep for 10 seconds to simulate a long-running job
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Stop the context
        sc.stop();
    }
}
