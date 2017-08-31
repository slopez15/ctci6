import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
* Limitations and Descriptions:
* m, n = [1,30k] OR respective; 
* wordLength = [1,5]; 
* a-z, A-Z, 26+26=52; 
* ASCII:: (a-z)[97-122][U+0061 - U+007A], 
* UNICD:: (A-Z)[65-90] [U+0041 - U+005A]
* 
* 
//variables: m, n, magazinge[], ransom[].
//using a hash collection vs implementing one, but maybe using provided hash code function...
//will use hash collection 1st to try.
* 
*/
public class Solution {
	//variables
	static Hashtable <String, Integer> frequency; //store magazine words, then check if has ransom note word. Integer to keep track of frequency.
    static int m,n; //amount of words; m - magazine, n - ransom.
	static String [] magazine,ransom; //words from respective source (magazine or ransom). Place words into a allocated collection.
	static Boolean containAllWords;
	static String word;
	static Integer value;
	
	//Constructors
	public Solution (){
		//everything not here is empty, will initialize in static main.
		frequency = new Hashtable <String, Integer> ();
		m = 0;
		n = 0;
		magazine = new String [0];
		ransom = new String [0];
		containAllWords = true;
		word = "";
		value = 0;
	}
	//main
    public static void main(String[] args) {
		Solution s = new Solution();
		//Solution();
        Scanner in = new Scanner(System.in);
		//obtain input from user
        m = in.nextInt();
        n = in.nextInt();
        magazine = new String[m];
        ransom = new String[n];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
			word = magazine[magazine_i];
			increment(word);
        }
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
			word = ransom[ransom_i];
			decrement(word);
			if (!containAllWords){
				break;
			}
        }
		if (containAllWords){
			System.out.println("Yes");
		}
    }//main	
	//Methods
	public static void increment (String key) {
		//get value. if null (not in hash table), add the key and a value of 1. else, add 1 to existing value of key.
		value = frequency.get(key);
		if (value == null){
			frequency.put(key, 1);
		}else {
			frequency.put(key, value+1);			
		}		
	}
	public static void decrement (String key){
		//get value. if null, (cannot make ransom note) __. Else, we not have a frequency of a word. If value is 1, remove key from hash table (no more multiples of that word). if frequency value is > 1, decrement by 1.
		value = frequency.get(key);
		if (value == null){
			//change containAllWords to false, print no, and stop.
			containAllWords = false;
			System.out.println("No");
		}
		else{
			if (value == 1){
				frequency.remove(key);
			}
			else{
				frequency.put(key, value-1);
			}
		}
	}
}//Solution
