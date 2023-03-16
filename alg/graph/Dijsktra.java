package alg.graph;
//Single source shortest path using Dijsktra

import java.util.Arrays;

public class Dijsktra {
    static final int INF = Integer.MAX_VALUE;
    int v;                    //no of vertices
    boolean[] marked;         //marked array
    int[] dist;               //distance array


    public Dijsktra(int[][] graph){
        v = graph.length;
        marked = new boolean[v];
        dist = new int[v];
        Arrays.fill(dist, INF);
    }

    private void printSolution(int[] dist){
        for(int d: dist)
            System.out.print(d+" ");
    }

    //O(V^2 + E)
    public void shortestPath(int s, int[][] graph){
        dist[s] = 0;
        
        for(int i=0; i<v; i++){

            //to find the minimum distance among unmarked vertices(greedy)
            int minDist = INF, minv=v;
            for(int j=0; j<v; j++){
                if(!marked[j] && dist[j]<minDist){
                    minDist = dist[j];
                    minv = j;
                }
            }
            //if no vertex is within reachable distance
            if(minDist==INF) break;
            marked[minv] = true;
            
            //calculate the next distance from the min dist vertex
            for(int j=0; j<v; j++){
                if(graph[minv][j]>0){
                    dist[j] = Math.min(dist[j], minDist+graph[minv][j]);
                }
            }

        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Dijsktra dij =  new Dijsktra(graph);
        int source = 0;
        dij.shortestPath(source, graph);
    }
}
