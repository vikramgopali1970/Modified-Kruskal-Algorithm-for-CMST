package ModifiedKruskalAlgorithm;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ModifiedKruskalAlgorithm {

    Graph graph;

    public ModifiedKruskalAlgorithm(Graph graph){
        this.graph = graph;
    }

    public void modifiedKruskal(){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost,o2.cost);
            }
        });
        HashSet<Edge> edges = new HashSet<Edge>(this.graph.edges);
        for(Edge e : edges){
            pq.offer(e);
        }
        int minCost = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            Vertex p1 = this.findParent(e.from);
            Vertex p2 = this.findParent(e.to);
            if(!p1.equals(p2) && this.graph.cmst.size() < this.graph.vertex.size()-1){
                if(this.union(e)){
                    minCost += e.cost;
                    this.graph.cmst.add(e);
                    this.graph.visited.add(e.from);
                    this.graph.visited.add(e.to);
                }
            }else{
                System.out.println(e.from+" and "+e.to+ " are already connected");
            }
        }
        if(this.graph.cmst.size() != this.graph.vertex.size() - 1){
            System.out.println("The graph is disconnected");
        }
        System.out.println("The minimum cost is "+minCost);
        System.out.println("the Tree has following edges"+graph.cmst);
    }

    private Vertex findParent(Vertex v){
        while(v.parent != null){
            v = v.parent;
        }
        return v;
    }

    private void updateSubTree(Vertex parent){
        for(Vertex v : parent.subTreeGroup){
            if(!parent.equals(v)){
                v.subTreeGroup = parent.subTreeGroup;
            }
        }
    }

    private boolean union(Edge e){
        Vertex u = this.findParent(e.from);
        Vertex v = this.findParent(e.to);
        if(((e.from.name == 0 || e.to.name == 0) || ((e.from.subTreeGroup.size() < graph.getWeight()) && (e.to.subTreeGroup.size() < graph.getWeight())))){
            if(u.name < v.name){
                e.to.parent = e.from;
            }else{
                e.from.parent = e.to;
            }
            System.out.println("Adding edge "+e);
            if((e.from.name != 0 && e.to.name != 0)){
                e.from.subTreeGroup.addAll(e.to.subTreeGroup);
                updateSubTree(e.from);
            }
            return true;
        }else{
            System.out.println("Skipping edge "+e);
            return false;
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


7
0
1
2
3
4
5
6


21
0 1 5
0 2 6
0 3 9
0 4 10
0 5 11
0 6 15
1 2 9
1 3 6
1 4 6
1 5 8
1 6 17
2 3 7
2 4 9
2 5 8
2 6 12
3 4 10
3 5 5
3 6 11
4 5 14
4 6 9
5 6 8

* */