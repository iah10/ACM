package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This Solution has O(1)complexity for the find largest method
 * @author iah10_000
 *
 */
public class LargestPermutation
{
	public static void main(String[] args) 
	{
		InputReader input = new InputReader(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] elements = new int[n];
		int[] telly = new int[n+1];
		for (int i = 0; i < n; i++) {
			elements[i] = input.nextInt();
			telly[elements[i]] = i;
		}
		
		//solve
		for(int i = 0;i < n && k >0 ;i++)
		{
			if(elements[i] != n-i ) //if the max is ourselves don't swap
			{
				k--;
				int maxIndex = telly[n-i];
				elements[maxIndex] = elements[i];
				elements[i] = n-i;
				telly[elements[i]] = i;
				telly[elements[maxIndex]] = maxIndex;
			}
		}
		
		for (int j = 0; j < n; j++) {
			System.out.print(elements[j] +" ");
		}
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