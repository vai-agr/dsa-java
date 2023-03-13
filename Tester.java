import java.util.Arrays;

//test java code
public class Tester {
    public static void main(String[] args) {
        int n=3;
        char[][] board = new char[n][n];
        
        for(int i=0; i<n; i++){
             Arrays.fill(board[i], '.');
        }

        for(int i=0; i<n; i++){
            System.out.println(new String(board[i]));
       }
    }
}
