import java.util.*;
public class MoveZeroes {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = sc.nextInt();
        }
        moveZero(nums);
        for(int i=0;i<n;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }
    public static void moveZero(int[] nums)
    {
        int n = nums.length;
        int idx=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                nums[idx] = nums[i];
                idx++;
            }
        }
        while(idx<n)
        {
            nums[idx] = 0;
            idx++;
        }
    }
}
