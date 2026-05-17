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

        Experiment experiment = new Experiment();
        experiment.runMultipleTests();
    }
}