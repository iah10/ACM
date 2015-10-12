package dp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * Given two n-tuples of positive numbers and W > 0
 * 
 * Maximize vi such that sum(vi) <=W
 */
public class Knapsack 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in)); 

	static int nextInt()  {
		try {
			scan.nextToken();
			return (int) scan.nval;
		}
		catch(IOException e) {
			return -1;
		}
	}

	public static void main(String[] args) 
	{
		int n = nextInt();
		
		int[] v = new int[n];
		int[] s = new int[n];
		
		for (int i = 0; i < n; i++) {
			v [i] = nextInt();
			s[i] = nextInt();
		}
		
		int w = nextInt();
		solve(n, v, s, w);
	}

	private static void solve(int n, int[] val, int[] wt, int W) 
	{
		int[][] memo = new int[n+1][W+1];
		for (int i = 1; i <=n; i++) 
		{
			for (int w = 1; w <=W; w++) 
			{
				if(wt[i-1]<=w)	//if the weight is less than current  weight
					memo[i][w] = Math.max(memo[i-1][w], val[i-1]+memo[i-1][w-wt[i-1]]);
				else
					memo[i][w] = memo[i-1][w];
			}
		}
		System.out.println(memo[n][W]);
	}
}
