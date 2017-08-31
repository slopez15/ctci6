import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * <h1>Anagram!</h1>
 * <p>Description: My version of anagram. Instead of going 1 by 1 in checking, I improved by checking first line first before checking second line and counting frequency for lower number. Also, removed the letters as I iterated through each letter in first and second. </p>
 * 
 * @author Saul Lopez
 * @version 1.0
 * @since 2014-08-07
*/
public class scopeTest {
	/**
	* This method is to find the number of characters needed to remove from first and second string to make the two anagrams of each other.
	* @param first A string of characters
	* @param second A string of characters
	* @return int total number of characters needed to remove from first and second string to them anagrams of each other.
	*/
    public static int numberNeeded(String first, String second) {
		int numCharsToDeleted = 0;
		obtainFrequency (numCharsToDeleted);
		//int numberNeeded(String first, String second)
		return numCharsToDeleted;
    }
	static int obtainFrequency (int _num) {
		_num ++;
		return _num;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}









