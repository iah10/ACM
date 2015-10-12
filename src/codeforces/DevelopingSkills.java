package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DevelopingSkills 
{
	static class Float implements Comparable<Float>{
		float ai;
		Float(float a){
			ai = a;
		}
		@Override
		public int compareTo(Float o) {
			int dif1 = (int) (10*Math.ceil(ai/10)-ai);
			int diff2 = (int) (10*Math.ceil(o.ai/10)-o.ai);
			return Integer.compare(dif1, diff2);
		}
	}
	public static void main(String[] args) 
	{
		Float test[] = {new Float(26), new Float(45), new Float(30), new Float(87)};
		Arrays.sort(test);
		for (Float float1 : test) {
			System.out.print(float1.ai+" ");
		}
		System.out.println();
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int k = scan.nextInt();
		Float[] a = new Float[n];

		for (int i = 0; i < n; i++) {
			a[i] = new Float(scan.nextInt());
		}
		
		Arrays.sort(a);

		for (int j = 0; j < a.length; j++) 
		{
			int cur = (int) (10 - (a[j].ai % 10 ));
			if (cur <=k) {
				a[j].ai += cur;
				k -= cur;
			} else if(cur > k){
				break;
			}
		}
		
		long rating = 0;
		for (int j = 0; j < a.length; j++) 
		{
			rating += Math.floor(a[j].ai/10);
		}
		
		System.out.println(rating);
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
