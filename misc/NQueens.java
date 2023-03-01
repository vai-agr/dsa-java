package misc;
import java.util.*;

public class NQueens {
    static boolean isValid(int r, int c, int n, String[] board){
        return true;
    }
    static void backtrack(int r, int n, String[] board, List<List<String>> ans){
        if(r == n){
            ans.add(Arrays.asList(board)); 
        }

        for(int c=0; c<n; c++){
            if(isValid(r,c,n,board)){
                board[r][c] = 'Q';
            }
        }
        return;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        String[] board = new String[n];
        char[] row = new char[n];
        Arrays.fill(row, '.');
        String s = new String(row);
        Arrays.fill(board, s);
        
        backtrack(0,n,board,ans);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        List<List<String>>  ans = solveNQueens(n);
    }
    
}


