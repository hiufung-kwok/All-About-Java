package spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import java.util.concurrent.TimeoutException;

public class StructuredStreamingExample {
    public static void main(String[] args) throws StreamingQueryException, TimeoutException {
        // Create Spark session
        SparkSession spark = SparkSession.builder()
                .appName("StructuredStreamingExample")
                .master("local[*]")
                .getOrCreate();

        // Read data from Kafka
        Dataset<Row> kafkaStream = spark.readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "logs")
                .load();

        // Select the value column and cast it to string
        Dataset<Row> logs = kafkaStream.selectExpr("CAST(value AS STRING)");

        // Perform some transformations (for example, filtering logs containing "ERROR")
        Dataset<Row> errorLogs = logs.filter(logs.col("value").contains("ERROR"));

        // Start the streaming query and print the results to the console
        StreamingQuery query = errorLogs.writeStream()
                .outputMode("append")
                .format("console")
                .start();

        // Await termination of the query
        query.awaitTermination();
    }
}
