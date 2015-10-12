package lcpc2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Question A - http://www.spoj.com/problems/LCPC12A/
public class JohnnyDividesBy2 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int T = scan.nextInt();
		for (int qq = 1; qq <= T; qq++)
		{
			String s = scan.next();
			int divides = 0;
			int doesNotDivide = 0;
			for (int i = 0; i < s.length(); i++) 
			{
				int num = s.charAt(i) - '0';
				if (num %2 ==0) {
					divides += i +1;
				} else {
					doesNotDivide += i +1;
				}
			}
			System.out.printf("%d. %d %d\n", qq, divides, doesNotDivide);
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
