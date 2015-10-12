package gametheory;

import java.util.Scanner;

//https://www.codechef.com/problems/RESN04/
public class StoneGame 
{
	private static Scanner scan;

	public static void main(String[] args) 
	{
		scan = new Scanner(System.in);
		int t =scan.nextInt();
		for (int qq = 0; qq < t; qq++) {
			System.out.println((solve() %2!=0 ?  "ALICE": "BOB" ));
		}
		scan.close();
	}

	private static int solve() {
		int n = scan.nextInt();
		int moves = 0;
		for (int i = 1; i <=n; i++) {
			moves += scan.nextInt() /i;
		}
		return moves;
	}

///////Sum of Games
//	public class Main {
//
//		public static int g(int i, int x) {
//			return (x / i) % 2;
//		}
//
//		public static void main(String[] args) {
//			Scanner scan = new Scanner(System.in);
//			int t = scan.nextInt();
//			for (int j = 0; j < t; ++j) {
//				int n = scan.nextInt();
//				int sg = 0;
//				for (int i = 1; i <= n; ++i) {
//					int x = scan.nextInt();
//					sg ^= g(i, x);
//				}
//				System.out.println(sg == 0? "BOB" : "ALICE");
//			}
//		}
//	} 
}
