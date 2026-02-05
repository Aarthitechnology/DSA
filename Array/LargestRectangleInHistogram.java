import java.util.Scanner;
import java.util.Stack;
public class LargestRectangleInHistogram {
    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0;i<n;i++)
        {
            height[i] = sc.nextInt();
        }
        System.out.println(largestRectangleArea(height));
    }
    public static int largestRectangleArea(int[] heights) 
    { 
        int n = heights.length; 
        Stack<Integer> st = new Stack<>();
        int maxArea = 0; 
        for (int i = 0; i <= n; i++) 
        { 
            int curHeight = (i == n) ? 0 : heights[i]; 
            while (!st.isEmpty() && heights[st.peek()] > curHeight) 
            { 
                int h = heights[st.pop()]; 
                int right = i; 
                int left = st.isEmpty() ? -1 : st.peek(); 
                int width = right - left - 1;
                maxArea = Math.max(maxArea, h * width); 
            } 
            st.push(i);
        } 
        return maxArea;
    }
}
