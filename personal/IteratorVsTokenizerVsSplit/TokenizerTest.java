import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
//import java.util.StringTokenizer;  

//WARNING! NOT TESTED. except basic and nextToken delim

/**
*
*/
public class TokenizerTest {

    public static void main(String[] args) {
		//Part1 Basic
		//notice StringTokenizer(String s, String delim, boolean considerDelimsAsTokensToo);
		System.out.println("Basic StringTokenizer(String) & nextToken()");
		String s = "Hello My name is Jacob Jammer";
		StringTokenizer st = new StringTokenizer(s);
		String s0 = st.nextToken();
		System.out.println("s0 is " + s0);
		int tokenNum = 1;
		while (st.hasMoreTokens()){
			//notice st.nextToken(), param is delimiter.
			System.out.println("tokenNum" + tokenNum + ": " + st.nextToken());
			tokenNum++;
		}

		//Part1a Delimiter via nextToken(delim)
		System.out.println("StringTokenizer(string) & nextToken(delim)");
		st = new StringTokenizer("Hello.My.name.is.Jacob.Jammer");
		tokenNum = 0;
		while (st.hasMoreTokens()){
			//notice st.nextToken("."), param is delimiter.
			System.out.println("tokenNum" + tokenNum + ": " + st.nextToken("."));
			tokenNum++;
		}

		//Part1b Delimiter via constructor
		System.out.println("StringTokenizer(string, delim) & nextToken()");
		st = new StringTokenizer("The cow Jumped Over the Moon. Yeah Boy!");
		
		//Part1c Delimiter via constructor + nextToken(delim)
		System.out.println("StringTokenizer(string, delim) & nextToken(delim)");
		
		//Part1d Delimiter via constructor with delims + nextToken()
		System.out.println("StringTokenizer(string, delim, true) & nextToken()");
		
		//Part1e Delimiter via constructor with delims + nextToken(delim)
		System.out.println("StringTokenizer(string, delim, true) & nextToken(delim)");
		
		
    }//main
	
}//class

