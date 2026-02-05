import java.util.*;
public class SubarraySumEqualsK {
    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int count = 0;
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int sum=0;
                if(start==0)
                {
                    sum = prefix[end];
                }
                else
                {
                    sum = prefix[end]-prefix[start-1];
                }
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
