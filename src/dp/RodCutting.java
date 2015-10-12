package dp;

import java.util.Scanner;

/*
 * Given a rod of length n inches and a
 * table of prices pi for i D 1;2; : : : ;n, determine the maximum revenue rn obtainable
 * by cutting up the rod and selling the pieces.
 */
public class RodCutting 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int p = scan.nextInt();	//position to cut
		int[] length = new int[n];
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			length[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			prices[i] = scan.nextInt();
		}
		solve(length, prices, p);
		//System.out.println(solveR(length, prices, p));
		scan.close();
	}

	private static void solve(int[] length, int[] prices, int p) 
	{
		int[] memo = new int[p+1];
		int[] s = new int[p+1];
		memo[0]=0;
		for (int i = 1; i <=p; i++) 
		{
			int q = Integer.MIN_VALUE;
			for (int j = 1; j <=i; j++) 
			{
				if (q < prices[j-1]+memo[i-j]) {
					q = prices[j-1]+memo[i-j];
					s[i]=j;
				}
			}
			memo[i]=q;
		}
		System.out.println(memo[p]);
		
		//print solution
		while(p>0){
			System.out.println(s[p]);
			p -=s[p];
		}
	}

	public static int solveR(int[] length, int[] prices, int p)
	{
		if (p == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for (int i = 0; i < p; i++) {
			q= Math.max(q, prices[i] + solveR(length, prices, p-i-1));
		}
		return q;
	}
}
