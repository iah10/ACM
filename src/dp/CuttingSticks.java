package dp;
import java.util.Scanner;

//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=944
public class CuttingSticks 
{
	static int[][] memo;
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) 
		{
			int l = scan.nextInt();
			if (l==0) {
				return;
			}
			int n = scan.nextInt();
			int[] positions = new int[n+2];
			for (int i = 1; i <=n; i++) 
			{
				positions[i] = scan.nextInt();
			}
			positions[n+1]=l;
			memo = new int[n+2][n+2];
			for (int i = 0; i <n+2; i++) {
				for (int j = 0; j<n+2 ; j++) {
					memo[i][j] = -1;
				}
			}
			int cost = solve(0,n+1, positions);
			System.out.printf("The minimum cutting is %d.\n" , cost);
		}
		scan.close();
	}

	private static int solve(int start ,int end, int[] positions) 
	{
		if(end-start==1){
			return 0;
		}
		
		if (memo[start][end] != -1) {
			return memo[start][end];
		}
		int cost = Integer.MAX_VALUE;
		for (int i = start+1; i <end; i++)
		{
			int val = positions[end] - positions[start] + solve(start,i,positions) + solve(i,end,positions);
			cost = Math.min(cost, val);
			memo[start][end] = cost;
		}
		return memo[start][end];
	}
}