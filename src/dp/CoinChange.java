package dp;

import java.util.Scanner;

/*
 * Given a value N, if we want to make change for N cents
 * 
 * How many ways can we make the change ?
 */
public class CoinChange 
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
		solve(sum,m,coins);
		scan.close();
	}

	/*
	 *  e.g. S = 4 N= 3 coins {1,2,3}
	 *  4 solutions {1,1,1,1} {1,1,2} {2,2} {1,3}
	 *  think about the the solutions as SETs {1} {1,2} {2} {1,3}
	 *  p[i - coins[j-1]][j] means that i took the coin Cj, what is the number of solutions for the new sum i-Cj ?
	 */
	private static void solve(int sum, int m, int[] coins) 
	{	
		int p[][] = new int[sum + 1][m + 1];
		//i represents the money
		for (int i = 0; i <= sum; i++) 
		{
			//j represents the number of coins we are using
			for (int j = 0; j <= m; j++) 
			{
				if (i == 0) {
					p[i][j] = 1;	// we have no money, exactly one way to solve the problem to choose coin change of 0
				} else if (j == 0) {
					p[i][j] = 0; //no solution -- we have money, but no change available
				} else {
					if (coins[j-1] > i) {	
						p[i][j] = p[i][j-1]; // the value of the current coin is bigger than the sum inherit the solution
					} else {
						//p[i][j-1] number of solutions excluding coin Cj
						//p[i - coins[j-1]][j] number of solution including coin Cj
						p[i][j] = p[i][j-1] + p[i - coins[j-1]][j];
					}
				}
			}
		}
		System.out.println(p[sum][m]);
	}
}