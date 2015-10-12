package dp;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class PayingUp 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		int t = nextInt();
		while(t-->0){
			int n = nextInt();
			int m = nextInt();
			
			int[] coins = new int[n];
			for (int i = 0; i < n; i++) {
				coins[i] = nextInt();
			}
			
			solveBF(n,m,coins);
//			int ways = solveDP(n,m,coins);
//			if (ways>0) {
//				System.out.println("Yes");
//			}
//			else {
//				System.out.println("No");
//			}
		}
	}
	
	public static void solveBF(int n, int m, int[] coins) 
	{
		int last = 1 << n;
		for (int i = 0; i < last; i++)
		{
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1<<j)) > 0) {
					sum += coins[j];
				}
			}
			if (sum==m) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}

	public static int solveDP(int n, int sum, int[] coins) 
	{
		int[] dp = new int[sum + 1];
        dp[0] = 1;
        int currentSum =0;
        for (int i = 0; i < n; i++)
        {
            currentSum += coins[i];
            for (int j = Math.min(sum, currentSum); j >= coins[i]; j--) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
	}

	static int nextInt()
    {
        try {
            scan.nextToken();
            return (int)scan.nval;
        } catch (Exception e) {
            return -1;
        }
    }
}
