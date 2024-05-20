package algorithm.graph.topologicalSort;

import java.util.*;

public class TopologicalSort {
    // Function to perform topological sort using Kahn's Algorithm
    public static List<Character> topologicalSort(Map<Character, List<Character>> graph) {
        Map<Character, Integer> inDegree = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        List<Character> topologicalOrder = new ArrayList<>();

        // Initialize in-degrees of all vertices
        for (Character vertex : graph.keySet()) {
            inDegree.put(vertex, 0);
        }
        for (Character vertex : graph.keySet()) {
            for (Character neighbor : graph.get(vertex)) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // Enqueue all vertices with in-degree of 0
        for (Character vertex : inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                queue.add(vertex);
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            Character vertex = queue.poll();
            topologicalOrder.add(vertex);

            for (Character neighbor : graph.get(vertex)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if topological sort is possible (no cycle)
        if (topologicalOrder.size() != graph.size()) {
            throw new IllegalArgumentException("Cycle detected, topological sort not possible.");
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        // Example: Tasks A, B, C, D with dependencies A → B, A → C, B → D, C → D
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('D'));
        graph.put('C', Arrays.asList('D'));
        graph.put('D', new ArrayList<>());

        List<Character> topologicalOrder = topologicalSort(graph);
        System.out.println("Topological Sort: " + topologicalOrder);
    }
}
