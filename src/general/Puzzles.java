package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//http://codeforces.com/problemset/problem/337/A
public class Puzzles 
{
	public static void main(String[] args) 
	{
		InputReader scan = new InputReader(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] f = new int[m];
		for (int i = 0; i < m; i++) {
			f[i] = scan.nextInt();
		}
		Arrays.sort(f);
		int minDif = Integer.MAX_VALUE;
		for (int i = 0; i <=f.length-n; i++) {
			minDif = Math.min(minDif, f[i+n-1]-f[i]);
		}
		System.out.println(minDif);
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
