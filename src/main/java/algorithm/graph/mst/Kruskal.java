package algorithm.graph.mst;

import java.util.*;

class Edge implements Comparable<Edge> {
    int source;
    int target;
    int weight;

    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        System.out.println("Looking up for edge " + u + ", with result: " + parent[u]);
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class Kruskal {

    public static List<Edge> kruskal(List<Edge> edges, int n) {
        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(n);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            System.out.println("Processing edge: " + edge.source + " -> " + edge.target);
            int u = edge.source;
            int v = edge.target;

            if (ds.find(u) != ds.find(v)) {
                System.out.println("Keep edge: " + edge.source + " -> " + edge.target);
                mst.add(edge);
                ds.union(u, v);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int n = 6; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Add edges to the graph
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 9));
        edges.add(new Edge(2, 3, 1));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(4, 5, 2));

        List<Edge> mst = kruskal(edges, n);
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.target + " : " + edge.weight);
        }
    }
}
