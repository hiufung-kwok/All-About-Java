package thirdParty.graph;

import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.*;

import java.io.File;

import static org.neo4j.configuration.GraphDatabaseSettings.DEFAULT_DATABASE_NAME;

public class EmbeddedNeo4jExample {
    private static final File databaseDirectory = new File("target/neo4j-embedded-db");

    public static void main(String[] args) {
        // Start the embedded Neo4j database
        DatabaseManagementService managementService = new DatabaseManagementServiceBuilder(databaseDirectory.toPath()).build();
        GraphDatabaseService graphDb = managementService.database( DEFAULT_DATABASE_NAME );
        registerShutdownHook( managementService );

        // Perform some interactions with the database
        try (Transaction tx = graphDb.beginTx()) {
            // Create a node
            Node firstNode = tx.createNode(Label.label("Person"));
            firstNode.setProperty("name", "John Doe");

            // Create another node
            Node secondNode = tx.createNode(Label.label("Person"));
            secondNode.setProperty("name", "Jane Smith");

            // Create a relationship between the nodes
            Relationship relationship = firstNode.createRelationshipTo(secondNode, RelationshipType.withName("FRIENDS"));
            relationship.setProperty("since", "2024");

            // Print the node properties to verify
            System.out.println("Created nodes and relationship:");
            System.out.println("Node 1: " + firstNode.getProperty("name"));
            System.out.println("Node 2: " + secondNode.getProperty("name"));
            System.out.println("Relationship: " + relationship.getType().name() + " since " + relationship.getProperty("since"));

            // Commit the transaction
            tx.commit();
        }


    }

    private static void registerShutdownHook( final DatabaseManagementService managementService )
    {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                managementService.shutdown();
            }
        } );
    }
}