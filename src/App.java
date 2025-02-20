import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        int numNodes=79;
        //Edges
        int[][] edges = {{1,2},{1,10},{2,1},{2,3},{3,2},{3,4},{4,3},{4,5},{4,12},{5,4},{5,6},{6,5},{6,7},{6,13},{7,6},{7,8},{7,20},{8,7},{8,9},{9,8},{9,22},{10,1},{10,11},{10,14},{48,36},{49,38},
                        {11,10},{11,16},{12,4},{12,13},{12,17},{13,6},{13,19},{14,10},{14,28},{15,14},{16,11},{16,15},{16,24},{17,12},{17,16},{17,25},{18,17},{18,26},{19,13},{19,18},{19,34},{39,40},
                        {20,19},{20,35},{21,8},{21,20},{22,9},{22,21},{23,22},{23,37},{24,16},{24,25},{24,32},{25,17},{25,26},{25,27},{25,24},{26,25},{26,18},{26,27},{28,14},{28,29},{28,38},{39,38},
                        {29,30},{29,39},{30,31},{30,15},{30,40},{31,32},{31,41},{32,24},{32,33},{32,42},{33,27},{33,34},{34,35},{34,44},{35,21},{35,36},{35,46},{36,22},{36,37},{37,23},{38,28},{38,39},
                        {39,29},{40,39},{40,30},{40,41},{41,40},{41,31},{41,42},{42,41},{42,32},{42,43},{42,51},{43,42},{44,43},{44,53},{45,44},{46,45},{46,35},{46,55},{46,47},{47,48},{47,46},{48,47},
                        {49,50},{49,57},{50,49},{50,51},{50,30},{51,50},{51,42},{51,42},{51,52},{51,59},{52,51},{52,53},{53,52},{53,54},{53,69},{54,53},{54,55},{55,54},{55,46},{55,56},{55,71},{56,55},
                        {56,48},{57,58},{57,49},{57,60},{58,57},{58,59},{58,61},{59,58},{59,51},{59,63},{60,57},{60,65},{61,60},{61,58},{62,61},{62,65},{63,62},{63,59},{63,68},{64,56},{65,60},{38,49},
                        {65,62},{65,66},{66,65},{66,74},{67,66},{67,75},{68,67},{68,63},{68,69},{69,68},{69,70},{70,69},{70,71},{70,76},{71,70},{71,55},{71,77},{72,71},{72,64},{73,72},{73,79},{74,66},
                        {74,75},{75,74},{75,67},{76,70},{76,77},{77,76},{77,71},{77,78},{78,77},{78,72},{78,79},{79,73}};
                        
        Graph cityBlock = init(numNodes, edges);
        printPath(cityBlock.getShortestPath(1, 79));
        
    }
    public static void printPath(List<Integer> path){
        if(path.isEmpty()){
            System.out.println("No path exists between the two nodes.");
        }else{
            StringBuilder pathStr = new StringBuilder();
            for(int i=0;i<path.size()-1;i++){
                pathStr.append(path.get(i)+"->");
            }
            pathStr.append(path.get(path.size()-1));
            System.out.println("Path: "+ pathStr.toString());
        }
    }
    public static Graph init(int numNodes, int[][] edges){
        //Initialize graph
        return new Graph(numNodes, edges);
    }
}

