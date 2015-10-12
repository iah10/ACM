package lcpc2014;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class tshirts 
{
	public static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		int t = nextInt();
		for (int cas = 1; cas <=t; cas++) 
		{
			int n = nextInt();
			long d = nextInt();
			long c = nextInt();
			long[] con = new long[n];
			for (int i = 0; i <n; i++)  {
				con[i] = nextInt();
			}
			Arrays.sort(con);
			long ans = d*n;
			for (int i = 0; i <n; i++) {
				long tmp = (i+1)*c*con[i];
				tmp += (n-i-1)*d;
				ans = Math.min(ans, tmp);
				
			}
			System.out.println("Case " + cas +": "+ ans);
		}
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
