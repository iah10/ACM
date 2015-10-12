package dp;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class BadNeighbors 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));

	public static void main(String[] args) 
	{
		int n = nextInt();
		int[] donations = new int[n];
		for (int i = 0; i < n; i++) {
			donations[i] = nextInt();
		}
		System.out.println(maxDonations(donations));
	}

	public static int maxDonations(int[] donations)
	{
		return Math.max(maxDonations(donations, 0, donations.length-1), maxDonations(donations, 1, donations.length));
	}
	
	private static int maxDonations(int[] donations, int start, int end)
	{
		int n = donations.length;
		int[] dp = new int[n];	//max sum until n
		int maxDon = 0;
		for (int i = start; i < end; i++) 
		{
			dp[i] =donations[i];
			dp[i] = Math.max(i>=2 ? donations[i]+dp[i-2] : dp[i], i >=3 ?  donations[i]+dp[i-3]: dp[i]);
			maxDon = Math.max(maxDon, dp[i]);
		}
		return maxDon;
	}
	
	static int nextInt() 
	{
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}
