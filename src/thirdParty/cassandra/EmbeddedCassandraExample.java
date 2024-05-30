package thirdParty.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;


import java.net.InetSocketAddress;
import java.nio.file.Paths;

public class EmbeddedCassandraExample {

    public static void main(String[] args) {
        try {
            // Start Embedded Cassandra
            EmbeddedCassandraServerHelper.startEmbeddedCassandra();

            // Connect to Cassandra
            try (CqlSession session = CqlSession.builder()
                    .addContactPoint(new InetSocketAddress("127.0.0.1", 9042))
                    .withLocalDatacenter("datacenter1")
                    .build()) {

                // Create Keyspace
                session.execute("CREATE KEYSPACE IF NOT EXISTS testKeyspace WITH replication "
                        + "= {'class':'SimpleStrategy', 'replication_factor':1};");

                // Use Keyspace
                session.execute("USE testKeyspace;");

                // Create Table
                session.execute("CREATE TABLE IF NOT EXISTS users ("
                        + "id UUID PRIMARY KEY, "
                        + "name text, "
                        + "age int);");

                // Insert Data
                session.execute("INSERT INTO users (id, name, age) VALUES (uuid(), 'Alice', 30);");
                session.execute("INSERT INTO users (id, name, age) VALUES (uuid(), 'Bob', 25);");

                // Query Data
                ResultSet resultSet = session.execute("SELECT * FROM users;");
                resultSet.forEach(row -> System.out.println(
                        "ID: " + row.getUuid("id") +
                                ", Name: " + row.getString("name") +
                                ", Age: " + row.getInt("age")));
            }

            // Stop Embedded Cassandra
            EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}