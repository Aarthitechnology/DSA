import java.util.*;
public class ValidPalindrome {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        int n = s.length();
        if(n==1)
        {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String newstr = sb.toString();
        String rev = new StringBuilder(newstr).reverse().toString();
        if(newstr.equals(rev))
        {
            return true;
        }
        return false;
    }
}
