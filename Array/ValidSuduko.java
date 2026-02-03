import java.util.*;
public class ValidSuduko {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        char board[][] = new char[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                board[i][j] = sc.next().charAt(0);
            }
        } 
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        boolean inrow[][] = new boolean[9][10];
        boolean incol[][] = new boolean[9][10];
        boolean insub[][] = new boolean[9][10];
        for(int r=0;r<9;r++)
        {
            for(int c=0;c<9;c++)
            {
                char ch = board[r][c];
                if(ch=='.')
                {
                    continue;
                }
                int digit = ch-'0';
                int sub = (r/3)*3+(c/3);
                if(inrow[r][digit] || incol[c][digit] || insub[sub][digit])
                {
                    return false;
                }
                inrow[r][digit] = true;
                incol[c][digit] = true;
                insub[sub][digit] = true;
            }
        }
        return true;
    }
}
