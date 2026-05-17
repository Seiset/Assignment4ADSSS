import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graph testGraph = new Graph(8);

        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);
        testGraph.addEdge(0, 3);
        testGraph.addEdge(0, 4);
        testGraph.addEdge(1, 5);
        testGraph.addEdge(1, 6);
        testGraph.addEdge(2, 7);

        testGraph.printGraph();

        int[] sizes = {10, 30, 100};
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
    }
}