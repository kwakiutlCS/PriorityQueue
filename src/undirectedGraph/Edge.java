package undirectedGraph;

/**
 * Created by ricardo on 30/03/2015.
 */
public class Edge {
    private int[] vertices = new int[2];
    private int weigth;

    public Edge(int v1, int v2, int w) {
        vertices[0] = v1;
        vertices[1] = v2;
        weigth = w;
    }

    public int getWeigth() { return weigth; }

    public int getOther(int v) {
        if (vertices[0] == v) return vertices[1];
        return vertices[0];
    }
}
