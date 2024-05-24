package spark.embedded;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.time.Duration;

public class EmbeddedSparkExampleTest {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Spark session
        SparkSession spark = EmbeddedSparkUtil.getTestSession();

        // Interact with Spark
        // Example: Create a DataFrame from a collection and perform operations
        Dataset<Row> df = spark.createDataFrame(
                java.util.Arrays.asList(
                        new Person("John", 30),
                        new Person("Jane", 25),
                        new Person("Doe", 40)
                ),
                Person.class
        );

        df.show();

        df.createOrReplaceTempView("people");

        // Run an SQL query
        Dataset<Row> sqlDF = spark.sql("SELECT name, age FROM people WHERE age > 30");
        sqlDF.show();

        Object testResult = sqlDF.collect();


//        Thread.sleep(Duration.ofMinutes(20));

        // Stop the Spark session
        spark.stop();
    }

    // Define a simple JavaBean class
    public static class Person implements java.io.Serializable {
        private String name;
        private int age;

        // Default constructor is required for Spark
        public Person() {}

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
