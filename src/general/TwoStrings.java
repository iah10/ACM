package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/alternating-characters">Problem</a>
 */
public class TwoStrings 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- >0)
		{
			String a = scan.next();
			String b = scan.next();
			System.out.println(solve(a,b));
		}
		scan.close();
	}

	private static String solve(String a, String b) 
	{
		int[] charsA = new int[26];
		int[] charsB = new int[26];
		int aLength = a.length();
		int bLength = b.length();
		for (int i = 0; i < Math.max(aLength, bLength ); i++) 
		{
			if (i<aLength) {
				charsA[a.charAt(i)-'a']++;
			}
			if (i<bLength) {
				charsB[b.charAt(i)-'a']++;
			}
		}
		
		for (int i = 0; i < 26; i++) {
			if (charsA[i] !=0 && charsB[i]!=0 && Math.abs(charsA[i]-charsB[i])>0) {
				return "YES";
			}
		}
		return "NO";
	}
}
