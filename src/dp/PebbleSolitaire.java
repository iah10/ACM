package dp;

import java.util.Arrays;
import java.util.Scanner;

//https://uva.onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1592
public class PebbleSolitaire 
{

	static int memo[] = new int[1<<12];
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) 
		{
			String game = scan.next();

			int mask = 0;
			for (int j = 0; j < 12; j++) {
				if (game.charAt(j)=='o') {
					mask |= (1<<j);
				}
			}
			Arrays.fill(memo, -1);
			ans = 12;
			solve(mask);
			System.out.println(ans);
		}
		scan.close();
	}
	
	static boolean isSet(int s, int i) {
		return (s & (1 << i)) != 0;
	}

	static int ans = 12;
	public static void solve(int s) 
	{
		if (s == (1 << 12) - 1) return;

		boolean moved = false;
		for (int i = 0; i < 11; ++i) {
			if (isSet(s, i) && isSet(s, i + 1)) {
				if (i > 0 && !isSet(s, i - 1)) {
					int nxt = s;
					nxt ^= (1 << i - 1);
					nxt ^= (1 << i);
					nxt ^= (1 << i + 1);
					moved = true;
					solve(nxt);
				}
				if (i < 10 && !isSet(s, i + 2)) {
					int nxt = s;
					nxt ^= (1 << i);
					nxt ^= (1 << i + 1);
					nxt ^= (1 << i + 2);
					moved = true;
					solve(nxt);
				}
			}
		}
		if (!moved)
			ans = Math.min(ans, Integer.bitCount(s));
		//		if (memo[mask] != -1) {
		//			return memo[mask];
		//		}

		//		int ret = Integer.bitCount(s);
		//		boolean moved = false;
		//		for (int i = 0; i < 10; i++) 
		//		{
		//			// case: oo-
		//			if (isbitSet(s, i) && isbitSet(s, i+1) && !isbitSet(s, i+2)) {
		//				s = setBit(s, i, 0);
		//				s = setBit(s, i+1, 0);
		//				s = setBit(s, i+2, 1);
		//				moved = true;
		//				go(s);
		//			} 
		//			//case: -oo
		//			else if(!isbitSet(s, i) && isbitSet(s, i+1) && isbitSet(s, i+2)) {
		//				s = setBit(s, i, 1);
		//				s = setBit(s, i+1, 0);
		//				s = setBit(s, i+2, 0);
		//				moved = true;
		//				go(s);
		//			}
		//		}
		//		if (moved) ans = Math.min(ret, ans);
	}

//	public static int setBit(int mask, int position, int zeroOrOne) {
//		if (zeroOrOne==1) {
//			return (mask | (1<<position));
//		} else {
//			return (mask & ~(1<<position));
//		}
//	}
//
//	public static boolean isbitSet(int mask, int position) {
//		return  (mask & (1<<position)) !=0;
//	}
}