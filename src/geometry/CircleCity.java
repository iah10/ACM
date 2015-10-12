package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CircleCity 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int T = scan.nextInt();
		while(T-->0)
		{
			int d = scan.nextInt();
			int k = scan.nextInt();
			
			int xMax = (int) Math.ceil(Math.sqrt(d));
			
			int count = 0;
			for (int x = 1; x <= xMax; x++)
			{
				int y = d - x*x;
				double yDouble = Math.sqrt(y);
				int yInt = (int)yDouble;
				if (yDouble==yInt) {
					count +=4;
				}
			}
			
			if (count > k) {
				System.out.println("impossible");
			} else {
				System.out.println("possible");
			}
			
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
