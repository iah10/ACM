package lcpc2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class quest 
{
	static StreamTokenizer scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) 
	{
		int t = nextInt();
		int caseNum =0;
		while (caseNum++ <t) 
		{
			int n = nextInt();
			int m = nextInt();
			int[][] grid = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = nextInt();
				}
			}
			System.out.printf("Case %d: %d\n", caseNum, solve(n,m,grid));
		}
	}
	
	private static int solve(int n, int m, int[][] grid) 
	{
		int[][] memo = new int[n][m];
		memo[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			memo[0][i] = grid[0][i]+memo[0][i-1];
		}
		
		for (int i = 1; i < n; i++) {
			memo[i][0] = grid[i][0]+memo[i-1][0];
		}
		
		for (int i = 1; i <n; i++) 
		{
			for (int j = 1; j <m; j++) 
			{
				memo[i][j] = grid[i][j]+ Math.max(memo[i][j-1], memo[i-1][j]);
			}
		}
		return memo[n-1][m-1];
	}

	static int nextInt(){
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}
