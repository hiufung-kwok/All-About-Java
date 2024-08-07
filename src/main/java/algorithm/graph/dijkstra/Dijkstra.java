package algorithm.graph.dijkstra;

import java.util.*;

class Edge {
    int source;
    int target;
    int weight;

    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int id;
    int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Dijkstra {

    public static int[] dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node u = priorityQueue.poll();
            System.out.println("Polling vertices: " + u.id);
            int uId = u.id;
            int uDist = u.distance;

            for (Edge edge : graph.get(uId)) {
                int v = edge.target;
                System.out.println("Fetching edge for: " + uId + " -> " + v);
                int newDist = uDist + edge.weight;
                if (newDist < dist[v]) {
                    System.out.println("Setting new distance " + (v) + " with value " + newDist);
                    dist[v] = newDist;
                    priorityQueue.add(new Node(v, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(1).add(new Edge(1, 2, 5));
        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(3).add(new Edge(3, 4, 4));
        graph.get(4).add(new Edge(4, 5, 2));
        graph.get(0).add(new Edge(0, 2, 15));
        graph.get(1).add(new Edge(1, 3, 9));
        graph.get(2).add(new Edge(2, 4, 7));

        int source = 2;
        int[] dist = dijkstra(graph, source);
        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(dist));
    }
}
