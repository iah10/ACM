package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BerSUBall 
{
	public static void main(String[] args) 
	{
		MyScanner scan  = new MyScanner();
		
		int n = scan.nextInt();
		
		int[] boys = new int[n];
		for (int i = 0; i < n; i++) {
			boys[i] = scan.nextInt();
		}
		
		int m = scan.nextInt();
		int[] girls = new int[m];
		for (int i = 0; i < m; i++) {
			girls[i] = scan.nextInt();
		}
		
		solve(n, m, boys, girls);
	}

	public static void solve(int n, int m, int[] boys, int[] girls) 
	{
		Arrays.sort(boys);
		Arrays.sort(girls);
		
		int gp = 0;
		int pairs = 0;
		for (int i = 0; i < n; i++) 
		{
			boolean found = false;
			int j;
			for (j = gp; j < m && !found; j++) 
			{
				int diff = boys[i] - girls[j];
				if (j < m && (diff==-1 || diff==0 || diff==1) && !found) {
					pairs++;
					found=true;
				}
			}
			if (found) {
				gp = j;
			}
			
		}
		System.out.println(pairs);
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
