package gametheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/half
public class AStonesGameHalf
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int T = scan.nextInt();
		while (T-->0) 
		{
			int piles = scan.nextInt();
			int ans = solve(piles);
			System.out.println(ans ==0 ? "P1 Loses" : "P2 Wins");
		}
	}

	public static int solve(int piles) 
	{
		int[] sg = new int[piles+1];
		sg[1]=1;

		int result = 1;
		for (int pile = 2; pile <= piles; pile++) 
		{
			int sgForPile = g(pile, sg);
			sg[pile] = sgForPile;
			result ^= sgForPile;
		}
		return result;
	}

	public static int g(int pile, int[] sg) 
	{
		int half = Math.round(1f*pile/2);
		Set<Integer> set = new HashSet<Integer>();
		for (int remainingGame = half; remainingGame <= pile; remainingGame++) {
			set.add(sg[remainingGame]);
		}
		int i = 0;
		while (!set.contains(i)){
			i++;
		}
		return i;
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
