package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

///http://codeforces.com/problemset/problem/115/A
public class Party 
{
	static int count;
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		
		int max = Integer.MIN_VALUE;
		int[] m = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int j = scan.nextInt();
			m[i] = j;
		}
		
		for (int i = 1; i <= n; i++) {
			int c = 1;
			int j = m[i];
			while (j != -1) { c++; j = m[j]; }
			max = Math.max(max, c);
		}
		System.out.println(max);
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
