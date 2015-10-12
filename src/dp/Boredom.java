package dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boredom 
{
	public static void main(String[] args) {
		InputReader scan = new InputReader(System.in);
		int n = scan.nextInt();
		long[] nums = new long[100000];
		for (int i = 0; i <n; i++) {
			nums[scan.nextInt()]++;
		}
		long[] dp = new long[n+1];
		dp[0]=0;
		dp[1]= nums[1];
		for(int i=2;i<=100000;i++){
			dp[i]=Math.max(dp[i-1],dp[i-2]+i*nums[i]);
		}
		System.out.println(dp[n]);
	}
	
	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
