package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LittlethiefShi 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int[] jewls = new int[n+1];
		for (int i = 1; i <=n; i++) {
			jewls[i] = scan.nextInt();
		}

		long[] dp = new long[n+3];
		for (int i = 3; i <= n+2; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-3] + jewls[i-2]);
		}
		System.out.println(dp[n+2]);
	}

	//--------------------------------------------------------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine(){
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	//--------------------------------------------------------
}
