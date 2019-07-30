package ModifiedKruskalAlgorithm;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Graph {

    private int weight;

    HashMap<Integer, Vertex> vertex;                         // Map names to vertices
    HashSet<Edge> edges;                                    // Collection of all edges
    HashMap<Vertex, HashSet<Edge>> adjList;                 // Adjacency List of Graph
    HashSet<Edge> cmst;
    HashSet<Vertex> visited;

    public Graph(){
        this.adjList = new HashMap<Vertex, HashSet<Edge>>();
        this.vertex = new HashMap<Integer, Vertex>();
        this.edges = new HashSet<Edge>();
        this.cmst = new HashSet<Edge>();
        this.visited = new HashSet<Vertex>();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * This method is used to accept user input vertices.
     * */
    public void getVertices(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            Vertex inpV = new Vertex(num);
            this.vertex.put(num, inpV);
            this.adjList.put(inpV, new HashSet<Edge>());
        }
        System.out.println(this.vertex);
    }

    /**
     * This method is used to accept user input edges and edge-weights.
     * */
    public void getEdges(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices");
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            int f = sc.nextInt();
            int t = sc.nextInt();
            int c = sc.nextInt();
            Edge e = new Edge(this.vertex.get(f),this.vertex.get(t),c);
            this.edges.add(e);
            HashSet<Edge> tmpEdge = this.adjList.get(this.vertex.get(f));
            tmpEdge.add(e);
            this.adjList.put(this.vertex.get(f),tmpEdge);
            tmpEdge = this.adjList.get(this.vertex.get(t));
            tmpEdge.add(e);
            this.adjList.put(this.vertex.get(t),tmpEdge);
        }
    }


    /**
     * This method is used to Print the adjacency list of the graph.
     * */
    public void printGraph(){
        for(Vertex v : this.adjList.keySet()){
            System.out.println(v+" : "+this.adjList.get(v));
        }
    }
}



/*

6
0
1
2
3
4
5

15
0 2 6
0 1 5
0 4 12
0 5 15
0 3 9
2 1 4
2 5 12
2 4 5
1 5 10
1 4 8
1 3 3
5 4 7
5 3 6
4 3 6
2 3 8

* */