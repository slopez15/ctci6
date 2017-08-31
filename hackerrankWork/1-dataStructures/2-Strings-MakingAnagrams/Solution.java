import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * <h1>Anagram!</h1>
 * <p>
 Description: 
 My version of anagram--minimum character removal. Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.
 Ex: 
 Sample Input
 cde
 abc
 Sample Output
 4
 BruteForce way: 'Going 1 by 1'. The non-productive brute force method is to check each letter in one string for each letter in the other string to find the minimum number of characters that you must remove between the two to make the two strings anagrams of each other. 
 Logic: It requires 2 matching characters to make a pair, where there is one supporting pair in each string. Without any characters in one string (the shorter string), this means all that is left in the second string (the longer string) is just the removable extras--non-pairs. 
 My way: I improved the optimization. The idea was to count the frequency of a letter and removing them in both strings to not execute unnecessary work. The minimum frequency between the two strings are the pairs available and the difference is the number of characters without a pair. Those without a pair counted toward the minimum number of characters needed for deletion. Once the shorter string ran out of characters the left over characters in the longer string were without a pair. Programmatically, I kept counting for the minimum number of characters to delete until both string's characters were accounted for. To indicate all characters were accounted for, I kept checking until both strings were empty. The letter that was used to count frequency always came from the shorter string since there must exist a character in each string to construct a pair.
 </p>
 * 
 * @author Saul Lopez
 * @version 1.0
 * @since 2014-08-08
*/
		

public class Solution {
	//variables
	//these need to be available to all methods.
	private String firstString;
	private String secondString;
	private StringBuilder sb;
	
	//Methods
	/**
	* Constructor
	*/
	public Solution () {
		firstString = "";
		secondString = "";
		sb = new StringBuilder("");		
	}
	/**
	* This method is to find the number of characters needed to remove from first and second string to make the two anagrams of each other.
	* @param first A string of characters
	* @param second A string of characters
	* @return int total number of characters needed to remove from first and second string to them anagrams of each other.
	*/
    public int numberNeeded(String first, String second) {
		//note: the 26 letters in ASCII, 97 to 122
		int numCharsToDelete = 0; //for returning minimum amount 

		//storing input strings to not affect original input.
		sb = new StringBuilder(first);
		firstString = sb.toString();
		sb = new StringBuilder(second);
		secondString = sb.toString();		
		
		String shorterString; //we want shorter string since it is an indicator whether there are any pairs left.
		char letter; //to count frequency of
		int frequencyFirst; //frequency of the letter in first string
		int frequencySecond; //frequency of the letter in the second string

		//Keep checking until both strings are empty and each character is accounted for. If the first string or second string is empty, delete all the characters in the counter string. Else, keep removing pairs and extra characters from a string until one is empty.
		while ( !( firstString.isEmpty() && secondString.isEmpty() ) ) {
			if ( firstString.isEmpty() ) {
				numCharsToDelete += secondString.length();
				secondString = "";
			}
			else if ( secondString.isEmpty() ) {
				numCharsToDelete += firstString.length();
				firstString = "";
			}
			else {
				shorterString = obtainShorterString(firstString, secondString);
				letter = shorterString.charAt(0);//shorterString's letter to count frequency
				//count frequency of the letter in each string. The difference are characters without pairs.
				frequencyFirst = obtainFrequency (letter, firstString, 1);
				frequencySecond = obtainFrequency (letter, secondString, 2);
				numCharsToDelete += ( Math.abs( frequencyFirst - frequencySecond ) );
			}
		}
		//int numberNeeded(String first, String second) //recursion? no, worsens complexity 'i think' to 2n, perhaps only benefit if mem...
		return numCharsToDelete;
    }
	/**
	* Description: 
	* ...
	* Note: only care about letter and string for checking. However, added firstOrSecond parameter to indicate which is being checked since we don't know which this method is being used for to help along the string builder.
	* @param _letter char
	* @param _string String
	* @param firstOrSecond int
	*/
	int obtainFrequency (char _letter, String _string, int firstOrSecond) {
		//Which string will we be counting its frequency?
		if ( firstOrSecond == 1 ) {
			sb = new StringBuilder(firstString);
		}
		else {
			sb = new StringBuilder(secondString);
		}
		int _frequency = 0;
		int index = 0;
		//go through each character in the string and add 1 for each match, and delete that character in string builder.
		for ( char character : _string.toCharArray() ) {
			if ( character == _letter ) {
				_frequency++;
				sb.deleteCharAt(index); //note: sb updates string and indexes after changes
				index--; //since we are comparing the string and not string builder, need to adjust the index each time it does find a match.
			}
			index++;
		}
		updateString(firstOrSecond); //commit the changes of the string
		return _frequency;
	}
	/**
	* Description: 
	* This commits the changes made in the string builder to the respective string variable to allow next iterative frequency check of the string.
	* Note: Since this calls StringBuilder sb's toString method to assign to a variable, it assumes that whatever string sb is manipulating has already been decided (firstString or secondString). Otherwise, the code will have a fault. Example: inside sb are changes to string2 when we are updating string1, thus overwriting string1. See: obtainFrequency where we decide before doing anything.
	* @param _firstOrSecond int
	*/
	private void updateString (int _firstOrSecond) {
		if ( _firstOrSecond == 1 ){
			firstString = sb.toString();
		}
		else {
			secondString = sb.toString();
		}
	}
	/**
	* Description: 
	* Compares two strings and returns the shorter one. If they are the same, returns the first string.
	* @param _first String
	* @param _second String
	*/
	String obtainShorterString (String _first, String _second) {
		String _shorterString;
		if ( _first.length() <= _second.length() ){
			_shorterString = _first; //first string is shorter or same as second
		}
		else {
			_shorterString = _second; //second is shorter
		}
		return _shorterString;
	}
	//Main Method
	/**
	* Main method to execute program--uses numberNeeded to get number of chars to delete for making 2 strings anagrams.
	* 
	* @param args Unused
	* @return Nothing
	*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
			//System.out.println("Enter the first string: ");
        String a = in.next();
			//System.out.println("Enter the second string: ");
        String b = in.next();
			//System.out.println("Total amount of letters to remove from first and second string to make them anagrams of each other: ");
		Solution s = new Solution();
		System.out.println(s.numberNeeded(a, b));
    }
}