package thirdParty.redis;

import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;

import java.io.IOException;

public class EmbeddedRedisExample {

    public static void main(String[] args) throws IOException {
        RedisServer redisServer = null;
        try {
            // Start Embedded Redis server
            redisServer = new RedisServer(6379);
            redisServer.start();

            // Create a Jedis instance to interact with the Redis server
            try (Jedis jedis = new Jedis("localhost", 6379)) {
                // Set a key-value pair in Redis
                jedis.set("exampleKey", "exampleValue");

                // Retrieve the value associated with the key
                String value = jedis.get("exampleKey");
                System.out.println("Retrieved value: " + value);

                // Check if the key exists
                boolean exists = jedis.exists("exampleKey");
                System.out.println("Key exists: " + exists);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Stop Embedded Redis server
            if (redisServer != null) {
                redisServer.stop();
            }
        }
    }
}