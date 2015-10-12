package lcpc2014;

import java.util.Arrays;
import java.util.Scanner;

public class zone 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int qq = 1; qq <=t; qq++) 
		{
			int n = scan.nextInt();
			int k = scan.nextInt();
			System.out.printf("Case %d: %s\n",qq, solve(n,k)==0?"Losing":"Winning");
		}
		scan.close();
	}

	public static int solve(int n, int k) 
	{
		int[] dp = new int[n+1];
		for (int i = k; i <=n; i++) 
		{
			int nbMoves = i-k+1;
			int[] sg = new int[nbMoves];
			for (int j = 0; j<nbMoves; j++) {
				int leftGame = j;
				int rightGame = i-k-j;
				sg[j] = dp[leftGame] ^ dp[rightGame];
			}
			dp[i] = mex(sg);
		}
		return dp[n];
	}

	public static int mex(int[] sg) 
	{
		if(sg.length == 0) {
			return 0; 
		}
        Arrays.sort(sg);
        int mex = 0;
        for(int i = 0; i < sg.length; i++)
        {
            if(mex == sg[i]) {
            	mex++;
            } else if(mex < sg[i]) {
            	return mex; 
            }
        }
        return 1 + sg[sg.length - 1];
	}
}