package algorithm.binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleDetection {

    public static boolean hasCycle(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited, int parent) {
        visited.add(node);  // Mark current node as visited

        // Iterate through neighbors
        for (int neighbor : graph.getOrDefault(node, new HashSet<>())) {
            if (!visited.contains(neighbor)) {  // Unvisited neighbor, explore further
                if (hasCycle(graph, neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {  // Back edge detected (excluding parent)
                return true;
            }
        }

        return false;  // No cycle found in this branch
    }

    public static boolean isCyclic(Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {  // Start DFS from unvisited nodes
                if (hasCycle(graph, node, visited, -1)) {  // -1 represents no parent
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample graph (modify as needed)
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(0, Set.of(1, 2));
        graph.put(1, Set.of(3));
        graph.put(2, Set.of(0, 3));
        graph.put(3, new HashSet<>()); // Empty set for node 3

        if (isCyclic(graph)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
