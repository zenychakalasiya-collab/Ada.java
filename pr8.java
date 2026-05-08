import java.util.Scanner;
import java.util.Arrays;

class Edge implements Comparable<Edge> {

    int src, dest, weight;

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class KruskalSmall {

    static int parent[];

    // Find parent
    static int find(int i) {

        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }

    // Union operation
    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Edge edges[] = new Edge[E];

        System.out.println("Enter source, destination and weight:");

        for (int i = 0; i < E; i++) {

            edges[i] = new Edge();

            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        // Sort edges
        Arrays.sort(edges);

        parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int total = 0;

        System.out.println("\nEdge \tWeight");

        for (int i = 0; i < E; i++) {

            int x = find(edges[i].src);
            int y = find(edges[i].dest);

            // Avoid cycle
            if (x != y) {

                System.out.println(edges[i].src + " - " +
                                   edges[i].dest + "\t" +
                                   edges[i].weight);

                total += edges[i].weight;

                union(x, y);
            }
        }

        System.out.println("Total Cost = " + total);

        sc.close();
    }
}
