package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class LuxuriousHouses 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = scan.nextInt();
		}
		
		int maxFloors = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = n-1; i >=0; i--) 
		{
			if (h[i]>maxFloors) {
				maxFloors = h[i];
				stack.push(0);
			} else {
				stack.push(maxFloors-h[i]+1);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
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
