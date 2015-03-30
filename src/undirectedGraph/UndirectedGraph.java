package undirectedGraph;

import priorityQueue.PriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricardo on 30/03/2015.
 */
public class UndirectedGraph {
    private List<Vertex> vertices = new ArrayList<>();

    public void addVertex() {
        vertices.add(new Vertex(vertices.size()+1));
    }

    public void addEdge(int v1, int v2, int weight) {
        Edge e = new Edge(v1, v2, weight);
        vertices.get(v1-1).addEdge(e);
        vertices.get(v2-1).addEdge(e);
    }


    public long solve() {
        PriorityQueue<Node> pk = new PriorityQueue<>();
        for (Vertex v : vertices) {
            pk.add(new Node(v, Integer.MAX_VALUE));
        }

        long total = 0;
        while (pk.size() > 0) {
            Node n = pk.remove();
            Vertex v = n.getV();
            long dist = n.getDistance();
            if (dist == Integer.MAX_VALUE) dist = 0;
            total += dist;

            for (Edge e : v.getEdges()) {
                int other = e.getOther(v.getV());
                Node otherNode = pk.get(new Node(new Vertex(other), 0));
                if (otherNode != null && otherNode.getDistance() > e.getWeigth()) {
                    otherNode.setDistance(e.getWeigth());
                    pk.update(otherNode);
                }
            }
        }
        return total;
    }



    private class Node implements Comparable<Node> {
        private Vertex v;
        private long distance;

        public Node(Vertex v, long distance) {
            this.v = v;
            this.distance = distance;
        }


        public Vertex getV() {
            return v;
        }

        public long getDistance() {
            return distance;
        }

        public void setDistance(long distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (distance>o.distance) return 1;
            else if (distance < o.distance) return -1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                Node n = (Node) o;
                return v.equals(n.v);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return v.hashCode();
        }

        @Override
        public String toString() {
            return v.toString();
        }
    }
}
