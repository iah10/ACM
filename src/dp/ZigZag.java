package dp;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
public class ZigZag 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		int n = nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextInt();
		}
		System.out.println(solve(n,arr));
	}
	
	public static int solve(int n, int[] sequence) 
	{
		int maxZig =1;
		int[] dpL = new int[n];	//the subsequence length
		int[] dpTr = new int[n]; //last transition 
		
		//base case
		dpL[0] = 1;
		for (int i = 1; i < n; i++) 
		{
			dpL[i] = 1;
			for (int j = i-1; j >=0; j--) 
			{
				int dif= sequence[i]-sequence[j];
				int sign = dif > 0 ? 1 : -1;
				if (dif !=0 && sign != dpTr[j] && dpL[j] +1>dpL[i]) {
					dpL[i] = dpL[j]+1;
					dpTr[i] = sign;
				}
			}
			maxZig = Math.max(maxZig, dpL[i]);
		}
		return maxZig;
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
