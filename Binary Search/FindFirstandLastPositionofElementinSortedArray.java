import java.util.*;

public class FindFirstandLastPositionofElementinSortedArray {
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
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans)); // FIXED
    }

    public static int[] searchRange(int[] nums, int target) {
       int n = nums.length;
       if(n==0)
       {
        return new int[]{-1,-1};
       } 
       int first = firstpos(nums,target);
       int last = lastpos(nums,target);
       return new int[]{first,last};
    }

    private static int firstpos(int[] nums,int target)
    {
        int low=0 , high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]==target)
            {
                ans = mid;
                high = mid-1; // move left
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }

    private static int lastpos(int[] nums,int target)
    {
        int low=0 , high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]==target)
            {
                ans = mid;
                low = mid + 1; // move right
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
}
