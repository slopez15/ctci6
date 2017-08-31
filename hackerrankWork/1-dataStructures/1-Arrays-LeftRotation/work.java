import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        //provided: reads in n (num of ints), d(num of left-rotations), and a (array of ints).
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //Execute actions to obtain result--array in final state, after d/k left-rotations.
        int result [] = new int[n];
		int firstHalf = k; //first half: k to end of a[].
		int secondHalf = 0; //second half: 0 to (k-1) is placed after k value
        for (int a_f = 0; a_f < n; a_f++) {
			if ( firstHalf < n ) {
				result [a_f] = a[firstHalf];
				firstHalf++;
			}
			else {
				result [a_f] = a[secondHalf];
				secondHalf++;

			}
		}
		for (int val : result) {
			System.out.print(val + " ");
		}
        
    }
}


