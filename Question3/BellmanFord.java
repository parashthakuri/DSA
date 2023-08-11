package Question3;

import java.util.Arrays;

public class BellmanFord {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int[] bellmanFord(int V, int src, Edge[] edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains negative cycle");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int src = 0;
        Edge[] edges = {
                new Edge(0, 1, 1),
                new Edge(0, 2, 4),
                new Edge(1, 2, -3),
                new Edge(1, 3, 2),
                new Edge(1, 4, 2),
                new Edge(3, 2, 5),
                new Edge(3, 1, 1),
                new Edge(4, 3, -3)
        };

        int[] dist = bellmanFord(V, src, edges);

        if (dist != null) {
            System.out.println("Shortest distances from vertex " + src + " to all other vertices:");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
        }
    }
}