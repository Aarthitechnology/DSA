import java.util.*;
public class ProductofArrayExceptSelf {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        int[] res = productExceptSelf(nums); 
        for(int i=0;i<n;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] remprod = new int[n];
        remprod[0] = 1;
        for(int i=1;i<n;i++)
        {
            remprod[i] = remprod[i-1]*nums[i-1];
        }
        int suffix = 1;
        for(int i=n-1;i>=0;i--)
        {
            remprod[i] = remprod[i]*suffix;
            suffix=suffix*nums[i];
        }
        return remprod;
    }
}