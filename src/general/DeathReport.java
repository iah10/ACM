package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DeathReport 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		String n = scan.next();
		String[] parts =  new String(n+"").split("\\.");
		long denum = 100;
		String s1 = (int)Double.parseDouble(n)+"";
		if (parts.length==2 && Long.parseLong(parts[1])!=0) {
			s1 = s1+ parts[1];
			denum *= (long) Math.pow(10,parts[1].length());
		}

		long num = Long.parseLong(s1);
		long gcd = gcd(num, denum);
		System.out.println(denum/gcd);
	}

	public static long gcd(long p, long q) 
	{
		while (q != 0) {
			long temp = q;
			q = p % q;
			p = temp;
		}
		return p;
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
