package undirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricardo on 30/03/2015.
 */
public class Vertex {
    private int v;
    private List<Edge> edges = new ArrayList<>();

    public Vertex(int v) {
        this.v = v;
    }
    
    public void addEdge(Edge e) {
        edges.add(e);
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    public int getV() { return v; }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex vert = (Vertex) o;
            return v == vert.v;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return v;
    }

    @Override
    public String toString() {
        return v+"";
    }
}
