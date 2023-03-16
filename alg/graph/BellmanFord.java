package alg.graph;

import java.util.Arrays;

//directed graph
class Edge{
    int u, v, w;
}
public class BellmanFord {
    static final int INF = Integer.MAX_VALUE;
    int[] dist;

    public BellmanFord(){

    }

    //O(V.E) implementation
    public int[] findShortestPath(int s, int n, Edge[] edges){
        dist = new int[n];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        //loop runs n-1 times bcz that is the max number of edges in any shortest path
        for(int i=0; i<n-1; i++){
            //relaxation along each edge
            for(Edge edge: edges){
                if(edge.u!=INF){
                    dist[edge.v] = Math.min(dist[edge.v], dist[edge.u]+edge.w);
                }
            }
        }

        //if graph does one more relaxation after n-1 runs, negative cycle found
        for(Edge edge: edges){
            if(dist[edge.v]>dist[edge.u]+edge.w){
                System.out.println("Negative cycle found");
                break;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
         
    }
    
}
