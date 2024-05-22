package uvg.edu.gt;

import junit.framework.TestCase;
import java.util.*;

public class DirectedGraphTest extends TestCase {
    public void testAddNode() {
        DirectedGraph graph = new DirectedGraph();
        Node node = new Node("Guatemala");
        graph.addNode(node);
        List<Node> nodes = graph.getNodes();
        assertEquals(1, nodes.size());
        assertTrue(nodes.contains(node));
    }
    public void testAddEdge() {
        DirectedGraph graph = new DirectedGraph();
        Node node1 = new Node("Guatemala");
        Node node2 = new Node("Peten");
        Node node3 = new Node("Zacapa");
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addEdge("Guatemala", "Peten", 300);
        graph.addEdge("Guatemala", "Zacapa", 400);
        List<Edge> edges = graph.getNeighbors("Guatemala");
        assertEquals(edges.size(), 2);
        assertEquals(edges.get(0).getWeight(), 300);
        assertEquals(edges.get(0).getTo().getName(), "Peten");
        assertEquals(edges.get(1).getWeight(), 400);
        assertEquals(edges.get(1).getTo().getName(), "Zacapa");
    }

    public void testGetNode() {
    }

    public void testRemoveEdge() {
        DirectedGraph graph = new DirectedGraph();
        Node node1 = new Node("Guatemala");
        Node node2 = new Node("Peten");
        Node node3 = new Node("Zacapa");
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addEdge("Guatemala", "Peten", 300);
        graph.addEdge("Guatemala", "Zacapa", 400);
        graph.removeEdge("Guatemala", "Zacapa");
        List<Edge> edges = graph.getNeighbors("Guatemala");
        assertEquals(edges.size(), 1);
        assertEquals(edges.get(0).getWeight(), 300);
        assertEquals(edges.get(0).getTo().getName(), "Peten");
    }
}