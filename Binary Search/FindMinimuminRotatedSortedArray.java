import java.util.*;
public class FindMinimuminRotatedSortedArray {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low=0,high=n-1;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[high])
            {
                low = mid+1;
            }
            else
            {
                high=mid;
            }
        }
        return nums[low];
    }
}
