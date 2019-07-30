package ModifiedKruskalAlgorithm;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.getVertices();
        graph.getEdges();
        graph.setWeight(3);
        ModifiedKruskalAlgorithm mka = new ModifiedKruskalAlgorithm(graph);
        mka.modifiedKruskal();
    }
}
