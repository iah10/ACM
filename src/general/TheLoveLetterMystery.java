package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/the-love-letter-mystery">Problem</a>
 */
public class TheLoveLetterMystery 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) 
		{
			String test = scan.next();
			int nbOfStep = steps(test);
			System.out.println(nbOfStep);
		}
		scan.close();
	}

	private static int steps(String test) 
	{
		int steps = 0;
		int strLength = test.length();
		int left = 0;
		int right= strLength-1;
		while ( right-left > -1) {
			steps+=Math.abs(test.charAt(left++) - test.charAt(right--));
		}
		return steps;
	}
}
