package dp;

import java.util.Scanner;

/*
 * Given a value N, if we want to make change for N cents
 * 
 * Min number of coins ?
 */
public class MinCoinChange 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int sum = scan.nextInt();
		int m = scan.nextInt();		//number of coins
		int[] coins = new int[m];
		for (int i = 0; i < m; i++) {
			coins[i] = scan.nextInt();
		}
		solve(sum, coins);
		scan.close();
	}

	private static void solve(int sum, int[] coins) 
	{
		int[] memo = new int[sum+1];
		
		for (int i = 1; i <=sum; i++) 
		{
			memo[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) 
			{
				if (coins[j] <=i) {
					memo[i] = Math.min(1 + memo[i-coins[j]], memo[i]);
				}
			}
		}
		System.out.println(memo[sum]);
	}
}
