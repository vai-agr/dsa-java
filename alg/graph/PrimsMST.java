package alg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimsMST {
    final int INF = 10000000;
    
    // O(n.m) n = no of vertices, m = no of edges
    //suitable for sparse graphs
    public void minSpannningTree(int n, int[][] adj){
        int tw = 0;
        boolean[] selected = new boolean[n];
        List<int[]> edges = new ArrayList<int[]>();
        edges.add(new int[]{0,0});
        
        for(int i=0; i<n; i++){
            int mini = -1, minC = INF;
            //select minimum edge from list of edges
            for(int[] edge: edges){
                if(!selected[edge[0]] && (mini==-1 || edge[1]<minC)){
                    mini = edge[0];
                    minC = edge[1];
                }
            }
            
            if(minC == INF){
                System.out.println("No MST");
                return;
            }
            selected[mini] = true;
            tw +=minC;
            
            //add the new edges to the list
            for(int j=0; j<n; j++){
                if(adj[mini][j]>0 && !selected[j])
                    edges.add(new int[] {j, adj[mini][j]});
            }          
        }

        System.out.println("Total weight = "+ tw);
    }

    // O(n^2) - suitable for dense graphs
    public void minSpannningTreeOptmized(int n, int[][] adj){
        int tw = 0;
        boolean[] selected = new boolean[n];
        int[] minCost = new int[n];
        Arrays.fill(minCost,INF);
        minCost[0] = 0;
        
        for(int i=0; i<n; i++){
            int minV = -1;

            for(int j=0; j<n; j++){
                //selecting the minimum value
                if(!selected[j] && (minV==-1 || minCost[j]<minCost[minV])){
                    minV = j;
                }
            }

            if(minV==-1){
                System.out.println("No MST");
                return;
            }
            tw+=minCost[minV];
            selected[minV] = true;
            //updating the values
            for(int j=0; j<n; j++){
                if(!selected[j] && adj[minV][j]>0 && adj[minV][j]<minCost[j])
                    minCost[j] = adj[minV][j];
            }
        }

        System.out.println("Total weight = "+ tw);
    }
    

    public static void main(String[] args) {
        int n = 6;
        int[][] adjMatrix = {
            {0,2,0,1,4,0},
            {2,0,3,3,0,7},
            {0,3,0,5,0,8},
            {1,3,5,0,9,0},
            {4,0,0,9,0,0},
            {0,7,8,0,0,0}
        };

        PrimsMST mst = new PrimsMST();
        //mst.minSpannningTree(n, adjMatrix);
        mst.minSpannningTreeOptmized(n, adjMatrix);
    }
}
