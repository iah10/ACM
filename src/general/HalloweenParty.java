package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/halloween-party">Problem</a>
 */
public class HalloweenParty 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) 
		{
			int test = scan.nextInt();
			long mid1 = test/2;
			long mid2 = (test+1)/2;
			long temp = mid1*mid1;
			long result = test%2==0 ? temp : mid1 * mid2;
			System.out.println(result);
		}
		scan.close();
	}
}
