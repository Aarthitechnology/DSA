import java.util.*;
public class BinarySearch {
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
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low=0 , high=n-1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(nums[mid]==target)
            {
                return mid;
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
        return -1;
    }
}
