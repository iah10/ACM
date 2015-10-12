package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KefaAndCompany
{
	public static class Friend implements Comparable<Friend>{
		int money;
		int factor;
		
		public Friend(int money, int factor) {
			this.money = money;
			this.factor = factor;
		}

		@Override
		public int compareTo(Friend o) {
			return Integer.compare(money, o.money);
		}
	}

	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int N = scan.nextInt();
		int D = scan.nextInt();
		
		Friend[] friends = new Friend[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new Friend(scan.nextInt(),scan.nextInt());
		}
		
		Arrays.sort(friends);
		
		long ans = 0;
		long tempFact  = 0;
		
		int j=0;
		for (int i = 0; i < N; i++) 
		{
			while (j< N && friends[j].money - friends[i].money < D) 
			{
				tempFact += friends[j].factor;
				ans = Math.max(tempFact, ans);
				j++;
			}
			tempFact -= friends[i].factor;
			
		}
		
		System.out.println(ans);
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
