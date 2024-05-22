package uvg.edu.gt;

import java.util.*;

public class DirectedGraph {
    private Map<Node, List<Edge>> adjacencyList;
    public DirectedGraph(){
        adjacencyList = new HashMap<>();
    }
    public List<Node> getNodes(){
        Set<Node> keySet = adjacencyList.keySet();
        return new ArrayList<>(keySet);
    }
    public Map getAdjacencyList(){
        return adjacencyList;
    }
    public List<Edge> getNeighbors(String nodeName){
        Node node = getNode(nodeName);
        return adjacencyList.get(node);
    }
    public void addNode(Node node){
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    public void addEdge(String from, String to, int weight){
        Node fromNode = getNode(from);
        Node toNode = getNode(to);
        adjacencyList.get(fromNode).add(new Edge(toNode, weight));
    }
    public Node getNode(String name){
        for (Node node : adjacencyList.keySet()){
            if (node.getName().equals(name)){
                return node;
            }
        }
        return null;
    }
    public void removeEdge(String from, String to){
        Node fromNode = getNode(from);
        Node toNode = getNode(to);
        List<Edge> edges = adjacencyList.get(fromNode);
        if (edges != null){
            edges.removeIf(edge -> edge.getTo().equals(toNode));
        }
    }
}
