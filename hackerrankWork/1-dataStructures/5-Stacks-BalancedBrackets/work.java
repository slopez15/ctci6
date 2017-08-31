/* Notes:
Brackets: (, ), {, }, [, or ].
Opening bracket on left, Closing bracket on right.
Pair of brackets are balanced iff insides are balanced.

Balanced iff:
no unmatched brackets
brackets inside the pairs are pairs too.

input: n - strings, each with brackets.
n - num of strings [1, 1k]
s - n_i-th line up to n amount; [1, 1k]
output:
YES/NO

example:
INPUT:
3
{[()]}
{[(])}
{{[[(())]]}}
OUPUT:
YES
NO
YES

Explanation:
The string {[()]} meets both criteria for being a *balanced string, so we print YES on a new line.
The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isBalanced(String expression) {
        //TODO
        
        return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}















