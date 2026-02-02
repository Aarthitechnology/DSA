import java.util.*;
public class BasicCalculator {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int res=0 , curr = 0, sign=1;
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                curr = curr*10+(ch-'0');
            }
            else if(ch=='+')
            {
                res = res+(curr*sign);
                curr=0;
                sign = 1;
            }
            else if(ch=='-')
            {
                res = res+(curr*sign);
                curr = 0;
                sign = -1;
            }
            else if(ch=='(')
            {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1; 
            }
            else if(ch==')')
            {
                res = res+(sign*curr);
                curr = 0;
                int prevsign = stack.pop();
                int prevres = stack.pop();
                res = prevres + (res * prevsign);
            }
        }
        res = res+(curr*sign);
        return res;
    }
}
