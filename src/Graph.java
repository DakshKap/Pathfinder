import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class Graph {
    private HashMap<Integer, Node> ndMap;
    private int numNodes;
    //Constructor
    public Graph(int n, int[][] edges){
        ndMap = new HashMap<>();
        numNodes = n;
        generateGraph(n, edges);
    }
    // To add new single edge
    public void addEdge(int[] edge) throws Exception {
        if(edge.length > 2){
            throw new Exception("Illegal argument an edge can have only 2 nodes, ex. {1,2}");
        }
        // Make sure all the nodes are in the graph. If not add a new node
        if(ndMap.get(edge[0]) != null && ndMap.get(edge[1]) == null){
            ndMap.put(edge[1],new Node(edge[1]));
            numNodes++;
        }else if(ndMap.get(edge[0]) == null && ndMap.get(edge[1]) != null){
            ndMap.put(edge[0],new Node(edge[0]));
            numNodes++;
        }else{
            ndMap.put(edge[0],new Node(edge[0]));
            ndMap.put(edge[1],new Node(edge[1]));
            numNodes += 2;
        }
        //add to neighbours(adj list)
        ndMap.get(edge[0]).neighbours.add(edge[1]);
    }

    //Generate Nodes and Connections
    private void generateGraph(int n, int[][] edges){
        //Generate Nodes
        for(int i=1;i<=n;i++){
            ndMap.put(i,new Node(i));
        }
        //Create connections
        for(int[] edge:edges){
            ndMap.get(edge[0]).neighbours.add(edge[1]);
        }
    }

    //Breadth First Search
    public boolean[] bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[numNodes+1];
        visited[start] = true;
        while(!q.isEmpty()){
            Node curr = ndMap.get(q.remove());
            for(int temp:curr.neighbours){
                if(!visited[temp]){
                    visited[temp] = true;
                    q.add(temp);
                }
            }
        }
        return visited;
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