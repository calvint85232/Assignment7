//#5
import java.util.*;

public class DirectedWeightedGraph {

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private Map<Integer, List<Edge>> graph = new HashMap<>();

    public void addEdge(int from, int to, int weight) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Edge(to, weight));
    }

    public void findAllPaths(int u, int w) {
        List<Integer> path = new ArrayList<>();
        path.add(u);
        findAllPathsUtil(u, w, path, 0);
    }

    private void findAllPathsUtil(int current, int destination, List<Integer> path, int depth) {
        if (depth == 5) {
            if (current == destination) {
                System.out.println(path);
            }
            return;
        }

        if (!graph.containsKey(current)) return;

        for (Edge edge : graph.get(current)) {
            if (!path.contains(edge.to)) {
                path.add(edge.to);
                findAllPathsUtil(edge.to, destination, path, depth + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        // Example edges (from, to, weight)
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 2);

        int u = 0; // starting vertex
        int w = 4; // ending vertex

        System.out.println("All paths from " + u + " to " + w + " with length 5:");
        graph.findAllPaths(u, w);
    }
}
