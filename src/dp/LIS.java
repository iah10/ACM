package dp;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

//longest increasing subsequence
public class LIS 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		int n = nextInt();
		int[] seq = new int[n];
		for (int i = 0; i < n; i++) {
			seq[i] = nextInt();
		}
		System.out.println(solve(n, seq));
	}

	private static int solve(int N,int[] array) 
	{
		int maxLength = 1, bestEnd = 0;
		int[] DP = new int[N];
		int[] prev = new int[N];
		DP[0] = 1;
		prev[0] = -1;

		for (int i = 1; i < N; i++)
		{
		   DP[i] = 1;
		   prev[i] = -1;

		   for (int j = i - 1; j >= 0; j--) 
		   {
			   //First check if number at index j is less than num at i.
               // Second the length of that DP should be greater than dp[i]
               // -1 since dp of previous could also be one. So we compare the dp[i] as empty initially
		      if (DP[j] + 1 > DP[i] && array[j] < array[i])
		      {
		         DP[i] = DP[j] + 1; ////Assigning temp length of LIS. There may come along a bigger LIS of a future a[j]
		         prev[i] = j;
		      }
		   }

		   if (DP[i] > maxLength)
		   {
		      bestEnd = i;
		      maxLength = DP[i];
		   }
		}
		
		int i=bestEnd;
		Stack<Integer> stack = new Stack<Integer>();
		while (i !=-1) {
			stack.push(array[i]);
			i = prev[i];
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		return maxLength;
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
