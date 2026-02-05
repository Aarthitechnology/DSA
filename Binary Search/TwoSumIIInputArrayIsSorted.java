import java.util.*;
public class TwoSumIIInputArrayIsSorted {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] ans = twoSum(nums,target);
        for(int x : ans)
        {
            System.out.print(x+" ");
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int rem = target - nums[i];
            int low=i+1,high=n-1;
            while(low<=high)
            {
                int mid = low+(high-low)/2;
                if(nums[mid]==rem)
                {
                    return new int[]{i+1,mid+1};
                }
                else if(nums[mid]<rem)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
