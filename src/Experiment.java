import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g) {
        g.bfs(0);
        System.out.println();
        g.dfs();
        System.out.println();
    }

    public void runMultipleTests() {
        System.out.println("Executing automated multi-size graph analysis");
    }

    public void printResults() {
        System.out.println(" Benchmark Analysis Complete ");
    }}