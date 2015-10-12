package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DZYLovesChessboard 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();

		int n = scan.nextInt();
		int m = scan.nextInt();

		char[][]  board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			board[i] = line.toCharArray();
		}

		char good = '.';
		char bad = '-';
		
		char white = 'W';
		char black = 'B';
		
		char man = black;
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < m; j++) 
			{
				if (board[i][j]==good) {
					System.out.print(man);
				} else {
					System.out.print(bad);
				}
				man = man == black ? white : black;
			}
			if (m%2==0) {
				man = man == black ? white : black;
			}
			System.out.println();
		}
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
