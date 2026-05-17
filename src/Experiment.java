import java.util.Random;

public class Experiment {

    private final int[] sizes = {10, 30, 100};

    public void runMultipleTests() {
        Random random = new Random();

        for (int size : sizes) {
            System.out.println("TESTING GRAPH SIZE: " + size + " VERTICES");

            Graph g = new Graph(size);

            for (int i = 0; i < size; i++) {
                int edgesToCreate = random.nextInt(2) + 1;
                for (int j = 0; j < edgesToCreate; j++) {
                    int target = random.nextInt(size);
                    if (i != target) {
                        g.addEdge(i, target);
                    }
                }
            }

            if (size == 10) {
                System.out.println(" Graph Structure ");
                g.printGraph();
                System.out.println();
            }

            runTraversals(g, size);
        }

        printResults();
    }

    public void runTraversals(Graph g, int size) {
        if (size == 10) {
            System.out.print("BFS Traversal Order: ");
        }
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        if (size == 10) {
            System.out.println();
        }
        long bfsDuration = endBfs - startBfs;

        if (size == 10) {
            System.out.print("DFS Traversal Order: ");
        }
        long startDfs = System.nanoTime();
        g.dfs();
        long endDfs = System.nanoTime();
        if (size == 10) {
            System.out.println();
        }
        long dfsDuration = endDfs - startDfs;

        System.out.println();
        System.out.println("BFS Execution Time : " + bfsDuration + " ns");
        System.out.println("DFS Execution Time : " + dfsDuration + " ns");
    }

    public void printResults() {
        System.out.println("\n Benchmark Analysis Complete ");
    }
}