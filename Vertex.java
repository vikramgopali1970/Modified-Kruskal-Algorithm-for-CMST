package ModifiedKruskalAlgorithm;

import java.util.HashSet;

public class Vertex {
    int name;
    Vertex parent;                                  // stores the parent of current vertex
    HashSet<Vertex> subTreeGroup;                   // stores the subtree along with nodes to which it belongs
    int weightSubTree;                              // used to store the weight of the subtree to which it belongs

    public Vertex(int name, int weightSubTree){
        this.name = name;
        this.parent = null;
        this.subTreeGroup = new HashSet<Vertex>();
        this.subTreeGroup.add(this);
        this.weightSubTree = weightSubTree;
    }

    /**
     * This method is used to override the hashcode method for the class Vertex.
     * */
    public int hashCode()
    {
        // use hash codes of the underlying objects
        return this.name;
    }

    /**
     * This method is used to override the equals method for the class Vertex.
     * */
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Vertex v = (Vertex) o;

        if(v.name == this.name){
            return true;
        }
        return false;
    }

    /**
     * This method is used to print the vertex object.
     * */
    public String toString(){
        return String.valueOf(this.name);
    }
}
