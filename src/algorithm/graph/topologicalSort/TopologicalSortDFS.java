package algorithm.graph.topologicalSort;

import java.util.*;

public class TopologicalSortDFS {

    // Function to perform topological sort using DFS
    private static void topologicalSortUtil(char vertex, Map<Character, List<Character>> graph,
                                            Set<Character> visited, Stack<Character> stack) {
        // Mark the current vertex as visited
        System.out.println("Visiting: " + vertex);
        visited.add(vertex);

        // Recur for all adjacent vertices
        for (Character neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                topologicalSortUtil(neighbor, graph, visited, stack);
            }
        }

        // Push the current vertex to the stack
        System.out.println("Pushing stack: " + vertex);
        stack.push(vertex);
    }

    // Function to perform topological sort for the entire graph
    public static List<Character> topologicalSort(Map<Character, List<Character>> graph) {
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();

        // Call the recursive helper function for all vertices
        for (Character vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortUtil(vertex, graph, visited, stack);
            }
        }

        // Pop elements from stack to get the topological order
        List<Character> topologicalOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        // Example: Tasks A, B, C, D with dependencies A → B, A → C, B → D, C → D
        Map<Character, List<Character>> graph = new TreeMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('D'));
        graph.put('C', Arrays.asList('D', 'E'));
        graph.put('D', Arrays.asList('H'));
        graph.put('E', Arrays.asList('G'));
        graph.put('0', Arrays.asList('A'));
        graph.put('G', new ArrayList<>());
        graph.put('H', new ArrayList<>());



        List<Character> topologicalOrder = topologicalSort(graph);
        System.out.println("Topological Sort: " + topologicalOrder);
    }
}
