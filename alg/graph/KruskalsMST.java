package alg.graph;

import java.util.Arrays;

public class KruskalsMST {
    final int INF = 10000000;

    // O(MlogN + N^2)
    public void minSpannningTree(int n, int[][] edges){

        int[] subtree = new int[n];
        int tw = 0;
        for(int i=0; i<n; i++)
            subtree[i] = i;
        Arrays.sort(edges, (a, b)->a[2]-b[2]);

        for(int[]edge: edges){
            //if same tree
            if(subtree[edge[0]]==subtree[edge[1]])
                continue;
            tw += edge[2];
            
            int oldTree = subtree[edge[0]], newTree = subtree[edge[1]];
            
            //merging the trees
            for(int j=0; j<n; j++){
                if(subtree[j]==oldTree)
                    subtree[j] = newTree;
            }
        }

        System.out.println(tw);
    }


    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
            {0,1,2}, {1,2,3}, {3,1,3},{0,3,1},
            {2,3,5}, {4,0,4}, {4,3,9}, {1,5,7}, {2,5,8}
        };
        KruskalsMST mst = new KruskalsMST();
        mst.minSpannningTree(n, edges);
    }
}
