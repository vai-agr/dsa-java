package misc;
import java.util.*;

//largest rectangle in histogram
public class Histogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int j=0; j<heights.length; j++){
            while(!stack.empty() && heights[j]<heights[stack.peek()]){
                int cur = stack.peek();
                int h = heights[cur];
                stack.pop();
                int i = stack.empty()?-1:stack.peek();
                ans = Math.max(ans, h*(j-i-1));
            }
            stack.push(j);
        }

        while(!stack.empty()){
            int cur = stack.peek();
            int h = heights[cur];
            stack.pop();
            int i = stack.empty()?-1:stack.peek();
            ans = Math.max(ans, h*(heights.length-i-1));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    } 
}
