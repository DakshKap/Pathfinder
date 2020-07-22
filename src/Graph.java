import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    private HashMap<Integer, Node> ndMap;
    //Constructor
    public Graph(){
        ndMap = new HashMap<>();
    }

    //Generate Nodes and Connections
    public void generateGraph(int n, int[][] edges){
        //Generate Nodes
        for(int i=1;i<=n;i++){
            ndMap.put(i,new Node(i));
        }
        //Create connections
        for(int[] edge:edges){
            ndMap.get(edge[0]).neighbours.add(edge[1]);
        }
        
    }

    //Node represents each vertice of the graph.
    private class Node {
        private int id;
        private List<Integer> neighbours;

    public Node(int id){
        this.id = id;
        neighbours = new ArrayList<>();
    }
}
}