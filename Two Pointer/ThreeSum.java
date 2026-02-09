import java.util.*;
public class ThreeSum {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> li : res) {
            System.out.print(li+" ");
        }
    }
    public static List<List<Integer>> threeSum(int[] nums)
    {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int left = i+1,right=n-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                List<Integer> ans = new ArrayList<>();
                if(sum==0)
                {
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);
                    while(left<right && nums[left]==nums[left+1])
                    {
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1])
                    {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return res;
    }
}
