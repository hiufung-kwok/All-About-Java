package spark;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.apache.spark.streaming.kafka010.LocationStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SparkStreamingExample {
    public static void main(String[] args) throws InterruptedException {
        // Create Spark configuration
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("SparkStreamingExample");

        // Create streaming context with a 1-second batch size
        JavaStreamingContext streamingContext = new JavaStreamingContext(conf, Durations.seconds(1));

        // Define Kafka parameters
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, "spark-streaming-example-group");
        kafkaParams.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        kafkaParams.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        // Define the topic to consume
        String topic = "logs";

        // Create a direct Kafka stream
        JavaInputDStream<org.apache.kafka.clients.consumer.ConsumerRecord<String, String>> stream =
                KafkaUtils.createDirectStream(
                        streamingContext,
                        LocationStrategies.PreferConsistent(),
                        ConsumerStrategies.Subscribe(Collections.singleton(topic), kafkaParams)
                );

        // Process the stream
        stream.map(record -> record.value())
                .foreachRDD(rdd -> {
                    rdd.foreach(record -> {
                        // Here, you can implement your logic for processing each record
                        System.out.println("Received log: " + record);
                    });
                });

        // Start the streaming context and await termination
        streamingContext.start();
        streamingContext.awaitTermination();
    }
}

