package spark.embedded;

import org.apache.spark.sql.SparkSession;

public class EmbeddedSparkUtil {

    public static SparkSession getTestSession () {
        return SparkSession.builder()
                .appName("Embedded Spark Example")
                .master("local[*]")
                .config("spark.eventLog.enabled", "true")
                .config("spark.eventLog.dir", "file:///tmp/spark-events")  // Change to HDFS or other appropriate directory
                .config("spark.history.fs.logDirectory", "file:///tmp/spark-events")  // Same directory as above
                .getOrCreate();

    }
}
