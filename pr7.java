import java.util.Scanner;

public class PrimsAlgorithm {

    static final int V = 5;

    // Function to find vertex with minimum key value
    int minKey(int key[], boolean mstSet[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {

            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to print MST
    void printMST(int parent[], int graph[][]) {

        int totalCost = 0;

        System.out.println("Edge \tWeight");

        for (int i = 1; i < V; i++) {

            System.out.println(parent[i] + " - " + i + "\t" +
                               graph[i][parent[i]]);

            totalCost += graph[i][parent[i]];
        }

        System.out.println("Total Cost of MST = " + totalCost);
    }

    // Prim's Algorithm
    void primMST(int graph[][]) {

        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        // Initialize values
        for (int i = 0; i < V; i++) {

            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // First vertex as root
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 &&
                    mstSet[v] == false &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {

        PrimsAlgorithm obj = new PrimsAlgorithm();

        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        System.out.println("Minimum Spanning Tree using Prim's Algorithm:\n");

        obj.primMST(graph);
    }
}
