import java.util.*;
public class KokoEatingBananas {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] piles = new int[n];
        for(int i=0;i<n;i++)
        {
            piles[i] = sc.nextInt();
        }
        int h = sc.nextInt();
        System.out.println(minEatingSpeed(piles,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low=1 , high = 0;
        for(int p : piles)
        {
            high = Math.max(high,p);
        }
        while(low<high)
        {
            int mid = (low+high)/2;
            if(caneat(piles,mid,h))
            {
                high = mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    private static boolean caneat(int[] piles,int k , int h)
    {
        long hours = 0;
        for(int p : piles)
        {
            hours = hours + (p+k-1)/k;//total hours need to eat all piles of banana.
        }
        return hours<=h;
    }
}
