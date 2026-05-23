public class Main {
    public static void main(String[] args) {
        Graph testGraph = new Graph(8);
        testGraph.addEdge(0, 1,4);
        testGraph.addEdge(0, 2,6);
        testGraph.addEdge(0, 3,8);
        testGraph.addEdge(0, 4,9);
        testGraph.addEdge(1, 5,3);
        testGraph.addEdge(1, 6,4);
        testGraph.addEdge(2, 7,1);
        testGraph.printGraph();

        System.out.println(" Graph Structure with Weights ");
        testGraph.printGraph();
        System.out.println();

        System.out.println(" vRunning Dijkstra's Algorithm ");
        testGraph.dijkstra(0);
        System.out.println();
        System.out.println("Original");
        Experiment experiment = new Experiment();
        experiment.runMultipleTests();

    }
}