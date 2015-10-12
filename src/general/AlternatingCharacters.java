package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/alternating-characters">Problem</a>
 */
public class AlternatingCharacters
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) 
		{
			String s = scan.next();
			System.out.println(solve(s));
		}
		scan.close();
	}

	private static int solve(String s) 
	{
		int del = 0;
		int length = s.length();
		for (int i = 0; i < length-1; i++) 
		{
			while(i < length-1 && (s.charAt(i) == s.charAt(i+1))){
				del++;
				i++;
			}
		}
		return del;
	}
}
