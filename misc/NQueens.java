package misc;
import java.util.*;

//generate a possible NQueens solution
public class NQueens {
    static boolean isValid(int r, int c, int n, char[][] board){
        for(int i=0; i<r; i++)
            if(board[i][c]=='Q') return false;
        
        for(int i=r-1,j=c-1; i>=0&&j>=0; i--,j--)
            if(board[i][j]=='Q') return false;
        
        for(int i=r-1,j=c+1; i>=0&&j<n; i--,j++)
            if(board[i][j]=='Q') return false;

        return true;
    }
    static boolean backtrack(int r, int n, char[][] board){
        if(r == n){
            return true;
        }
        
        for(int c=0; c<n; c++){
            if(isValid(r,c,n,board)){
                board[r][c] = 'Q';
                if(backtrack(r+1, n, board))
                    return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public static List<String> solveNQueens(int n) {
       char[][] board = new char[n][n];
       
       for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        backtrack(0,n,board);

        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            ans.add(new String(board[i]));
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        List<String> board = solveNQueens(n);

        for(int i=0; i<n; i++){
            System.out.println(board.get(i).toString());
        }
    }
    
}


